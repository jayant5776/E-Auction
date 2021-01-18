package com.cdac.cntr;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.User;
import com.cdac.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "users")
	@Transactional
	public String userAdd(@RequestBody User user) {
		userService.addUser(user);
		return "Hello" + user.getFirstName()+ "your registration is successfull";
	}
	
	@PostMapping(value = "/login")
	public User loginUser(@RequestBody User user) throws Exception{
		User retUser = null;
		if(user.getEmail() != null && user.getPassword() != null) {
			String email = user.getEmail();
			String password = user.getPassword();
			retUser = userService.fetchByEmailAndPassword(email, password);
		}
		
		if(retUser==null)
		{
			throw new Exception("bad credentials");
		}
		return retUser;
	}
	
	
	@GetMapping(value = "users")
	//public String userList() {
	public List<User> userList(){
		return userService.getAll();
		//return "index.jsp";
	}
	
	@DeleteMapping(value = "car_del/{userId}")
	public String userDelete(@PathVariable int userId) {
		userService.removeUser(userId);
		return "success";	
	}
	
	@GetMapping(value = "get_user/{userId}")
	public Optional<User> getUser(@PathVariable int userId) {
		return userService.getUser(userId);
	}
	
	@PutMapping(value = "user_update")
	public String updateUser(@RequestBody User user) {
		userService.modifyUser(user);
		return "success";
	}
	
}
