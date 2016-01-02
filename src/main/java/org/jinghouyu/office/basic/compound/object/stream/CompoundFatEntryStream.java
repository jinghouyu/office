package org.jinghouyu.office.basic.compound.object.stream;

import java.io.IOException;

import org.jinghouyu.office.basic.compound.object.CompoundFatEntry;
import org.jinghouyu.office.basic.compound.object.CompoundFile;
import org.jinghouyu.office.basic.compound.utils.stream.LengthInputStream;
import org.jinghouyu.office.basic.compound.utils.stream.SeekableInputStream;

public class CompoundFatEntryStream extends SeekableInputStream {
	
	private LengthInputStream in;
	
	public CompoundFatEntryStream(CompoundFile file, CompoundFatEntry entry) throws IOException {
		SeekableInputStream in = file.getSourceInputStream();
		in.seek(file.getOffset((int) entry.getSectorIndex()));
		this.in = new LengthInputStream(in, file.getOffset((int) entry.getSectorIndex()), file.getSectorSize());
	}
	

	public int read(byte[] data) throws IOException{
		return in.read(data);
	}
	
	public int read(byte[] data, int off, int len) throws IOException {
		return in.read(data, off, len);
	}

	public int read() throws IOException {
		return in.read();
	}
	
	public boolean isReadOver() {
		return in.hasOver();
	}


	@Override
	public long getReaded() {
		return in.getReaded();
	}


	@Override
	public void seek(long pos) throws IOException {
		in.seek(pos);
	}
}