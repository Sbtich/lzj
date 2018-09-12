package com.dingli.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.BusinessDto;
import com.dingli.comment.bean.Dictype;
import com.dingli.comment.service.BsService;
import com.dingli.comment.service.DicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BusinessController {
	
	@Autowired
	private BsService bsService;
	
	@Autowired
	private DicService ds;
	
//	@Autowired
//	private DicService dicService;
	//��ʾȫ��
	@RequestMapping("/getBsList")
	public String getBsList(@RequestParam(value="pageIndex",defaultValue="1") Integer i,Model m){
		PageHelper.startPage(i,3);
		List<Business> bsList=bsService.getBsList();
		PageInfo pageInfo=new PageInfo(bsList);
		m.addAttribute("bsPageList", pageInfo);
		return "businessList";
	}

	//ʵ����ӽ���ѡ��ť
	@RequestMapping("/addBusiness")
	public String addBusiness(Model m){
		Dictype dis=new Dictype();
		dis.setType("city");
		List<Dictype> cities=ds.getDicByType(dis);
		dis.setType("category");
		List<Dictype> categoies=ds.getDicByType(dis);
		m.addAttribute("city", cities);
		m.addAttribute("category", categoies);
		return "/businessAdd";
	}
	
	//ʵ�ֱ���
	@RequestMapping("/saveBs")
	public String saveAd(BusinessDto bsDto){
		bsService.saveBs(bsDto);
		return "redirect:getBsList";
	}
	
	//ʵ��ɾ������
	@RequestMapping("/deleted2")
	public String deleted(int id){
		bsService.deleted(id);
		return "redirect:getBsList";
	}
	
	//ʵ��titleģ����ѯ����
	@RequestMapping("/getOneBs")
	public String getOneBs(String title,Model m){
		List<Business> BsList=bsService.getOneList(title);
		PageInfo pageInfo=new PageInfo(BsList);
		m.addAttribute("bsPageList", pageInfo);
		return "businessList";	
	}
	
	//��ת���޸�ҳ�沢��ʾԭ����ֵ
	@RequestMapping("/bsmodify")
	public String bsmodify(Business bs,Model m){
		Dictype dis=new Dictype();//δ��ȡ�޸ĵ�city��categoryֵ
		dis.setType("city");
		List<Dictype> cities=ds.getDicByType(dis);
		dis.setType("category");
		List<Dictype> categoies=ds.getDicByType(dis);
		m.addAttribute("city", cities);
		m.addAttribute("category", categoies);
		BusinessDto bsDto=bsService.getBsById(bs);
		m.addAttribute("bs",bsDto);
		return "businessModify";
	}
	
	//ʵ���޸�
	@RequestMapping("/updateBs")
	public String updateAd(BusinessDto bsDto){
		bsService.updataBs(bsDto);
		return "redirect:getBsList";
	}

}
