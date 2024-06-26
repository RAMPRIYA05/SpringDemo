package com.chainsys.Demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.Demo.mapper.UserMapper;
import com.chainsys.Demo.model.User;

@Repository
public class UserImpl implements UserDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	UserMapper mapper;
	
	@Override
       public void insertDetails(User user) {
    	   String insert="insert into demo(name,email_id,password)values(?,?,?)";
    	   Object[] params= {user.getName(),user.getEmailId(),user.getPassword()};
    	   int rows=jdbcTemplate.update(insert,params);
    	   
    	   
}


	@Override
	public List<User> listUsers() {
		String read="Select name,email_id,password from demo";
		List<User> list=jdbcTemplate.query(read, new UserMapper());
		
		return list;
	}

	@Override
	public int update(User user) {
	   String update="update demo set name=?,password=? where email_id=?";
	   Object[] params= {user.getName(),user.getPassword(),user.getEmailId()};
	   int rows=jdbcTemplate.update(update,params);
		return rows;
	}

	@Override
	public void delete(User user) {
	String delete="delete from demo where email_id=?";
	Object[] params= {user.getEmailId()};
	jdbcTemplate.update(delete,params);
		
	}

	@Override
	public String search(String emailId) {
		String search="Select name,email_id,password from demo where email_id=?";
	String queryForObject=null;
	queryForObject=jdbcTemplate.queryForObject(search,String.class,emailId);
		
		return queryForObject;
		
	}

	@Override
	public List<User> listParticularUsers() {
		String read="Select name,email_id,password from demo where email_id=?";
		
		List<User> list=jdbcTemplate.query(read, new UserMapper());
		
		return list;
		
	}


	
}