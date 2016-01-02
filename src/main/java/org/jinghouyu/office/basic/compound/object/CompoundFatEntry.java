package org.jinghouyu.office.basic.compound.object;

public class CompoundFatEntry {

	private static final long END = 0xFFFFFFFEL;
	private static final long FREE = 0xFFFFFFFFL;
	private static final long CONTAINFAT = 0xFFFFFFFDL;
	private static final long CONTAINDIFAT = 0xFFFFFFFCL;
	private long nextFatIndex;
	private long sectorIndex;

	public CompoundFatEntry(long sectorIndex, long nextFatIndex) {
		this.nextFatIndex = nextFatIndex;
		this.sectorIndex = sectorIndex;
	}
	
	public boolean isEnd() {
		return this.nextFatIndex == END;
	}
	
	public boolean isFree() {
		return this.nextFatIndex == FREE;
	}
	
	public boolean containsFat() {
		return this.nextFatIndex == CONTAINFAT;
	}
	
	public boolean containsDifat() {
		return this.nextFatIndex == CONTAINDIFAT;
	}
	
	public long getSectorIndex() {
		return this.sectorIndex;
	}
	
	public boolean hasNextEntry() {
		return this.nextFatIndex < CONTAINDIFAT;
	}
	
	public long getNextFatEntryIndex() {
		return this.nextFatIndex;
	}
}