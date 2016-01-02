package org.jinghouyu.office.basic.compound.utils;

import java.io.IOException;
import java.io.InputStream;

public class IOUtils {

	public static byte[] readFully(InputStream in, int size) throws IOException {
		byte[] data = new byte[size];
		if(size == 0) return data;
		int off = 0;
		while(true) {
			int len = in.read(data, off, data.length - off);
			if(len == -1) {
				throw new IOException("doc error");
			}
			off += len;
			if(off >= size) break;
		}
		return data;
	}
	
	public static byte[] readFullyWithNull(InputStream in, int size) throws IOException {
		byte[] data = new byte[size];
		if(size == 0) return data;
		int off = 0;
		while(true) {
			int len = in.read(data, off, data.length - off);
			if(len == -1) {
				return null;
			}
			off += len;
			if(off >= size) break;
		}
		return data;
	}
}