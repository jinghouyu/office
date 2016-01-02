package org.jinghouyu.office.word.object.type;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.ByteUtils;
import org.jinghouyu.office.basic.compound.utils.IOUtils;

public class Pcd {

	private boolean noParamList;
	private FcCompressed fc;
	
	public static Pcd parse(InputStream in) throws IOException {
		Pcd pcd = new Pcd();
		byte firstByte = (byte) in.read();
		pcd.noParamList = ByteUtils.getValue(firstByte, 0, 1) == 1;
		in.read();
		pcd.fc = FcCompressed.parse(in);
		IOUtils.readFully(in, 2); //Prm
		return pcd;
	}

	public boolean isNoParamList() {
		return noParamList;
	}

	public void setNoParamList(boolean noParamList) {
		this.noParamList = noParamList;
	}

	public FcCompressed getFc() {
		return fc;
	}

	public void setFc(FcCompressed fc) {
		this.fc = fc;
	}
}