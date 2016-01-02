package org.jinghouyu.office.basic.compound.object.stream;

import java.io.IOException;
import java.util.List;

import org.jinghouyu.office.basic.compound.object.CompoundFatEntry;
import org.jinghouyu.office.basic.compound.object.CompoundFile;
import org.jinghouyu.office.basic.compound.utils.stream.SeekableInputStream;

public class CompoundFatStream extends SeekableInputStream {
	
	private CompoundFile file;
	private List<CompoundFatEntry> chain;
	private long readed;
	private long size;
	
	private CompoundFatEntryStream currentInputStream;
	
	private int index = -1;
	
	private CompoundFatEntryStream getCurrentInputStream() throws IOException {
		if(currentInputStream == null) {
			index = 0;
			return currentInputStream = new CompoundFatEntryStream(file, chain.get(index));
		}
		if(currentInputStream.isReadOver()) {
			index++;
			return currentInputStream = new CompoundFatEntryStream(file, chain.get(index));
		}
		return currentInputStream;
	}
	
	public CompoundFatStream(CompoundFile file, List<CompoundFatEntry> chain, long size) {
		this.file = file;
		this.chain = chain;
		this.size = size;
	}
	
	public int read(byte[] data) throws IOException{
		return read(data, 0, data.length);
	}
	
	public int read(byte[] data, int off, int len) throws IOException {
		long elseSize = size - readed;
		if(elseSize >= Integer.MAX_VALUE) {
			elseSize = Integer.MAX_VALUE;
		}
		int readedLen = Math.min((int) elseSize, len);
		int readLen = getCurrentInputStream().read(data, off, readedLen);
		if(readLen == -1) return -1;
		readed += readLen;
		return readLen;
	}
	
	private byte[] read0 = new byte[1];

	@Override
	public int read() throws IOException {
		int readed = read(read0);
		if(readed == -1) return readed;
		return read0[0] & 0xFF;
	}

	@Override
	public long getReaded() {
		return this.readed;
	}

	@Override
	public void seek(long pos) throws IOException {
		if(pos == readed) return;
		if(readed >= size) {
			throw new IOException("stream out of bounds " + pos);
		}
		readed = pos;
		int sectorSize = file.getSectorSize();  //sectorSize
		int index = (int) (pos / sectorSize);
		int offset = (int) (pos % sectorSize);
		CompoundFatEntryStream stream = null;
		if(index == this.index) {
			stream = currentInputStream;
		} else {
			this.index = index;
			stream = new CompoundFatEntryStream(file, chain.get(index));
			currentInputStream = stream;
		}
		stream.seek(offset);
	}
}