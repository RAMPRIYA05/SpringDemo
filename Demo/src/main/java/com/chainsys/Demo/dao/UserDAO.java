package com.chainsys.Demo.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.chainsys.Demo.model.User;

@Repository
public interface UserDAO {
	public void insertDetails(User user);
	public List<User> listUsers();
	public void update(User user);
	void delete(User user);
	//List<User> search(User user);
	List<User> search(String emailId);
}
