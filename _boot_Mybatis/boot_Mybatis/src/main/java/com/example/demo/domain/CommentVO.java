package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {

	private long cno, bno;
	private String writer, content, regAt, modAt;
	public long getCno() {
		return cno;
	}
	
	public CommentVO() {}
	
	public CommentVO(long cno, long bno, String writer, String content, String regAt, String modAt) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.writer = writer;
		this.content = content;
		this.regAt = regAt;
		this.modAt = modAt;
	}

	public void setCno(long cno) {
		this.cno = cno;
	}
	public long getBno() {
		return bno;
	}
	public void setBno(long bno) {
		this.bno = bno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegAt() {
		return regAt;
	}
	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}
	public String getModAt() {
		return modAt;
	}
	public void setModAt(String modAt) {
		this.modAt = modAt;
	}
	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", bno=" + bno + ", writer=" + writer + ", content=" + content + ", regAt="
				+ regAt + ", modAt=" + modAt + "]";
	}
	
	
}

