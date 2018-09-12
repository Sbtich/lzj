package com.dingli.comment.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dingli.comment.bean.OrdersDto;
import com.dingli.comment.dao.BusinessMapper;
import com.dingli.comment.dao.OrdersMapper;
import com.dingli.comment.service.OrdersService;

@Service
public class OrdersServicrImpl implements OrdersService {
	@Value("${bs_img_url}")
	private String imgUrl;
	
	@Autowired
	private OrdersMapper om;
	
	@Autowired
	private BusinessMapper bm;

	@Override
	@Transactional
	public boolean addOrders(OrdersDto ordsDto) {
		om.addOrders(ordsDto);
		return bm.updateNumber(ordsDto)?true:false;
	}

	@Override
	public List<OrdersDto> oList(String username) {
		List<OrdersDto> ors=om.orderList(username);
		for(OrdersDto ordersDto:ors){
			ordersDto.setImg(imgUrl+ordersDto.getImg());
		}
		return ors;
	}

	@Override
	public List<OrdersDto> orders() {
		List<OrdersDto> ords=om.orders();
		return ords;
	}

	@Override
	public List<OrdersDto> selectByPhone(String phone) {
		return om.selectByPhone(phone);
	}

	

}
