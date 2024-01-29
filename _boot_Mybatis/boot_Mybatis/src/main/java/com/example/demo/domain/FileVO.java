package com.example.demo.domain;

public class FileVO {
	
	private String uuid,saveDir,fileName,regAt;
	private int fileType;
	private long bno,fileSize;
	
	public FileVO() {}
	
	public FileVO(String uuid, String saveDir, String fileName, String regAt, int fileType, long bno, long fileSize) {
		super();
		this.uuid = uuid;
		this.saveDir = saveDir;
		this.fileName = fileName;
		this.regAt = regAt;
		this.fileType = fileType;
		this.bno = bno;
		this.fileSize = fileSize;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getSaveDir() {
		return saveDir;
	}

	public void setSaveDir(String saveDir) {
		this.saveDir = saveDir;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRegAt() {
		return regAt;
	}

	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
		this.bno = bno;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "FileVO [uuid=" + uuid + ", saveDir=" + saveDir + ", fileName=" + fileName + ", regAt=" + regAt
				+ ", fileType=" + fileType + ", bno=" + bno + ", fileSize=" + fileSize + "]";
	}
}
