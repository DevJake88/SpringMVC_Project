package com.land.app.vo;

public class NewsVO {
	private int nno;
	private String title;
	private String content;
	private String date;
	private String href;
	private String img;
	private String writingSource;
	
	public NewsVO() {
		super();
	}
	public NewsVO(int nno, String title, String content, String date, String href, String img, String writingSource) {
		super();
		this.nno = nno;
		this.title = title;
		this.content = content;
		this.date = date;
		this.href = href;
		this.img = img;
		this.writingSource = writingSource;
	}
	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getWritingSource() {
		return writingSource;
	}
	public void setWritingSource(String writingSource) {
		this.writingSource = writingSource;
	}
	
	
}
