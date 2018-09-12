package com.dingli.comment.bean;

import java.util.ArrayList;
import java.util.List;

public class Option {
	
	private Legend legend;
	
	private XAxis xAxis;
	
	private List series=new ArrayList();

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public XAxis getxAxis() {
		return xAxis;
	}

	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}

	public List getSeries() {
		return series;
	}

	public void setSeries(List series) {
		this.series = series;
	}

	

}
