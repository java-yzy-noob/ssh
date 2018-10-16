package com.javasm.user.action;

import java.util.List;

import javax.annotation.Resource;

import com.javasm.user.model.User;
import com.javasm.user.service.IUserService;

public class UserAction {
	
	private List<User> userList;
	@Resource
	private IUserService us;
	
	

	public String selectUserList() {
		userList = us.selectUserList();
		return "userJson";
		
	}


	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
