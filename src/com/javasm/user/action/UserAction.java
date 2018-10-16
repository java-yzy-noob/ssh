package com.javasm.user.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.jasper.tagplugins.jstl.core.ForEach;

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
	public String selectUserList1() {
		userList = us.selectUserList();
		for (User user : userList) {
			System.out.println(user);
		}
		return "userPage";
		
	}


	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
