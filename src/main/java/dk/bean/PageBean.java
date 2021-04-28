package dk.bean;

public class PageBean {
	
	private int offset;
	private int limit;
	
	public PageBean() {
		this.offset = 0;
		this.limit = 10;
	}
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	

}
