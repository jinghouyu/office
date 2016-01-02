package org.jinghouyu.office.basic.compound.utils.stream;

import java.io.IOException;
import java.io.InputStream;

public class ReadedInputStream extends InputStream {
	
	private InputStream in;
	
	public ReadedInputStream() {
	}
	
	public ReadedInputStream(InputStream in) {
		this.in = in;
	}
	
	private long readed;
	
	public long getReaded() {
		return this.readed;
	}

	@Override
	public int read() throws IOException {
		int d = in.read();
		if(d == -1) return -1;
		readed ++;
		return d;
	}

	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int readLen = in.read(b, off, len);
		if(readLen == -1) return -1;
		readed += readLen;
		return readLen;
	}

	@Override
	public long skip(long n) throws IOException {
		long skipped = super.skip(n);
		if(skipped > 0) {
			readed += skipped;
		}
		return readed;
	}

	
	
	@Override
	public int available() throws IOException {
		return in.available();
	}

	@Override
	public void close() throws IOException {
		in.close();
	}

	@Override
	public synchronized void mark(int readlimit) {
		in.mark(readlimit);
	}

	@Override
	public synchronized void reset() throws IOException {
		in.reset();
	}

	@Override
	public boolean markSupported() {
		return in.markSupported();
	}
}