package com.example.demo.handler;

import java.util.List;

import com.example.demo.domain.CommentVO;
import com.example.demo.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingHandler {

	private int startPage, endPage, totalCount;
	private boolean prev, next;
	private PagingVO pgvo;
	
	private List<CommentVO> cmtList;
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		this.endPage = (int)Math.ceil((double)pgvo.getPageNo()/pgvo.getQty())*pgvo.getQty();
		this.startPage = endPage-9;
		
		int realEndPage = (int)Math.ceil((double)totalCount/pgvo.getQty());
		
		if(realEndPage < endPage) {
			this.endPage = realEndPage;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEndPage;
	}
	public PagingHandler(PagingVO pgvo, int totalCount, List<CommentVO> cmtList) {
		this(pgvo,totalCount);
		this.cmtList=cmtList;
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}

	public List<CommentVO> getCmtList() {
		return cmtList;
	}

	public void setCmtList(List<CommentVO> cmtList) {
		this.cmtList = cmtList;
	}

}