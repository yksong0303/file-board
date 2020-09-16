package com.file.board.vo;


public class PhotoBoardVO {
	private int pbNum;
	private String pbTitle;
	private String pbContent;
	private String pbPhotoName;
	private String pbPhotoPath;
	private String credat;
	private String cretim;
	public int getPbNum() {
		return pbNum;
	}
	public void setPbNum(int pbNum) {
		this.pbNum = pbNum;
	}
	public String getPbTitle() {
		return pbTitle;
	}
	public void setPbTitle(String pbTitle) {
		this.pbTitle = pbTitle;
	}
	public String getPbContent() {
		return pbContent;
	}
	public void setPbContent(String pbContent) {
		this.pbContent = pbContent;
	}
	public String getPbPhotoName() {
		return pbPhotoName;
	}
	public void setPbPhotoName(String pbPhotoName) {
		this.pbPhotoName = pbPhotoName;
	}
	public String getPbPhotoPath() {
		return pbPhotoPath;
	}
	public void setPbPhotoPath(String pbPhotoPath) {
		this.pbPhotoPath = pbPhotoPath;
	}
	public String getCredat() {
		return credat;
	}
	public void setCredat(String credat) {
		this.credat = credat;
	}
	public String getCretim() {
		return cretim;
	}
	public void setCretim(String cretim) {
		this.cretim = cretim;
	}
	@Override
	public String toString() {
		return "PhotoBoardVO [pbNum=" + pbNum + ", pbTitle=" + pbTitle + ", pbContent=" + pbContent + ", pbPhotoName="
				+ pbPhotoName + ", pbPhotoPath=" + pbPhotoPath + ", credat=" + credat + ", cretim=" + cretim + "]";
	}

}
