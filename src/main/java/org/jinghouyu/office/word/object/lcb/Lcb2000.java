package org.jinghouyu.office.word.object.lcb;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;

public class Lcb2000 extends Lcb97 {

	private long fcPlcfTch;
	private long lcbPlcfTch;
	private long fcRmdThreading;
	private long lcbRmdThreading;
	private long fcMid;
	private long lcbMid;
	private long fcSttbRgtplc;
	private long lcbSttbRgtplc;
	private long fcMsoEnvelope;
	private long lcbMsoEnvelope;
	private long fcPlcfLad;
	private long lcbPlcfLad;
	private long fcRgDofr;
	private long lcbRgDofr;
	private long fcPlcosl;
	private long lcbPlcosl;
	private long fcPlcfCookieOld;
	private long lcbPlcfCookieOld;
	private long fcPgdMotherOld;
	private long lcbPgdMotherOld;
	private long fcBkdMotherOld;
	private long lcbBkdMotherOld;
	private long fcPgdFtnOld;
	private long lcbPgdFtnOld;
	private long fcBkdFtnOld;
	private long lcbBkdFtnOld;
	private long fcPgdEdnOld;
	private long lcbPgdEdnOld;
	private long fcBkdEdnOld;
	private long lcbBkdEdnOld;

	public void parse(InputStream in) throws IOException {
		super.parse(in);
		this.fcPlcfTch = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfTch = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcRmdThreading = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbRmdThreading = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcMid = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbMid = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbRgtplc = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbRgtplc = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcMsoEnvelope = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbMsoEnvelope = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfLad = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfLad = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcRgDofr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbRgDofr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcosl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcosl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfCookieOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfCookieOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPgdMotherOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPgdMotherOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcBkdMotherOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbBkdMotherOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPgdFtnOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPgdFtnOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcBkdFtnOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbBkdFtnOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPgdEdnOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPgdEdnOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcBkdEdnOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbBkdEdnOld = LeInteger.toInteger(IOUtils.readFully(in, 4));

	}
}