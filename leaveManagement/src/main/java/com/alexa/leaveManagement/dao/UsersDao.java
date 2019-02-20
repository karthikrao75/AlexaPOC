package com.alexa.leaveManagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.alexa.leaveManagement.model.Users;

public interface UsersDao extends CrudRepository<Users, Integer> {

}
