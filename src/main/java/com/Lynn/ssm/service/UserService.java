package com.Lynn.ssm.service;

import java.util.List;

import com.Lynn.ssm.entity.User;

public interface UserService {

	List<User> getUserList(int offset, int limit);
	 
}
