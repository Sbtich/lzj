package com.dingli.comment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.comment.bean.Advance;
import com.dingli.comment.bean.AdvanceDto;
import com.dingli.comment.service.AdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class AdvanceController {

	@Autowired
	private AdService adService;
	
	@RequestMapping("/getAdList")
	public String getAdList(@RequestParam(value="pageIndex",defaultValue="1") Integer i,Model m){
		
		PageHelper.startPage(i,3);
		List<Advance> adList=adService.getAdList();
		PageInfo pageInfo=new PageInfo(adList);
		m.addAttribute("adPageList", pageInfo);
		return "adList";
	}
	
	@RequestMapping("/adAdd")
	public String addAd(){
		return "adAdd";
	}
	
	@RequestMapping("/saveAd")
	public String saveAd(AdvanceDto adDto){
		adService.saveAd(adDto);
		return "redirect:getAdList";
	}
	
	@RequestMapping(value="/selectByOne")
	public String selectByOne(String title,Model m){
		//System.out.println(title);
		List<Advance> adList=adService.getOne(title);
		PageInfo pageInfo=new PageInfo(adList);
		m.addAttribute("adPageList", pageInfo);
		return "adList";	
	}
	
	@RequestMapping("/deleted")
	public String deleted(int id){
		adService.deleted(id);
		return "redirect:getAdList";	
	}
	
	@RequestMapping("/modify")
	private String modify(Advance ad,Model m){
		AdvanceDto adDto=adService.getAdById(ad);
		m.addAttribute("ad",adDto);
		return "adModify";
	}
	
	@RequestMapping("/updateAd")
	public String updateAd(AdvanceDto adDto){
		adService.updateAd(adDto);
		return "redirect:getAdList";
	}
	

}
