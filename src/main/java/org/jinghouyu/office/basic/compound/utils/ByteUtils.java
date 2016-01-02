package org.jinghouyu.office.basic.compound.utils;

public class ByteUtils {
	
	public static int getValue(byte b, int off, int len) {
		return b >> (8 - len - off) & len;
	}
}
