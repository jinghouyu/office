package org.jinghouyu.office.basic.compound.utils.stream;

import java.io.IOException;


public abstract class SeekableInputStream extends ReadedInputStream {

	public abstract long getReaded();
	
	public abstract void seek(long pos) throws IOException;
	
}
