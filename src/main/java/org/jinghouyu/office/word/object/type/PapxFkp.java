package org.jinghouyu.office.word.object.type;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;
import org.jinghouyu.office.basic.compound.utils.stream.ByteArraySeekableInputStream;

public class PapxFkp {
	
	private List<Long> fcs = null;
	private List<Short> bxs = null;
	
	public static void parse(byte[] data) throws IOException {
		PapxFkp fkp = new PapxFkp();
		//512 bytes;
		int count = data[511] & 0xFF;
		if(count > 0x1D) {
			throw new RuntimeException("doc error");
		}
		ByteArraySeekableInputStream in = new ByteArraySeekableInputStream(data);
		fkp.fcs = new ArrayList<Long>(count + 1);
		fkp.bxs = new ArrayList<Short>(count);
		for(int i = 0; i <= count; i++) {
			fkp.fcs.add(LeInteger.toInteger(IOUtils.readFully(in, 4)));
		}
		for(int i = 0; i < count; i++) {
			byte[] bxpap = IOUtils.readFully(in, 13);
			short boffset = (short) (bxpap[0] & 0xFF);
			fkp.bxs.add(boffset);
		}
	}
}