package org.jinghouyu.office.word.object.type;

import java.io.IOException;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.stream.SeekableInputStream;

public class Prl {

	private Sprm sprm;
	private byte[] operand;
	
	public static Prl parse(SeekableInputStream in, int size) throws IOException {
		int readed = (int) in.getReaded();
		int elseSize = size - readed;
		if(elseSize < 2) {
			return null;
		}
		Prl prl = new Prl();
		prl.sprm = Sprm.parse(IOUtils.readFully(in, elseSize));
		readed = (int) in.getReaded();
		int spra = prl.sprm.getSpra();
		int operandSize = 0;
		switch(operandSize) {
		case 0 : operandSize = 1; break;
		case 1 : operandSize = 1; break;
		case 2 : operandSize = 2; break;
		case 3 : operandSize = 4; break;
		case 4 : operandSize = 2; break;
		case 5 : operandSize = 2; break;
		case 6 : {
			if(prl.sprm.getSgc() == 5) {
				parseTableSprm(prl, in, size);
				return prl;
			} else if(prl.sprm.getSgc() == 2) {
				parseCharacterSprm(prl, in, size);
				return prl;
			} else {
				if(size - readed < 1) {
					return null;
				}
				int esize = in.read() & 0xFF;
				if(size - (int) in.getReaded() < esize) return null;
				operandSize = esize;
			}
		}
		case 7 : operandSize = 3; break;
		default : throw new IOException("doc error");
		}
		prl.operand = IOUtils.readFully(in, operandSize);
		return prl;
	}
	
	private static void parseTableSprm(Prl prl, SeekableInputStream in, int size) throws IOException {
		int osize = 0;
		switch(prl.sprm.getIspmd()) {
		case 0x00 : osize = 2;
		case 0x01 : osize = 2;
		case 0x02 : osize = 2;
		case 0x03 : osize = 1;
		case 0x04 : osize = 1;
		case 0x05 : osize = 25;
		case 0x07 : osize = 2;
		case 0x08 : {
			//长度待定
		}//TDefTableOperand;
		case 0x09 : {
			//长度待定
			//DefTableShd80Operand
		}
		default : throw new IOException("doc error");
		}
	}
	
	private static void parseCharacterSprm(Prl prl, SeekableInputStream in, int size) throws IOException {
		
	}
}