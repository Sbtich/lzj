package com.dingli.comment.bean;

import java.util.ArrayList;
import java.util.List;

public class XAxis {
	
	private String type;
	
	private boolean boundaryGap;
	
	private List data=new ArrayList();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getBoundaryGap() {
		return boundaryGap;
	}

	public void setBoundaryGap(boolean boundaryGap) {
		this.boundaryGap = boundaryGap;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

}
