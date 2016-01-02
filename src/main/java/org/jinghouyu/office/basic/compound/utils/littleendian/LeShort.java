package org.jinghouyu.office.basic.compound.utils.littleendian;

public class LeShort {
	
	public static final int MAX_VALUE = 0x0000FFFF;
	
	public static int toShort(byte[] data, int off) {
		return ((data[off + 1] & 0xFF) << 8) | ((data[off] & 0xFF) << 0);
	}

	public static int toShort(byte[] data) {
		return ((data[1] & 0xFF) << 8) | ((data[0] & 0xFF) << 0);
	}
	
	public static byte[] toBytes(int value) {
		byte[] data = new byte[2];
		data[0] = (byte) ((value >> 0) & 0xFF);
		data[1] = (byte) ((value >> 8) & 0xFF);
		return data;
	}
	
}