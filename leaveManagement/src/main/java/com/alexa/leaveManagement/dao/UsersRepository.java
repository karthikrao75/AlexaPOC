package com.alexa.leaveManagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.alexa.leaveManagement.model.User;

public interface UsersRepository extends CrudRepository<User, Integer> {

	User findUserByUserName(String userName);
}
