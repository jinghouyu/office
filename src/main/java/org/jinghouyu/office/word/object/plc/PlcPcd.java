package org.jinghouyu.office.word.object.plc;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.jinghouyu.office.word.object.FIB;
import org.jinghouyu.office.word.object.type.Pcd;


public class PlcPcd extends Plc<Pcd> {

	@Override
	protected int getDataSize() {
		return 8;
	}

	@Override
	protected Pcd parseData(byte[] data, FIB fib) throws IOException {
		return Pcd.parse(new ByteArrayInputStream(data));
	}
	
//	private List<Long> cps;
//	private List<Pcd> pcds;
	
//	public static PlcPcd parse(InputStream in, FIB fib, long totalSize) throws IOException {
//		int pcdSize = 8;
//		int pcdCount = (int) ((totalSize - 4) / (4 + pcdSize));
//		PlcPcd r = new PlcPcd();
//		FIBRgLw97 rglw = fib.getFibRgLw97();
//		long lastCp = 0;
//		long flag = rglw.getCcpFtn() + rglw.getCcpHdd() + rglw.getCcpMcr() + rglw.getCcpAtn() + rglw.getCcpEdn() + rglw.getCcpTxbx();
//		if(flag != 0) {
//			lastCp = flag + rglw.getCcpText() + 1;
//		} else {
//			lastCp = rglw.getCcpText();
//		}
//		while(true) {
//			long cp = LeInteger.toInteger(IOUtils.readFully(in, 4));
//			if(r.cps == null) {
//				r.cps = new ArrayList<Long>();
//			}
//			r.cps.add(cp);
//			if(cp == lastCp) break;
//		}
//
//		r.pcds = new ArrayList<Pcd>();
//		for(int i = 0; i < pcdCount; i++) {
//			r.pcds.add(Pcd.parse(in));
//		}
//		return r;
//	}

//	public List<Long> getCps() {
//		return cps;
//	}
//
//	public List<Pcd> getPcds() {
//		return pcds;
//	}
}