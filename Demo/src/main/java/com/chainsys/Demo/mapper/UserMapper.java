package com.chainsys.Demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.Demo.model.User;


public class UserMapper implements RowMapper<User> {

	
	
	public User mapRow(ResultSet rs,int rowNum) throws SQLException {
		User user=new User();
		String name=rs.getString("name");
				String emailId=rs.getString("email_id");
				String password=rs.getString("password");
				user.setName(name);
				user.setEmailId(emailId);
				user.setPassword(password);
				return user;
	}
}
