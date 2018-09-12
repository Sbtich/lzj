package com.dingli.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.CommentDto;
import com.dingli.comment.dao.CommentMapper;
import com.dingli.comment.service.CoService;
@Service
public class CoServiceImpl implements CoService {
	
	@Autowired
	private CommentMapper cm;

	@Override
	public List<CommentDto> getAllCo() {
		List<CommentDto> cms=cm.selectAll(null);
		return cms;
	}

	@Override
	public List<CommentDto> getCoByCom(String comment) {
		List<CommentDto> com=cm.selectByCom(comment);
		return com;
	}

	//app∆¿¬€
	@Override
	public List<CommentDto> getCo(CommentDto coDto) {
		List<CommentDto> comDto=cm.selectById(coDto.getId());
		return comDto;
	}

}
