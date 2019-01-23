package com.yr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yr.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
//	@Qualifier("primaryJdbcTemplate") // 使用哪个数据源
	private JdbcTemplate jdbcTemplate;
	
	public boolean insterUser(String name, Integer age, String sex) {
		try {
			jdbcTemplate.update("insert into springBoot_user(`name`,age,sex) value(?,?,?);", name, age ,sex);
			int a = 1 / 0;
			System.out.println(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
     * 插入用户数据-防止sql注入
     * @param user
     * @return
     * @throws Exception
     */
    public int insterUserSql(final String name, final Integer age, final String sex){
        int resRow = jdbcTemplate.update("INSERT INTO springBoot_user(`name`,age,sex) VALUES(?,?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,name);
                ps.setInt(2,age);
                ps.setString(3,sex);
            }
        });
        System.out.println("操作结果记录数：  " + resRow);
        return resRow;
    }
	
    /**
     * 根据用户id获取用户
     * @param <T>
     * @param id
     * @return
     * @throws Exception
     */
    @Transactional(readOnly = true)
    public <T> User getUserById(Integer id){
    	String sql = "select * from springBoot_user where id=?";
    	RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
    	
    	//queryForObject:找不到会报异常  query:找不到则Null
//    	User user = (User)jdbcTemplate.queryForList(sql,new Object[]{id},rowMapper).;
        List<User> userList = (List<User>)jdbcTemplate.query(sql,rowMapper,id);
        User user=null;
        if (!userList.isEmpty()){
            user=userList.get(0);
        }
        System.out.println(user.toString());
        return user;
    }
	
	/**
     * 插入用户数据-防止sql注入-可以返回该条记录的主键（注意需要指定主键）
     * @param user
     * @return
     * @throws Exception
     */
    @Transactional
    public int saveUserKey(final User user) {
        final String sql="INSERT INTO springBoot_user(id,name,age,sex) VALUES(NULL,?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        int resRow=jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps=conn.prepareStatement(sql,new String[]{"id"}); //指定 id 为主键
                ps.setString(1,user.getName());
                ps.setInt(2,user.getAge());
                ps.setString(3,user.getSex());
                return ps;
            }
        },keyHolder);
        System.out.println("操作结果记录数：  "+resRow+" 主键: "+keyHolder.getKey());
        return Integer.parseInt(keyHolder.getKey().toString());
    }
 
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUser(final User user) {
        String sql="update springBoot_user set name = ?, age = ?, sex = ? where id = ?";
        int resRow=jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,user.getName());
                preparedStatement.setInt(2,user.getAge());
                preparedStatement.setString(3,user.getSex());
                preparedStatement.setInt(4,user.getId());
            }
        });
        System.out.println("操作结果记录数：  "+resRow);
        return resRow;
    }
 
    /**
     * 删除用户
     * @param user
     * @return
     * @throws Exception
     */
    public int deleteUser(final User user) {
        int resRow = jdbcTemplate.update("DELETE FROM springBoot_user WHERE id=?", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,user.getId());
            }
        });
        System.out.println("操作结果记录数：  "+resRow);
        return resRow;
    }

}
