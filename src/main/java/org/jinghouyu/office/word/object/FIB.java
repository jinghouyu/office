package org.jinghouyu.office.word.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.object.CompoundDirectory;
import org.jinghouyu.office.basic.compound.object.CompoundFile;
import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.Range;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeShort;
import org.jinghouyu.office.basic.compound.utils.stream.ByteArraySeekableInputStream;
import org.jinghouyu.office.basic.compound.utils.stream.SeekableInputStream;
import org.jinghouyu.office.word.object.lcb.Lcb2000;
import org.jinghouyu.office.word.object.lcb.Lcb2002;
import org.jinghouyu.office.word.object.lcb.Lcb2003;
import org.jinghouyu.office.word.object.lcb.Lcb2007;
import org.jinghouyu.office.word.object.lcb.Lcb97;
import org.jinghouyu.office.word.object.plc.PlcBtePapx;
import org.jinghouyu.office.word.object.plc.PlcPcd;
import org.jinghouyu.office.word.object.type.Clx;
import org.jinghouyu.office.word.object.type.Pcd;

import com.alibaba.fastjson.JSON;

public class FIB {

	private FIBBase base;

	// 2 bytes csw always be 0x000E

	private FIBRgW97 fibRgW97; // 28bytes

	// 2 bytescslw always be 0x0016

	private FIBRgLw97 fibRgLw97; // 88bytes

	private int cbRgFcLcbCount; // 2bytes

	private Lcb97 lcb; // variable depends on cbRgFcLcbCount

	private int fibRgCswNewCount; // 2bytes

	private FibRgCswNew csw;

	public FIBBase getBase() {
		return base;
	}

	public FIBRgW97 getFibRgW97() {
		return fibRgW97;
	}

	public FIBRgLw97 getFibRgLw97() {
		return fibRgLw97;
	}

	public int getCbRgFcLcbCount() {
		return cbRgFcLcbCount;
	}
	
	public Lcb97 getLcb() {
		return lcb;
	}

	public int getFibRgCswNewCount() {
		return fibRgCswNewCount;
	}

	public FibRgCswNew getCsw() {
		return csw;
	}
	
	public int getnFib() {
		if(fibRgCswNewCount == 0) return base.getnFib();
		return csw.getnFibNew();
	}
	
	public static FIB parse(InputStream in) throws IOException {
		FIB fib = new FIB();
		fib.base = FIBBase.parse(in);
		LeShort.toShort(IOUtils.readFully(in, 2));
		fib.fibRgW97 = FIBRgW97.parse(in);
		IOUtils.readFully(in, 2);
		fib.fibRgLw97 = FIBRgLw97.parse(in);
		fib.cbRgFcLcbCount = LeShort.toShort(IOUtils.readFully(in, 2));
		if(fib.cbRgFcLcbCount == 0x005D) {
			fib.lcb = new Lcb97();
		} else if(fib.cbRgFcLcbCount == 0x006C) {
			fib.lcb = new Lcb2000();
		} else if(fib.cbRgFcLcbCount == 0x0088) {
			fib.lcb = new Lcb2002();
		} else if(fib.cbRgFcLcbCount == 0x00A4) {
			fib.lcb = new Lcb2003();
		} else {
			fib.lcb = new Lcb2007();
		}
		fib.lcb.parse(in);
		fib.fibRgCswNewCount = LeShort.toShort(IOUtils.readFully(in, 2));
		if(fib.fibRgCswNewCount != 0) {
			fib.csw = FibRgCswNew.parse(in);
		}
		return fib;
	}
	
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\jingyu.ljy\\Desktop\\ttt.doc");
		long fileLength = f.length();
		FileInputStream in = new FileInputStream(f);
		byte[] fileDatas = IOUtils.readFully(in, (int) fileLength);
		ByteArraySeekableInputStream seekableIn = new ByteArraySeekableInputStream(fileDatas);
		CompoundFile file = CompoundFile.parse(seekableIn, fileLength);
		CompoundDirectory wordDocument = file.getCompundDirectories().getByName("WordDocument");
		SeekableInputStream documentInputStream = file.getStream(wordDocument.getStartSectorIndex(), wordDocument.getStreamSize());
		FIB fib = FIB.parse(documentInputStream);  // fib has known
		System.out.println(fib.getFibRgLw97().getCcpText());
		String tableName = fib.getBase().isWhichTableStream() ? "1Table" : "0Table";
		CompoundDirectory tableDirectory = file.getCompundDirectories().getByName(tableName);
		Lcb97 lcb = fib.getLcb();
		SeekableInputStream tableIn = file.getStream(tableDirectory.getStartSectorIndex(), tableDirectory.getStreamSize());

		long plcfbtepapxOffset = lcb.getFcPlcfBtePapx();
		long plcfbtepapxSize = lcb.getLcbPlcfBtePapx();
		tableIn.seek(plcfbtepapxOffset);
		PlcBtePapx plcBtePapx = new PlcBtePapx();
		plcBtePapx.parse(tableIn, fib, plcfbtepapxSize);
		System.out.println(JSON.toJSONString(plcBtePapx));
		
		tableIn.seek(lcb.getFcClx());
		
		
		Clx clx = Clx.parse(tableIn, fib);
		System.out.println(JSON.toJSONString(clx.getPcdt().getPlcPcd()));
		PlcPcd plcpcd = clx.getPcdt().getPlcPcd();
		for(int i = 0; i < plcpcd.getCount(); i++) {
			String charset = "utf-16le";
			Pcd pcd = plcpcd.getData(i);
			boolean compressed = pcd.getFc().isCompressed();
			if(compressed) {
				charset = "cp1252";
			}
			long start = 0;
			long length = 0;
			Range<Long> range = plcpcd.getRange(i);
			if(compressed) {
				start = pcd.getFc().getTextOffset() / 2;
				length = range.getEnd() - range.getStart();
			} else {
				start = pcd.getFc().getTextOffset();
				length = (range.getEnd() - range.getStart()) * 2;
			}
			documentInputStream.seek(start);
			byte[] datas = IOUtils.readFully(documentInputStream, (int) length);
			System.out.println(new String(datas, charset));
		}
	}
}