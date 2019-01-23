package com.yr.dao2;

import com.yr.entity.User;

public interface UserDao2 {
	public boolean insterUser(String name, Integer age, String sex);
	public int insterUserSql(String name, Integer age, String sex);
	public <T> User getUserById(Integer integer);
	public int saveUserKey(User user);
	public int updateUser(User user);
	public int deleteUser(User user);
}
