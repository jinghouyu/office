package org.jinghouyu.office.word.object.plc;

import java.io.IOException;

import org.jinghouyu.office.word.object.FIB;
import org.jinghouyu.office.word.object.type.PnFkpPapx;

public class PlcBtePapx extends Plc<PnFkpPapx> {

	@Override
	protected int getDataSize() {
		return 4;
	}

	@Override
	protected PnFkpPapx parseData(byte[] data, FIB fib) throws IOException {
		return PnFkpPapx.parse(data);
	}
}
