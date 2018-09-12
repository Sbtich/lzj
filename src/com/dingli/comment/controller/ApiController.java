package com.dingli.comment.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dingli.comment.bean.AdvanceDto;
import com.dingli.comment.bean.BusinessDto;
import com.dingli.comment.bean.BusinessDtoForApi;
import com.dingli.comment.bean.CommentDto;
import com.dingli.comment.bean.CommentDtoForApi;
import com.dingli.comment.bean.Orders;
import com.dingli.comment.bean.OrdersDto;
import com.dingli.comment.cacha.Commen;
import com.dingli.comment.cacha.LoginCode;
import com.dingli.comment.service.AdService;
import com.dingli.comment.service.BsService;
import com.dingli.comment.service.CoService;
import com.dingli.comment.service.MemService;
import com.dingli.comment.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class ApiController {
	@Autowired
	private AdService adService;
	
	@Autowired
	private BsService bsService;
	
	@Autowired
	private CoService coService;
	
	@Autowired
	private MemService ms;
	
	@Autowired
	private OrdersService os;
	
	
	//首页广告数据接口
	@RequestMapping("/api/homead")
	public List<AdvanceDto> getAllAdForApi(){
		PageHelper.startPage(1,6);
		List<AdvanceDto> dtos=adService.getAdListForApi();
		//System.out.println(dtos);
		PageInfo pageInfo=new PageInfo(dtos);
		return pageInfo.getList();
	}
	
	//猜你喜欢（首页商户列表推荐）
	@RequestMapping("/api/homelist/{city}/{page}")
	public BusinessDtoForApi getLoveBsDtoFor(BusinessDto dto){
		dto.setPage(dto.getPage()+1);
		PageHelper.startPage(dto.getPage(),5);
		List<BusinessDto> bsList=bsService.getBusListForApi(dto);
		PageInfo pg=new PageInfo(bsList);
		//System.out.println(bsList);
		BusinessDtoForApi dtoForApi=new BusinessDtoForApi();
		dtoForApi.setHasmore(!pg.isIsLastPage());
		dtoForApi.setData(pg.getList());
		//System.out.println(dtoForApi);
		return dtoForApi;
	}
	
	//根据关键字查询
	@RequestMapping("/api/search/{page}/{city}/{category}/{keyword}")
	public BusinessDtoForApi getLoveBsDtoFor2(BusinessDto dto){
		//System.out.println(dto.getKeyword());
		dto.setPage(dto.getPage()+1);
		dto.setKeyword("%"+dto.getKeyword()+"%");
		PageHelper.startPage(dto.getPage(),5);
		List<BusinessDto> bsList=bsService.searchBsForApi2(dto);
		PageInfo pg=new PageInfo(bsList);
		//System.out.println(bsList);
		BusinessDtoForApi dtoForApi=new BusinessDtoForApi();
		dtoForApi.setHasmore(!pg.isIsLastPage());
		dtoForApi.setData(bsList);
		//System.out.println(dtoForApi);
		return dtoForApi;
	}
	
	//根据类别查询
	@RequestMapping("/api/search/{page}/{city}/{category}")
	public BusinessDtoForApi searchBsForApi(BusinessDto dto){
		dto.setPage(dto.getPage()+1);
		PageHelper.startPage(dto.getPage(),5);
		List<BusinessDto> bsList=bsService.searchBsForApi(dto);
		PageInfo pg=new PageInfo(bsList);
		BusinessDtoForApi dtoForApi=new BusinessDtoForApi();
		dtoForApi.setHasmore(!pg.isIsLastPage());
		dtoForApi.setData(pg.getList());
		//System.out.println(dtoForApi);
		return dtoForApi;
	}
	
	//显示商户详细信息
	@RequestMapping("/api/detail/info/{id}")
	public BusinessDto getBsMsg(BusinessDto dto){
		BusinessDto bsMsg=bsService.getBssById(dto);
		return bsMsg;
	}
	
	//显示商户评论信息
	@RequestMapping("/api/detail/comment/{page}/{id}")
	public CommentDtoForApi getCo(CommentDto coDto){
		coDto.setPage(coDto.getPage()+1);
		PageHelper.startPage(coDto.getPage(),5);
		List<CommentDto> cDto=coService.getCo(coDto);
		//System.out.println(cDto);
		PageInfo pg=new PageInfo(cDto);
		CommentDtoForApi dtoForApi=new CommentDtoForApi();
		dtoForApi.setHasmore(!pg.isIsLastPage());
		dtoForApi.setData(pg.getList());
		//System.out.println(dtoForApi);
		return dtoForApi;
	}
	
	//获得验证码
	@RequestMapping("/api/sms")
	public LoginCode sendCode(@RequestParam("username") String username){
		LoginCode lCode=new LoginCode();
		if(!ms.checkUserName(username)){
			lCode.setErrno(1);
			lCode.setMsg("该手机号没有注册");
			return lCode;
		}
		lCode.setErrno(0);
		double codeDouble=Math.random()*100000;
		String code=String.valueOf(Math.round(codeDouble));
		lCode.setCode(code);
		lCode.setMsg(code);
		Commen.codeMap.put(username, code);
		//System.out.println(Commen.codeMap);
		return lCode;
	}
	
	// 登录
	@RequestMapping("/api/login")
	public LoginCode Login(@RequestParam("username") String username,@RequestParam("code") String code) {
		LoginCode lCode=new LoginCode();
		//System.out.println(code);
		if(!Commen.codeMap.containsKey(username)){
			lCode.setErrno(1);
			lCode.setMsg("不存在该用户");
			return lCode;
		}
//		if(!Commen.codeMap.get(username).equals(code)){
//			lCode.setErrno(1);
//			lCode.setMsg("验证码不正确");
//			return lCode;
//		}
		lCode.setErrno(0);
		lCode.setMsg("登录成功");
		String uuid=UUID.randomUUID().toString().replace("-", "");
		lCode.setToken(uuid);
		Commen.tokenMap.put(username, uuid);
		return lCode;
	}
	
	//购买
	@RequestMapping("/api/order")
	public LoginCode buy(@RequestParam("username") String username,@RequestParam("id") String id,@RequestParam("token") String token,
			@RequestParam("num") Integer num,@RequestParam("price") Double price) {
		LoginCode lCode=new LoginCode();
		if(!Commen.tokenMap.containsKey(username)){
			lCode.setErrno(1);
			lCode.setMsg("用户未登录");
			return lCode;
		}
		if(!Commen.tokenMap.get(username).equals(token)){
			lCode.setErrno(1);
			lCode.setMsg("用户未登录");
			return lCode;
		} 
		OrdersDto oDto=new OrdersDto();
		oDto.setBusinessId(Integer.valueOf(id));
		oDto.setUsername(username);
		oDto.setNum(num);
		oDto.setPrice(BigDecimal.valueOf(price));
		if (!os.addOrders(oDto)) {
			lCode.setErrno(1);
			lCode.setMsg("购买失败");
			return lCode;
		}
		lCode.setErrno(0);
		lCode.setMsg("购买成功");
		return lCode;
	}
	
	//订单列表
	@RequestMapping("/api/orderlist/{username}")
	public List<OrdersDto> orderList(OrdersDto ordsDto){
		System.out.println(ordsDto.getUsername());
		List<OrdersDto> cDto=os.oList(ordsDto.getUsername());
		return cDto;
	}

}
