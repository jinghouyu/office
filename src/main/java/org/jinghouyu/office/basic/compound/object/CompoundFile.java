package org.jinghouyu.office.basic.compound.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jinghouyu.office.basic.compound.object.stream.CompoundFatStream;
import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;
import org.jinghouyu.office.basic.compound.utils.stream.ByteArraySeekableInputStream;
import org.jinghouyu.office.basic.compound.utils.stream.SeekableInputStream;

import com.alibaba.fastjson.JSON;

public class CompoundFile {
	
	private CompoundHeader header;
	private List<CompoundFatEntry> fat = new ArrayList<CompoundFatEntry>();
	private long fileLength;
	private SeekableInputStream in;
	
	private CompoundDirectories directories;
	
	public SeekableInputStream getSourceInputStream() {
		return this.in;
	}
	
	public CompoundFile(SeekableInputStream in, long fileLength) throws IOException {
		this.in = in;
		this.fileLength = fileLength;
		parse();
	}
	
	private void parse() throws IOException {
		header = CompoundHeader.parse(in);
		System.out.println(JSON.toJSONString(header));
		parseFat();
		directories = CompoundDirectories.parse(in, this);
	}
	
	private void parseFat() throws IOException {
		List<Long> difats = header.getDifats();
		for(int i = 0; i < difats.size(); i++) {
			long sectorOffset = getPhysicalSectorOffset(difats.get(i));
			in.seek(sectorOffset);
			int fatSize = getSectorSize() / 4;
			for(int j = 0; j < fatSize; j++) {
				long nextFatEntryIndex = LeInteger.toInteger(IOUtils.readFully(in, 4));
				CompoundFatEntry entry = new CompoundFatEntry(fat.size(), nextFatEntryIndex);
				if(entry.isFree()) break;
				fat.add(entry);
			}
		}
	}

	private void parseMinFat() throws IOException {
		
	}
	
	public long getOffset(int selectorIndex) {
		return 1L * (selectorIndex + 1) * getSectorSize();
	}
	
	private long getPhysicalSectorOffset(long sectorIndex) {
		int sectorSize = getSectorSize();
		return (sectorIndex + 1)* sectorSize;
	}
	
	public int getSectorSize() {
		return header.getSectorShift();
	}
	
	public static CompoundFile parse(SeekableInputStream in, long fileLength) throws IOException {
		return new CompoundFile(in, fileLength);
	}
	
	public CompoundHeader getHeader() {
		return this.header;
	}
	
	public CompoundDirectories getCompundDirectories() {
		return this.directories;
	}
	
	public List<CompoundFatEntry> getFatChain(int sectorIndex) {
		List<CompoundFatEntry> result = new ArrayList<CompoundFatEntry>();
		while(true) {
			CompoundFatEntry entry = fat.get(sectorIndex);
			result.add(entry);
			if(!entry.hasNextEntry()) break;
			sectorIndex = (int) entry.getNextFatEntryIndex();
		}
		return result;
	}
	
	public SeekableInputStream getStream(long sectorIndex, long size) {
//		if(size >= header.getCutoffSize()) {
			return new CompoundFatStream(this, getFatChain((int) sectorIndex), size);
//		} else {
//			return new 
//		}
	}
	
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\jingyu.ljy\\Desktop\\ttt.doc");
		long fileLength = f.length();
		FileInputStream in = new FileInputStream(f);
		byte[] fileDatas = IOUtils.readFully(in, (int) fileLength);
		CompoundFile file = CompoundFile.parse(new ByteArraySeekableInputStream(fileDatas), fileLength);
		CompoundDirectory root = file.getCompundDirectories().getRoot();
		CompoundDirectory wordDocument = file.getCompundDirectories().getByName("WordDocument");
		
	}
}