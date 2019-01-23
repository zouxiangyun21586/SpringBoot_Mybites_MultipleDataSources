package com.yr.mapper2;

import java.util.List;

import com.yr.entity.User;

//@Mapper // 多数据源打开
//@Configuration
public interface UserMapper2 {
	public List<User> sel();
	public void ins(User user); // 插入
}