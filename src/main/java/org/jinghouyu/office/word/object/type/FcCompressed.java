package org.jinghouyu.office.word.object.type;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.ByteUtils;
import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;

public class FcCompressed {
	
	private int textOffset;
	private boolean compressed;

	public static FcCompressed parse(InputStream in) throws IOException {
		FcCompressed c = new FcCompressed();
		byte[] data = IOUtils.readFully(in, 4);
		byte lastByte = data[3];
		long offset = LeInteger.toInteger(data);
		c.textOffset = (int) (offset & 0x3FFFFFFF);
		c.compressed = ByteUtils.getValue(lastByte, 1, 1) == 1;
		return c;
	}

	public int getTextOffset() {
		return textOffset;
	}

	public boolean isCompressed() {
		return compressed;
	}
}