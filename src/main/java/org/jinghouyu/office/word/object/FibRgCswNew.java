package org.jinghouyu.office.word.object;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeShort;

public class FibRgCswNew {
	
	private static final int TYPE_2000_1 = 0x00D9;
	private static final int TYPE_2000_2 = 0x0101;
	private static final int TYPE_2000_3 = 0x010C;
	private static final int TYPE_2007_1 = 0x0112;
	
	private int nFibNew;
	private int cQuickSavesNew;
	
	public static FibRgCswNew parse(InputStream in) throws IOException {
		FibRgCswNew r = new FibRgCswNew();
		int type = LeShort.toShort(IOUtils.readFully(in, 2));
		r.cQuickSavesNew = LeShort.toShort(IOUtils.readFully(in, 2));
		switch(type) {
		case TYPE_2007_1 : IOUtils.readFully(in, 6);
		}
		r.nFibNew = type;
		return r;
	}
	
	public int getcQuickSavesNew() {
		return this.cQuickSavesNew;
	}
	
	public int getnFibNew() {
		return this.nFibNew;
	}
}
