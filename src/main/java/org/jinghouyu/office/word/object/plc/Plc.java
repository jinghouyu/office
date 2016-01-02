package org.jinghouyu.office.word.object.plc;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.Range;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;
import org.jinghouyu.office.word.object.FIB;

public abstract class Plc<Data> {
	
	private long[] cps = null;
	
	private Object[] datas = null;
	
	public void parse(InputStream in, FIB fib, long totalSize) throws IOException {
		int dataSize = getDataSize();
		int dataCount = (int) ((totalSize - 4) / (4 + dataSize));
		int cpCount = dataCount + 1;
		cps = new long[cpCount];
		for(int i = 0; i < cpCount; i++) {
			cps[i] = LeInteger.toInteger(IOUtils.readFully(in, 4));
		}
		
		datas = new Object[dataCount];
		for(int i = 0; i < dataCount; i++) {
			datas[i] = parseData(IOUtils.readFully(in, dataSize), fib);
		}
	}
	
	protected abstract int getDataSize();
	
	protected abstract Data parseData(byte[] data, FIB fib) throws IOException;
	
	@SuppressWarnings("unchecked")
	public Data getData(int index) {
		return (Data) datas[index];
	}
	
	public Range<Long> getRange(int index) {
		return new Range<Long>(cps[index], cps[index + 1]);
	}
	
	public int getCount() {
		return datas.length;
	}
	
	public Object[] getDatas() {
		return this.datas;
	}
	
	public long[] getCps() {
		return this.cps;
	}
}
