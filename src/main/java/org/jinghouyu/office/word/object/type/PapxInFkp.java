package org.jinghouyu.office.word.object.type;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;


public class PapxInFkp {
	
	private GrpPrlAndIstd prlAndIstd = null;

	public static PapxInFkp parse(InputStream in) throws IOException {
		PapxInFkp papx = new PapxInFkp();
		int cb = in.read() & 0xFF;
		int size = 2 * cb - 1;
		if(cb == 0) {
			cb = in.read() & 0xFF;
			size = 2 * cb;
		}
		if(cb < 1) throw new RuntimeException("doc error");
		byte[] papxData = IOUtils.readFully(in, size);
		papx.prlAndIstd = GrpPrlAndIstd.parse(papxData); 
		return papx;
	}
}
