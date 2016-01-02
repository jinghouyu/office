package org.jinghouyu.office.word.object.lcb;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;

public class Lcb2007 extends Lcb2003 {

	private long fcPlcfmthd;
	private long lcbPlcfmthd;
	private long fcSttbfBkmkMoveFrom;
	private long lcbSttbfBkmkMoveFrom;
	private long fcPlcfBkfMoveFrom;
	private long lcbPlcfBkfMoveFrom;
	private long fcPlcfBklMoveFrom;
	private long lcbPlcfBklMoveFrom;
	private long fcSttbfBkmkMoveTo;
	private long lcbSttbfBkmkMoveTo;
	private long fcPlcfBkfMoveTo;
	private long lcbPlcfBkfMoveTo;
	private long fcPlcfBklMoveTo;
	private long lcbPlcfBklMoveTo;
	private long fcUnused1;
	private long lcbUnused1;
	private long fcUnused2;
	private long lcbUnused2;
	private long fcUnused3;
	private long lcbUnused3;
	private long fcSttbfBkmkArto;
	private long lcbSttbfBkmkArto;
	private long fcPlcfBkfArto;
	private long lcbPlcfBkfArto;
	private long fcPlcfBklArto;
	private long lcbPlcfBklArto;
	private long fcArtoData;
	private long lcbArtoData;
	private long fcUnused4;
	private long lcbUnused4;
	private long fcUnused5;
	private long lcbUnused5;
	private long fcUnused6;
	private long lcbUnused6;
	private long fcOssTheme;
	private long lcbOssTheme;
	private long fcColorSchemeMapping;
	private long lcbColorSchemeMapping;

	public void parse(InputStream in) throws IOException {
		super.parse(in);
		this.fcPlcfmthd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfmthd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfBkmkMoveFrom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfBkmkMoveFrom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBkfMoveFrom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBkfMoveFrom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBklMoveFrom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBklMoveFrom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfBkmkMoveTo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfBkmkMoveTo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBkfMoveTo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBkfMoveTo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBklMoveTo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBklMoveTo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused1 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused1 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused2 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused2 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused3 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused3 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfBkmkArto = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfBkmkArto = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBkfArto = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBkfArto = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBklArto = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBklArto = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcArtoData = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbArtoData = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused4 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused4 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused5 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused5 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused6 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused6 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcOssTheme = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbOssTheme = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcColorSchemeMapping = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbColorSchemeMapping = LeInteger.toInteger(IOUtils.readFully(in, 4));
	}
}