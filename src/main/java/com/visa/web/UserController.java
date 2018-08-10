package com.visa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.entity.User;
import com.visa.service.AdminService;
import com.visa.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="api/admin/users", method=RequestMethod.GET)
	public @ResponseBody List<User> getUsers() {
		return adminService.getUsers();
	}
	
	@RequestMapping(value="api/admin/users", method=RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		adminService.addUser(user);;
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/admin/{email}", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("email") String email, @RequestBody User user){
		adminService.updateUser(email, user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/users/{email}", method=RequestMethod.GET)
	public @ResponseBody User getUsersByEmail(@PathVariable("email") String email) {
		return userService.getById(email);
	}
}
