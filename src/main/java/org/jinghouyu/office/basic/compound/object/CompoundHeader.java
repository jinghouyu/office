package org.jinghouyu.office.basic.compound.object;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeShort;

/**
 * compound protocol refers to [MS-CFB] protocol
 * it's the very basic protocol of old office(<2003) format。
 *　　　┏┓　　　┏┓
 *　　┏┛┻━━━┛┻┓
 *　　┃　　　　　　　┃
 *　　┃　　　━　　　┃
 *　　┃　┳┛　┗┳　┃
 *　　┃　　　　　　　┃
 *　　┃　　　┻　　　┃
 *　　┃　　　　　　　┃
 *　　┗━┓　　　┏━┛
 *　　　　┃　　　┃神兽保佑
 *　　　　┃　　　┃代码无BUG！
 *　　　　┃　　　┗━━━┓
 *　　　　┃　　　　　　　┣┓
 *　　　　┃　　　　　　　┏┛
 *　　　　┗┓┓┏━┳┓┏┛
 *　　　　　┃┫┫　┃┫┫
 *　　　　　┗┻┛　┗┻┛
 * ━━━━━━━━━━━━━━━━━━
 * @author jingyu.ljy
 *
 */
public class CompoundHeader {
	
	public static final byte[] SIGN = new byte[]{(byte)0xD0, (byte)0xCF, (byte)0x11, (byte)0xE0, (byte)0xA1, (byte)0xB1, 0x1A, (byte)0xE1};  //8 bytes signature;
	
	public static final int VERSION_3 = 0x0003;
	public static final int VERSION_4 = 0x0004;
	
	public static final int SECTOR_512 = 0x0009;
	public static final int SECTOR_4096 = 0x000c;
	
	
	private int minorVersion;
	private int majorVersion;
	private int sectorShift;
	private int minSectorShift = 64;
	private long directorySectorCount;  // 4bytes unsigned interger; 0x00000000 if major version is 0x0003;
	private long fatSectorCount;   //fat sector count;
	private long directorySectorIndex;   //4bytes
	private long transactionSignatureNumber; //事务保存number 4bytes
	private int cutoffSize = 4096;
	private long minSectorIndex;
	private long difatSectorIndex;
	private long difatSectorCount;
	private List<Long> difats = new ArrayList<Long>();
	
	
	public static CompoundHeader parse(InputStream in) throws IOException {
		byte[] sign = IOUtils.readFully(in, 8);
		if(!Arrays.equals(sign, SIGN)) {
			throw new IOException("word error start");
		}
		CompoundHeader header = new CompoundHeader();
		IOUtils.readFully(in, 16);
		header.minorVersion = LeShort.toShort(IOUtils.readFully(in, 2));
		header.majorVersion = LeShort.toShort(IOUtils.readFully(in, 2));

		//byte order fixed little endian
		//sector shift fixed depending on majorversion
		//mini sector shift fixed in 64 bytes;
		//reserved 6 bytes
		IOUtils.readFully(in, 12); 
		header.sectorShift = header.majorVersion == VERSION_3 ? 512 : 4096;
		header.directorySectorCount = LeInteger.toInteger(IOUtils.readFully(in, 4));
		header.fatSectorCount = LeInteger.toInteger(IOUtils.readFully(in, 4));
		header.directorySectorIndex = LeInteger.toInteger(IOUtils.readFully(in, 4));
		header.transactionSignatureNumber = LeInteger.toInteger(IOUtils.readFully(in, 4));
		
		//cutoffsize is 4096;
		IOUtils.readFully(in, 4);
		header.minSectorIndex = LeInteger.toInteger(IOUtils.readFully(in, 4));
		header.fatSectorCount = LeInteger.toInteger(IOUtils.readFully(in, 4));
		header.difatSectorIndex = LeInteger.toInteger(IOUtils.readFully(in, 4));
		header.difatSectorCount = LeInteger.toInteger(IOUtils.readFully(in, 4));
		for(int i = 0; i < 109; i++) {
			long difat = LeInteger.toInteger(IOUtils.readFully(in, 4));
			if(difat >= 0xFFFFFFFEL) {
				break;
			}
			header.difats.add(difat);
		}
		if(header.majorVersion == VERSION_4) {
			IOUtils.readFully(in, 3584);
		}
		return header;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public int getSectorShift() {
		return sectorShift;
	}

	public int getMinSectorShift() {
		return minSectorShift;
	}

	public long getDirectorySectorCount() {
		return directorySectorCount;
	}

	public long getFatSectorCount() {
		return fatSectorCount;
	}

	public long getDirectorySectorIndex() {
		return directorySectorIndex;
	}

	public long getTransactionSignatureNumber() {
		return transactionSignatureNumber;
	}

	public int getCutoffSize() {
		return cutoffSize;
	}

	public long getMinSectorIndex() {
		return minSectorIndex;
	}

	public long getDifatSectorIndex() {
		return difatSectorIndex;
	}

	public long getDifatSectorCount() {
		return difatSectorCount;
	}

	public List<Long> getDifats() {
		return difats;
	}
	
}