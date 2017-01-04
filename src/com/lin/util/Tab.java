package com.lin.util;

public class Tab {
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public static int getSimplenum() {
		return simpleNum;
	}
	public static int getColnum() {
		return colNum;
	}
	public Tab(int totalCount, int pageCount, int index, int begin, int end) {
		super();
		this.totalCount = totalCount;
		this.pageCount = pageCount;
		this.index = index;
		this.begin = begin;
		this.end = end;
	}
	public Tab() {
		// TODO Auto-generated constructor stub
	}
	public int totalCount;
	public final static int simpleNum = 10;//一页显示多少行数据
	public int pageCount;
	public final static int colNum = 8; //有多少页数可供点击
	public int index;
	public int begin;
	public int end;
}
