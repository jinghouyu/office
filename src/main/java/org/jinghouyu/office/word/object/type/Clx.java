package org.jinghouyu.office.word.object.type;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jinghouyu.office.basic.compound.utils.stream.InputStreams;
import org.jinghouyu.office.word.object.FIB;

public class Clx {
	
	private List<Prc> prcs;
	
	private Pcdt pcdt;
	
	public static Clx parse(InputStream in, FIB fib) throws IOException {
		Clx clx = new Clx();
		byte type = 0;
		while(true) {
			type = (byte) in.read();
			if(type != 0x01) {
				break;
			}
			Prc prc = Prc.parse(in);
			if(clx.prcs == null) {
				clx.prcs = new ArrayList<Prc>();
			}
			clx.prcs.add(prc);
		}
		InputStream newIn = new InputStreams().addInputStream(new ByteArrayInputStream(new byte[]{type}))
		   			.addInputStream(in);
		
		clx.pcdt = Pcdt.parse(newIn, fib);
		return clx;
	}

	public List<Prc> getPrcs() {
		return prcs;
	}

	public Pcdt getPcdt() {
		return pcdt;
	}
}