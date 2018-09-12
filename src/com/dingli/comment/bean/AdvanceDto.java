package com.dingli.comment.bean;

import org.springframework.web.multipart.MultipartFile;

public class AdvanceDto extends Advance {
	
	private MultipartFile imgFile;
	
	private String img_url;
	
	private String img;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

}
