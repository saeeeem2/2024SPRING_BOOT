package com.example.demo.domain;

import java.util.List;

public class BoardDTO {
	
	private BoardVO bvo;
	private List<FileVO> flist;
	
	public BoardDTO() {}
	
	public BoardDTO(BoardVO bvo, List<FileVO> flist) {
		this.bvo = bvo;
		this.flist = flist;
	}
	public BoardVO getBvo() {
		return bvo;
	}
	public void setBvo(BoardVO bvo) {
		this.bvo = bvo;
	}
	public List<FileVO> getFlist() {
		return flist;
	}
	public void setFlist(List<FileVO> flist) {
		this.flist = flist;
	}

	@Override
	public String toString() {
		return "BoardDTO [bvo=" + bvo + ", flist=" + flist + "]";
	}	
}
