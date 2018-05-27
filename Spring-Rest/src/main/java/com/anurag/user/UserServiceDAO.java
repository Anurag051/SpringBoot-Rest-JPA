package com.anurag.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServiceDAO {
	
	private static List<User> users=new ArrayList<>();
	private int counter=3;
	
	static{
		users.add(new User(1, "anurag", new Date()));
		users.add(new User(2, "biky", new Date()));
		users.add(new User(3, "rahul", new Date()));
		users.add(new User(4, "ria", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User saveUser(User user) {
		if (user.getId()==null) {
			user.setId(++counter);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}

}
