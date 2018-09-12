package com.dingli.comment.bean;

import java.util.ArrayList;
import java.util.List;

public class Series {
	
	private String type;
	
	private String name;
	
	private String stack;
	
	private List data=new ArrayList();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

}
