package org.jinghouyu.office.basic.compound.utils.stream;

import java.io.IOException;

public class LengthInputStream extends SeekableInputStream {
	
	private long originReaded;
	private SeekableInputStream in;
	private long length;
	
	private long readed;
	
	public long getReaded() {
		return this.readed;
	}
	
	public LengthInputStream(SeekableInputStream in, long originReaded, long length) {
		this.originReaded = originReaded;
		this.in = in;
		this.length = length;
	}
	
	public boolean hasOver() {
		return readed >= length;
	}
	
	private byte[] read1 = new byte[1];

	@Override
	public int read() throws IOException {
		int len = read(read1);
		if(len == -1) return -1;
		return read1[0] & 0xFF;
	}

	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		if(readed >= length) return -1;
		long elseLen = length - readed;
		int elseLength = elseLen > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) elseLen;
		int readLen = in.read(b, off, Math.min(elseLength, len));
		if(readLen == -1) return -1;
		readed += readLen;
		return readLen;
	}
	
	private byte[] useToSkip = new byte[1024 * 10];

	@Override
	public long skip(long n) throws IOException {
		long skipped = 0;
		while(true) {
			long elseLen = n - skipped;
			int elseLength = elseLen > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) elseLen;
			int len = read(useToSkip, 0, Math.min(useToSkip.length, elseLength));
			if(len == -1) {
				break;
			}
			skipped += len;
			if(skipped >= len) {
				break;
			}
		}
		return skipped;
	}
	
	@Override
	public void seek(long pos) throws IOException {
		if(pos == readed) return;
		if(pos >= length) {
			throw new IOException("stream out of bounds " + pos);
		}
		in.seek(this.originReaded + pos);
		this.readed = pos;
	}

	@Override
	public int available() throws IOException {
		long elseLen = length - readed;
		return Math.min(in.available(), elseLen > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) elseLen);
	}

	@Override
	public void close() throws IOException {
		skip(Long.MAX_VALUE);  //exthaust
	}
	
	@Override
	public synchronized void mark(int readlimit) {
		throw new UnsupportedOperationException();
	}

	@Override
	public synchronized void reset() throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean markSupported() {
		return false;
	}
}
 