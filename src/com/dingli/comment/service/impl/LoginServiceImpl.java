package com.dingli.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Member;
import com.dingli.comment.dao.MemberMapper;
import com.dingli.comment.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MemberMapper memberDao;
	
	@Override
	public boolean checkLogin(Member m) {
		
		List<Member> members=memberDao.selectByMember(m);
		
		return members.size()>0?true:false;
	}

}
