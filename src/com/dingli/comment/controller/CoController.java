package com.dingli.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.comment.bean.Comment;
import com.dingli.comment.bean.CommentDto;
import com.dingli.comment.service.CoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CoController {
	
	@Autowired
	private CoService coService;
	
	@RequestMapping("/getCoList")
	public String getCoList(@RequestParam(value="pageIndex",defaultValue="1") Integer i,Model m){
		PageHelper.startPage(i,3);
		List<CommentDto> coList=coService.getAllCo();
		//System.out.println(coList);
		PageInfo pageInfo=new PageInfo(coList);
		m.addAttribute("CoPageList", pageInfo);
		return "commentList";
	}
	
	@RequestMapping("getOneCo")
	public String getOneCo(String comment,Model m){
		System.out.println(comment);
		List<CommentDto> coList=coService.getCoByCom(comment);
		System.out.println(coList);
		PageInfo pageInfo=new PageInfo(coList);
		m.addAttribute("CoPageList", pageInfo);
		return "commentList";
	}

}
