package com.javasm.user;

import java.util.List;

import com.javasm.user.dao.UserDAO;
import com.javasm.user.model.User;


public class Test {

	public static void main(String[] args) {
		List<User> list = new UserDAO().findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
