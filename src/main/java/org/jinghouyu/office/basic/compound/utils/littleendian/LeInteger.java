package org.jinghouyu.office.basic.compound.utils.littleendian;

public class LeInteger {
	
	public static long MAX_VALUE = 0x00000000FFFFFFFFL;
	
	public static long toInteger(byte[] data, int off) {
		long value = 0;
		for(int i = off + 3; i >= off; i--) {
			int bitMove = (i - off) * 8;
			value = value | ((long) (data[i] & 0xFF) << bitMove);
		}
		return value;
	}
	
	public static long toInteger(byte[] data) {
		long value = 0;
		for(int i = 3; i >= 0; i--) {
			int bitMove = i * 8;
			value = value | ((long) (data[i] & 0xFF) << bitMove);
		}
		return value;
	}
	
	public static byte[] toBytes(long value) {
		byte[] data = new byte[4];
		for(int i = 0; i <= 3; i++) {
			int bitMove = i * 8;
			data[i] = (byte) ((value >> bitMove) & 0xFF);
		}
		return data;
	}
}