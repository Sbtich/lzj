package com.dingli.comment.service.impl;

import com.dingli.comment.bean.Member;
import com.dingli.comment.dao.MemberMapper;
import com.dingli.comment.service.MemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemServiceImpl implements MemService {
	
	@Autowired
	private MemberMapper mm;

	@Override
	public boolean checkUserName(String username) {
		List<Member> m=mm.selectByp(username);
		if(m.size()>0){
			return true;
		}else{
			return false;
		}
	}


}
