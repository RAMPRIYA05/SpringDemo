package com.chainsys.Demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.Demo.model.User;

@Repository
public interface UserDAO {
     public void insertDetails(User user);
     public List<User> listUsers();
     public int update(User user);
	void delete(User user);
	
	List<User> listParticularUsers();
	String search(String emailId);
}
