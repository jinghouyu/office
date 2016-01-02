package org.jinghouyu.office.word.object.type;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeShort;

public class Prc {
	
	public static Prc parse(InputStream in) throws IOException {
		int prlSize = LeShort.toShort(IOUtils.readFully(in, 2));
		IOUtils.readFully(in, prlSize);
		return new Prc();
	}
}
