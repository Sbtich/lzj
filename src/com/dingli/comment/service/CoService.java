package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.CommentDto;

public interface CoService {
	
	public List<CommentDto> getAllCo();
	
	public List<CommentDto> getCoByCom(String comment);
	
	public List<CommentDto> getCo(CommentDto coDto);
}
