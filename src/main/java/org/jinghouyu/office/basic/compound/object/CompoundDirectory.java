package org.jinghouyu.office.basic.compound.object;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeLong;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeShort;

public class CompoundDirectory {
	
	private static final byte TYPE_UNKNOWN = 0x00; 
	private static final byte TYPE_STORAGE = 0x01; 
	private static final byte TYPE_STREAM = 0x02; 
	private static final byte TYPE_ROOT = 0x05; 
	
	private static final long TEMINATOR = 0xFFFFFFFFL;
	
	private String path;
	private byte type;
	private Long childId;  //id of one of the children
	private Long rightId;
	private Long leftId;
	
	private byte[] clsId; // 16bytes; a guid
	private long stateBits;
	private long createTime;
	private long modifiedTime;
	private long startSectorIndex;
	private long streamSize;
	
	private List<CompoundDirectory> children;
	private CompoundDirectory parent;
	
	private static final Charset CHARSET = Charset.forName("UTF-16LE");
	
	public boolean isUnknown() {
		return type == TYPE_UNKNOWN;
	}
	
	public boolean isStream() {
		return type == TYPE_STREAM;
	}
	
	public boolean isStorage() {
		return isRoot() || type == TYPE_STORAGE;
	}
	
	public boolean isRoot() {
		return type == TYPE_ROOT;
	}
	
	public String getName() {
		return null;
	}
	
	public String getPath() {
		return path;
	}
	
	public static CompoundDirectory parse(InputStream in) throws IOException {
		CompoundDirectory cd = new CompoundDirectory();
		byte[] nameBytes = IOUtils.readFully(in, 64);
		int nameLength = LeShort.toShort(IOUtils.readFully(in, 2)); // cannot exceed 64;
		cd.type = (byte) in.read();
		cd.path = new String(nameBytes, 0, nameLength, CHARSET);
		in.read(); // ignore color flag in read-black tree
		cd.leftId = LeInteger.toInteger(IOUtils.readFully(in, 4));
		if(cd.leftId == TEMINATOR) {
			cd.leftId = null;
		}
		cd.rightId = LeInteger.toInteger(IOUtils.readFully(in, 4));
		if(cd.rightId == TEMINATOR) {
			cd.rightId = null;
		}
		cd.childId = LeInteger.toInteger(IOUtils.readFully(in, 4));
		if(cd.childId == TEMINATOR) {
			cd.childId = null;
		}
		cd.clsId = IOUtils.readFully(in, 16);
		cd.stateBits = LeInteger.toInteger(IOUtils.readFully(in, 4));
		cd.createTime = LeLong.toLong(IOUtils.readFully(in, 8));
		cd.modifiedTime = LeLong.toLong(IOUtils.readFully(in, 8));
		cd.startSectorIndex = LeInteger.toInteger(IOUtils.readFully(in, 4));
		cd.streamSize = LeLong.toLong(IOUtils.readFully(in, 8));
		return cd;
	}

	public byte getType() {
		return type;
	}

	public Long getChildId() {
		return childId;
	}

	public Long getRightId() {
		return rightId;
	}

	public Long getLeftId() {
		return leftId;
	}

	public byte[] getClsId() {
		return clsId;
	}

	public long getStateBits() {
		return stateBits;
	}

	public long getCreateTime() {
		return createTime;
	}

	public long getModifiedTime() {
		return modifiedTime;
	}

	public long getStartSectorIndex() {
		return startSectorIndex;
	}

	public long getStreamSize() {
		return streamSize;
	}
	
	public void addChild(CompoundDirectory child) {
		if(children == null) children = new ArrayList<CompoundDirectory>();
		children.add(child);
		child.parent = this;
	}
	
	public List<CompoundDirectory> getChildren() {
		return this.children;
	}
	
	public CompoundDirectory getParent() {
		return this.parent;
	}
	
	public String toString() {
		return this.path;
	}
}