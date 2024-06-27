package com.chainsys.Demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.Demo.dao.UserDAO;
import com.chainsys.Demo.dao.UserImpl;
import com.chainsys.Demo.model.User;

@Controller
public class Sample {
    @Autowired
    UserDAO userDAO;
   JdbcTemplate jdbcTemplate;
     
	@RequestMapping("/home")
	public String home()
	{
		return "home.jsp";
	}
	
	@GetMapping("/register")
	public String saveDetails(@RequestParam("name")String name,@RequestParam("emailId")String emailId,@RequestParam("password")String password) {
		User user=new User();
		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);		
		userDAO.insertDetails(user);		
		return "success.jsp";		
	}
	
	@GetMapping("/listOfUsers")
	public String getAllUser(Model model)
	{		
		List<User> list=userDAO.listUsers();
		model.addAttribute("list",list);
		return "registerTable.jsp";	
	}
	
	@GetMapping("/update")
	public String updateDetails(@RequestParam("name")String name,@RequestParam("password")String password,@RequestParam("emailId")String emailId,Model model) {
		User user=new User();
		user.setName(name);		
		user.setPassword(password);
		user.setEmailId(emailId);
		userDAO.update(user);
		List<User> list=userDAO.listUsers();
		model.addAttribute("list",list);
		return "registerTable.jsp";
	}
	
	@GetMapping("/delete")
	public String deleteDetails(@RequestParam("emailId")String emailId,Model model)
	{
		User user=new User();
		user.setEmailId(emailId);
		userDAO.delete(user);
		List<User> list=userDAO.listUsers();
		model.addAttribute("list",list);
		return "registerTable.jsp";
	}
	
	@GetMapping("/search")
	public String searchDetails(@RequestParam("emailId")String emailId,Model model)
	{		
		
		List<User> list=userDAO.search(emailId);
		model.addAttribute("list",list);
		return "searchTable.jsp";
	}
	
}
