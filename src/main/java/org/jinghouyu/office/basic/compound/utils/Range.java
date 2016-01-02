package org.jinghouyu.office.basic.compound.utils;

public class Range<T> {

	private T start;
	private T end;

	public Range(T start, T end) {
		this.start = start;
		this.end = end;
	}
	
	public Range() {}
	
	public T getStart() {
		return this.start;
	}
	
	public T getEnd() {
		return this.end;
	}
	
	public void setStart(T start) {
		this.start = start;
	}
	
	public void setEnd(T end) {
		this.end = end;
	}
	
	public String toString() {
		return "[" + start + "-" + end + "]";
	}
}
