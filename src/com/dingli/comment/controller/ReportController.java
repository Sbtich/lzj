package com.dingli.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dingli.comment.bean.Option;
import com.dingli.comment.service.OrderReportService;

@Controller
public class ReportController {
	
	@Autowired
	private OrderReportService ors;
	
	@ResponseBody
	@RequestMapping("/report")
	public Option getReport(){
		Option op=ors.getReport();
		return op;
	}
	
	@RequestMapping("/reportPage")
	public String pageReport(){
		return "orderCount";
	}
}
