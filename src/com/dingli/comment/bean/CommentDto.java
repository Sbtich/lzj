package com.dingli.comment.bean;

public class CommentDto extends Comment {
	
	private String orders_id;//”√ªßid
	
	private String create_time;
	
	private int page;
	
	private String username;
	
	private String order_id;//∂©µ•∫≈
	
	private String phone;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(String orders_id) {
		this.orders_id = orders_id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
