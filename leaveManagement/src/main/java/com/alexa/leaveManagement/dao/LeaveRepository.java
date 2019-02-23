package com.alexa.leaveManagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.alexa.leaveManagement.model.Leave;

public interface LeaveRepository extends CrudRepository<Leave, Integer>{

}
