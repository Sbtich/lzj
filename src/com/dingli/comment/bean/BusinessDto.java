package com.dingli.comment.bean;

import org.springframework.web.multipart.MultipartFile;

public class BusinessDto extends Business {
	
	private MultipartFile imgFile;
	
	private String img_url;
	
	private String img;
	
	private Integer mumber;
	
	private Integer page;
	
	private String keyword;

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getMumber() {
		return mumber;
	}

	public void setMumber(Integer mumber) {
		this.mumber = mumber;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
