package com.dingli.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Dictype;
import com.dingli.comment.dao.DictypeMapper;
import com.dingli.comment.service.DicService;
@Service
public class DicServiceImpl implements DicService {
	
	@Autowired
	private DictypeMapper dm; 

	@Override
	public List<Dictype> getDicByType(Dictype dis) {
		List<Dictype> dic=dm.selectByType(dis);
		return dic;
	}

}
