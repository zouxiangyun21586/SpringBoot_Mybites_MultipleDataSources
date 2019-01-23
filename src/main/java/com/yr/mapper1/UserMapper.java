package com.yr.mapper1;

import java.util.List;

import com.yr.entity.User;

//@Mapper // 多数据源打开
//@Configuration
public interface UserMapper {
	public List<User> sel();
	public void ins(User user); // 插入
}