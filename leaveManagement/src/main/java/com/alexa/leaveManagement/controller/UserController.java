package com.alexa.leaveManagement.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.leaveManagement.dao.UserRepository;
import com.alexa.leaveManagement.model.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String addUsers(@RequestBody() List<User> users) {
		userRepository.saveAll(users);
		return "User added successfully";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<String> getUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users.stream().map(e -> e.getUserName()).collect(Collectors.toList());
	}

}
