package com.dingli.comment.service;

import java.math.BigDecimal;
import java.util.List;

import com.dingli.comment.bean.OrdersDto;

public interface OrdersService {
	
	public List<OrdersDto> oList(String username);

	public boolean addOrders(OrdersDto ordsDto);
	
	public List<OrdersDto> orders();
	
	public List<OrdersDto> selectByPhone(String phone);
}
