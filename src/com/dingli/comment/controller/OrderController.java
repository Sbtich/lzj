package com.dingli.comment.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.comment.bean.OrdersDto;
import com.dingli.comment.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class OrderController {
	
	@Autowired
	private OrdersService os;
	
	@RequestMapping("/getOrList")
	public String orders(@RequestParam(value="pageIndex",defaultValue="1")Integer i,Model m){
		PageHelper.startPage(i, 3);
		List<OrdersDto> ors=os.orders();
		PageInfo pg=new PageInfo(ors);
		m.addAttribute("OrPageList", pg);
		return "orderList";
	}
	
	@RequestMapping("/selectByPhone")
	public String selectByPhone(String phone,Model m){
		List<OrdersDto> ord=os.selectByPhone(phone);
		PageInfo pg=new PageInfo(ord);
		m.addAttribute("OrPageList", pg);
		return "orderList";
	}
}
