package com.javasm.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javasm.user.dao.UserDAO;
import com.javasm.user.model.User;

@Service
public class UserService implements IUserService{
	
	@Resource
	private UserDAO ud;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectUserList() {
		return ud.findAll();
	}
	
}
