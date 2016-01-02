package org.jinghouyu.office.basic.compound.utils.stream;

import java.io.IOException;

public class ByteArraySeekableInputStream extends SeekableInputStream {
	
	private byte[] datas;
	private int off;
	private int length;
	
	private int readed = 0;
	
	public ByteArraySeekableInputStream(byte[] datas, int off, int length) {
		this.datas = datas;
		this.off = off;
		this.length = length;
	}
	
	public ByteArraySeekableInputStream(byte[] datas) {
		this(datas, 0, datas.length);
	}
	
	public void seek(long pos) throws IOException {
		if(pos >= length) {
			throw new IOException("stream out the end ");
		}
		if(pos < 0) {
			throw new IOException("pos is negative");
		}
		readed = (int) pos;
	}
	
	public long getReaded() {
		return this.readed;
	}
	
	@Override
	public int read() throws IOException {
		if(readed >= length) return -1;
		return datas[off + readed++] & 0xFF;
	}

	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int elseLen = length - readed;
		if(elseLen <= 0) return -1;
		len = Math.min(elseLen, len);
		System.arraycopy(datas, this.off + readed, b, off, len);
		readed += len;
		return len;
	}

	@Override
	public long skip(long n) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int available() throws IOException {
		return length - readed;
	}

	@Override
	public void close() throws IOException {
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
		throw new UnsupportedOperationException();
	}
}