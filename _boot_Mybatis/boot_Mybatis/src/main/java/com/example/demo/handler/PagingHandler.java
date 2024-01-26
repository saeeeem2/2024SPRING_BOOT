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
}