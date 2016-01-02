package org.jinghouyu.office.word.object;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeShort;
public class FIBRgW97 {
	
	private int lidFE;
	
	public static FIBRgW97 parse(InputStream in) throws IOException {
		FIBRgW97 r = new FIBRgW97();
		IOUtils.readFully(in, 26);
		r.lidFE = LeShort.toShort(IOUtils.readFully(in, 2));
		return r;
	}
	
	public int getLidFE() {
		return this.lidFE;
	}
}
