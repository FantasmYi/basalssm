package com.Lynn.ssm.service.impl;

import com.Lynn.ssm.cache.RedisCache;
import com.Lynn.ssm.dao.UserDao;
import com.Lynn.ssm.entity.User;
import com.Lynn.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDao userDao;

	
	
	@Override
	public List<User> getUserList(int offset, int limit) {
		String cache_key=RedisCache.CAHCENAME+"|getUserList|"+offset+"|"+limit;
		//先去缓存中取
		List<User> result_cache=userDao.queryAll(offset, limit);

		return result_cache;
	}
	
	

}
