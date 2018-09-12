package com.dingli.comment.bean;

import java.util.List;

public class BusinessDtoForApi {
	
	private boolean hasmore;
	
	private List<BusinessDto> data;
	
	public boolean isHasmore() {
		return hasmore;
	}

	public void setHasmore(boolean hasmore) {
		this.hasmore = hasmore;
	}

	public List<BusinessDto> getData() {
		return data;
	}

	public void setData(List<BusinessDto> data) {
		this.data = data;
	}


}
