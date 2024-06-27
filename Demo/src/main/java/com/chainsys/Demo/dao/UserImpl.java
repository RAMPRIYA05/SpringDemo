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
		String read="Select name,email_id,password from demo where delete_user=0";
		List<User> list=jdbcTemplate.query(read, new UserMapper());		
		return list;
	}

	@Override
	public void update(User user) {
	   String update="update demo set name=?,password=? where email_id=?";
	   Object[] params= {user.getName(),user.getPassword(),user.getEmailId()};
	   jdbcTemplate.update(update,params);		
	}

	@Override
	public void delete(User user) {
	String delete="update demo set delete_user=1 where email_id=?";
	Object[] params= {user.getEmailId()};
	jdbcTemplate.update(delete,params);		
	}

//	@Override
//	public List<User> search(User user) {
//		String search = "Select name,email_id,password from demo where email_id=? or name=? and delete_user=0";
//		Object[] params = { user.getEmailId(),user.getName()};
//		List<User> list = jdbcTemplate.query(search, new UserMapper(), params);
//		return list;
//	}
	@Override
	public List<User> search(String emailId){
		 String retrive = String.format 
	                (
	                    "SELECT name, email_id FROM demo " +
	                    "WHERE (name LIKE '%%%s%%' OR email_id LIKE '%%%s%%' ) " +
	                    "AND delete_user=0",
	                    emailId, emailId
	                );
        return jdbcTemplate.query(retrive, new UserMapper());
    }

}