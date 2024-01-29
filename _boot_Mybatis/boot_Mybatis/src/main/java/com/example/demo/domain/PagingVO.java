package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PagingVO {

	private int pageNo, qty;
	private String type, keyword;
	
	public PagingVO() {
		this.pageNo = 1;
		this.qty = 10;
	}
	
	public PagingVO(int pageNo, int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}
	
	public PagingVO(int pageNo, int qty, String type, String keyword) {
		super();
		this.pageNo = pageNo;
		this.qty = qty;
		this.type = type;
		this.keyword = keyword;
	}

	public int getPageStart() {
		return (pageNo - 1)*qty; //DB의 limit #{pageStart}
	}
	
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "PagingVO [pageNo=" + pageNo + ", qty=" + qty + ", type=" + type + ", keyword=" + keyword + "]";
	}
	
	
}