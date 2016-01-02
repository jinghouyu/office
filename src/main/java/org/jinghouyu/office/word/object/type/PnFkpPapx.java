package org.jinghouyu.office.word.object.type;

import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;

public class PnFkpPapx {

	private int pn;
	
	public static PnFkpPapx parse(byte[] data) {
		int value = (int) LeInteger.toInteger(data);
		PnFkpPapx r = new PnFkpPapx();
		r.pn = value & 0x003FFFFF;
		return r;
	}
	

	public long getPapxFkpOffset() {
		return 512L * pn;
	}
}