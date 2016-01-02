package org.jinghouyu.office.word.object;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;

public class FIBRgLw97 {

	private long cbMac;
	private long ccpText;
	private long ccpFtn;
	private long ccpHdd;
	private long ccpMcr;
	private long ccpAtn;
	private long ccpEdn;
	private long ccpTxbx;
	private long ccpHdrTxbx;

	public static FIBRgLw97 parse(InputStream in) throws IOException {
		FIBRgLw97 r = new FIBRgLw97();
		r.cbMac = LeInteger.toInteger(IOUtils.readFully(in, 4));
		IOUtils.readFully(in, 8);
		r.ccpText = LeInteger.toInteger(IOUtils.readFully(in, 4));
		r.ccpFtn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		r.ccpHdd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		r.ccpMcr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		r.ccpAtn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		r.ccpEdn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		r.ccpTxbx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		r.ccpHdrTxbx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		IOUtils.readFully(in, 44);
		return r;
	}

	public long getCbMac() {
		return cbMac;
	}

	public long getCcpText() {
		return ccpText;
	}

	public long getCcpFtn() {
		return ccpFtn;
	}

	public long getCcpHdd() {
		return ccpHdd;
	}

	public long getCcpAtn() {
		return ccpAtn;
	}

	public long getCcpEdn() {
		return ccpEdn;
	}

	public long getCcpTxbx() {
		return ccpTxbx;
	}

	public long getCcpHdrTxbx() {
		return ccpHdrTxbx;
	}

	public long getCcpMcr() {
		return ccpMcr;
	}
}
