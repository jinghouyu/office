package org.jinghouyu.office.word.object;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.ByteUtils;
import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeShort;

public class FIBBase {

	private int wIdent; // 2bytes
	private int nFib; // 2bytes
	// unuses 2bytes
	private int lid; // lid install language;
	private int pnNextIndex; // 2bytes next fib
	private boolean dot;
	private boolean glsy;
	private boolean complex;
	private boolean hasPic;
	private int cquickSaves; // incremental times
	private boolean encrypted;
	private boolean whichTableStream; // 1 / 0 table stream;
	private boolean readOnlyRecommended;
	private boolean writeReservation;
	private boolean extChar; // must be true;
	private boolean loadOverride;
	private boolean farEast;
	private boolean obfuscated;

	private int nFibBack;
	private long lkey;
	// 1bytes must be 0;
	private boolean mac; // ignore 1bit
	private boolean emptySpecial; // ignore 1byte
	private boolean loadOverridePage;
	private boolean r1;
	private boolean r2;

	public int getwIdent() {
		return wIdent;
	}

	public int getnFib() {
		return nFib;
	}

	public int getLid() {
		return lid;
	}

	public int getPnNextIndex() {
		return pnNextIndex;
	}

	public boolean isDot() {
		return dot;
	}

	public boolean isGlsy() {
		return glsy;
	}

	public boolean isComplex() {
		return complex;
	}

	public boolean isHasPic() {
		return hasPic;
	}

	public int getCquickSaves() {
		return cquickSaves;
	}

	public boolean isEncrypted() {
		return encrypted;
	}

	public boolean isWhichTableStream() {
		return whichTableStream;
	}

	public boolean isReadOnlyRecommended() {
		return readOnlyRecommended;
	}

	public boolean isWriteReservation() {
		return writeReservation;
	}

	public boolean isExtChar() {
		return extChar;
	}

	public boolean isLoadOverride() {
		return loadOverride;
	}

	public boolean isFarEast() {
		return farEast;
	}

	public boolean isObfuscated() {
		return obfuscated;
	}

	public int getnFibBack() {
		return nFibBack;
	}

	public long getLkey() {
		return lkey;
	}

	public boolean isMac() {
		return mac;
	}

	public boolean isEmptySpecial() {
		return emptySpecial;
	}

	public boolean isLoadOverridePage() {
		return loadOverridePage;
	}

	public boolean isR1() {
		return r1;
	}

	public boolean isR2() {
		return r2;
	}

	public static FIBBase parse(InputStream in) throws IOException {
		FIBBase base = new FIBBase();
		base.wIdent = LeShort.toShort(IOUtils.readFully(in, 2));
		base.nFib = LeShort.toShort(IOUtils.readFully(in, 2));
		IOUtils.readFully(in, 2);
		base.lid = LeShort.toShort(IOUtils.readFully(in, 2));
		base.pnNextIndex = LeShort.toShort(IOUtils.readFully(in, 2));
		byte[] word = IOUtils.readFully(in, 2);
		base.dot = ByteUtils.getValue(word[0], 0, 1) == 1;
		base.glsy = ByteUtils.getValue(word[0], 1, 1) == 1;
		base.complex = ByteUtils.getValue(word[0], 2, 1) == 1;
		base.hasPic = ByteUtils.getValue(word[0], 3, 1) == 1;
		base.cquickSaves = ByteUtils.getValue(word[0], 4, 4);

		base.encrypted = ByteUtils.getValue(word[1], 0, 1) == 1;
		base.whichTableStream = ByteUtils.getValue(word[1], 1, 1) == 1;
		base.readOnlyRecommended = ByteUtils.getValue(word[1], 2, 1) == 1;
		base.writeReservation = ByteUtils.getValue(word[1], 3, 1) == 1;
		base.extChar = ByteUtils.getValue(word[1], 4, 1) == 1;
		base.loadOverride = ByteUtils.getValue(word[1], 5, 1) == 1;
		base.farEast = ByteUtils.getValue(word[1], 6, 1) == 1;
		base.obfuscated = ByteUtils.getValue(word[1], 7, 1) == 1;

		base.nFibBack = LeShort.toShort(IOUtils.readFully(in, 2));
		base.lkey = LeInteger.toInteger(IOUtils.readFully(in, 4));
		in.read();

		byte lastData = (byte) in.read();
		base.emptySpecial = ByteUtils.getValue(lastData, 1, 1) == 1;
		base.loadOverridePage = ByteUtils.getValue(lastData, 2, 1) == 1;
		base.r1 = ByteUtils.getValue(lastData, 3, 1) == 1;
		base.r2 = ByteUtils.getValue(lastData, 4, 1) == 1;
		IOUtils.readFully(in, 2);
		IOUtils.readFully(in, 2);
		IOUtils.readFully(in, 4);
		IOUtils.readFully(in, 4);
		return base;
	}
}