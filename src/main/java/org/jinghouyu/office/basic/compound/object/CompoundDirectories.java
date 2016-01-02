package org.jinghouyu.office.basic.compound.object;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jinghouyu.office.basic.compound.utils.stream.SeekableInputStream;

public class CompoundDirectories {

	private static final int DIRECTION_LEFT = 0;
	private static final int DIRECTION_RIGHT = 1;
	private static final int DIRECTION_PARENT = 2;
	
	private CompoundDirectory root = null;
	private Map<String, CompoundDirectory> map = new HashMap<String, CompoundDirectory>();
	
	
	public CompoundDirectory getRoot() {
		return this.root;
	}
	
	public CompoundDirectory getByName(String name) {
		return map.get(name);
	}
	
	
	public static CompoundDirectories parse(SeekableInputStream in, CompoundFile file) throws IOException {
		List<CompoundFatEntry> fatChain = file.getFatChain((int) file.getHeader().getDirectorySectorIndex());
		long offset = getOffset(fatChain, file, 0);
		in.seek(offset);
		CompoundDirectories cds = new CompoundDirectories();
		cds.root = CompoundDirectory.parse(in);
		CompoundDirectory root = cds.root;
		if(root != null) {
			cds.map.put(root.getPath().trim(), root);
			Long childId = root.getChildId();
			if(childId != null) {
				parse(file, fatChain, in, childId, DIRECTION_PARENT, root, cds);
			}
		}
		return cds;
	}
	
	private static long getOffset(List<CompoundFatEntry> chain, CompoundFile file, int directoryId) {
		int index = getChainIndex(file, directoryId);
		int offset = getChainOffset(file, directoryId);
		CompoundFatEntry fatEntry = chain.get(index);
		long sectorIndex = fatEntry.getSectorIndex();
		long sectorOffset = file.getOffset((int) sectorIndex);
		return offset * 128 + sectorOffset;
	}
	
	private static int getChainIndex(CompoundFile file, int directoryId) {
		int sizePerSector = file.getHeader().getMajorVersion() == 3 ? 4 : 32;
		return directoryId / sizePerSector;
	}
	
	private static int getChainOffset(CompoundFile file, int directoryId) {
		int sizePerSector = file.getHeader().getMajorVersion() == 3 ? 4 : 32;
		return directoryId % sizePerSector;
	}
	
	private static void parse(CompoundFile file, List<CompoundFatEntry> chain, SeekableInputStream in, long id, int direction, CompoundDirectory source, CompoundDirectories directories) throws IOException {
		long offset = getOffset(chain, file, (int) id);
		in.seek(offset);
		CompoundDirectory cd = CompoundDirectory.parse(in);
		if(cd == null) return;
		directories.map.put(cd.getPath().trim(), cd);
		if(direction == DIRECTION_PARENT) {
			source.addChild(cd);
		}
		if(direction != DIRECTION_RIGHT) {
			Long leftId = cd.getLeftId();
			if(direction != DIRECTION_PARENT) {
				source.getParent().addChild(cd);
			}
			if(leftId != null) {
				parse(file, chain, in, leftId, DIRECTION_LEFT, cd, directories);
			}
		}
		if(direction != DIRECTION_LEFT) {
			Long rightId = cd.getRightId();
			if(direction != DIRECTION_PARENT) {
				source.getParent().addChild(cd);
			}
			if(rightId != null) {
				parse(file, chain, in, rightId, DIRECTION_RIGHT, cd, directories);
			}
		}
		Long childId = cd.getChildId();
		if(childId != null) {
			parse(file, chain, in, childId, DIRECTION_PARENT, cd, directories);
		}
	}
}
