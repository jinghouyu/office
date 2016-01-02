package org.jinghouyu.office.word.object.type;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;
import org.jinghouyu.office.word.object.FIB;
import org.jinghouyu.office.word.object.plc.PlcPcd;

public class Pcdt {

	private PlcPcd plcPcd = null;
	
	public static Pcdt parse(InputStream in, FIB fib) throws IOException {
		Pcdt r = new Pcdt();
		int clxt = in.read();
		if(clxt != 0x02) {
			throw new IOException("doc error");
		}
		long pclpcdSize = LeInteger.toInteger(IOUtils.readFully(in, 4));
		r.plcPcd = new PlcPcd();
		r.plcPcd.parse(in, fib, pclpcdSize);
		return r;
	}

	public PlcPcd getPlcPcd() {
		return plcPcd;
	}
}