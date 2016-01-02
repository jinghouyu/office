package org.jinghouyu.office.basic.compound.utils.littleendian;

public class LeLong {
	
	public static long toLong(byte[] data, int off) {
		long value = 0;
		for(int i = off + 7; i >= off; i--) {
			int bitMove = (i - off) * 8;
			value = value | ((long) (data[off + i] & 0xFF) << bitMove);
		}
		return value;
	}
	
	public static long toLong(byte[] data) {
		long value = 0;
		for(int i = 7; i >= 0; i--) {
			int bitMove = i * 8;
			value = value | ((long) (data[i] & 0xFF) << bitMove);
		}
		return value;
	}
	
	public static byte[] toBytes(long value) {
		byte[] data = new byte[8];
		for(int i = 0; i <= 7; i++) {
			int bitMove = i * 8;
			data[i] = (byte) ((value >> bitMove) & 0xFF);
		}
		return data;
	}
}
