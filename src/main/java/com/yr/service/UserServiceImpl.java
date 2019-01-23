package com.yr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yr.entity.User;
import com.yr.mapper1.UserMapper;
import com.yr.mapper2.UserMapper2;

@Service
public class UserServiceImpl implements UserService {
	
//	@Autowired
//	private UserDao userDao;
//	
//	@Autowired
//	private UserDao2 userDao2;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserMapper2 userMapper2;

	@Override
	public Boolean ins(User user) {
		try {
			userMapper.ins(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
//	@Override
//	public String insterUser(String name, Integer age, String sex) {
//		boolean boo = userDao.insterUser(name+"aa",age,sex);
//		boolean bool = userDao.insterUser2(name+"bb", age, sex);
//		if(boo && bool){
//			return "succss";
//		}else {
//			return "error";
//		}
//	}
	
//	@Override
//	public String insterUser2(String name, Integer age, String sex) {
//		boolean boo = userDao2.insterUser(name,age,sex);
//		if(boo){
//			return "succss";
//		}else {
//			return "error";
//		}
//	}
//
//	@Override
//	public String insterUserSql(String name, Integer age, String sex) {
//		int res = userDao.insterUserSql(name, age, sex);
//		if(res == 1){
//			return "succss";
//		} else {
//			return "error";
//		}
//	}
//
//	@Override
//	public User getUserById(int id) {
//		return userDao.getUserById(id);
//	}
//
//	@Override
//	public int saveUserKey(User user) {
//		return userDao.saveUserKey(user);
//	}
//
//	@Override
//	public String updateUser(User user) {
//		int res = userDao.updateUser(user);
//		if(res == 1){
//			return "succss";
//		} else {
//			return "error";
//		}
//	}
//
//	@Override
//	public String deleteUser(User user) {
//		int res = userDao.updateUser(user);
//		if(res == 1){
//			return "succss";
//		} else {
//			return "error";
//		}
//	}

//	@Override
//	public List<User> selMybits() {
//		List<User> listUser = userMapper.sel();
//		return listUser;
//	}
//	
//	@Override
//	public List<User> selMybits2() {
//		List<User> listUser = userMapper2.sel();
//		return listUser;
//	}
}