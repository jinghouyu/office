package org.jinghouyu.office.word.object.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeShort;
import org.jinghouyu.office.basic.compound.utils.stream.ByteArraySeekableInputStream;

public class GrpPrlAndIstd {
	
	private int istd = 0;
	private List<Prl> prls;

	public static GrpPrlAndIstd parse(byte[] datas) throws IOException {
		GrpPrlAndIstd r = new GrpPrlAndIstd();
		ByteArraySeekableInputStream in = new ByteArraySeekableInputStream(datas);
		r.istd = LeShort.toShort(IOUtils.readFully(in, 2));
		r.prls = new ArrayList<Prl>();
		while(true) {
			
		}
	}
}
