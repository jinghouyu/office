package org.jinghouyu.office.word.object.type;

import org.jinghouyu.office.basic.compound.utils.ByteUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeShort;

public class Sprm {

	private int ispmd;
	private boolean spec;
	private int sgc;
	private int spra;

	public static Sprm parse(byte[] data) {
		Sprm sprm = new Sprm();
		int value = LeShort.toShort(data);
		sprm.ispmd = value & 0x01FF;
		sprm.spec = ((value / 512) & 0x0001) == 1;
		sprm.sgc = (value / 1024) & 0x0007;
		sprm.spra = value / 8192;
		return sprm;
	}

	public int getIspmd() {
		return ispmd;
	}

	public boolean isSpec() {
		return spec;
	}

	public int getSgc() {
		return sgc;
	}

	public int getSpra() {
		return spra;
	}

}