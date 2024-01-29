package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class BoardVO {
	
	private long bno;
	private String title, writer, content, regAt, modAt;
	
	public BoardVO() {}
	
	public BoardVO(long bno, String title, String writer, String content, String regAt, String modAt) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regAt = regAt;
		this.modAt = modAt;
	}

	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regAt="
				+ regAt + ", modAt=" + modAt + "]";
	}
}
