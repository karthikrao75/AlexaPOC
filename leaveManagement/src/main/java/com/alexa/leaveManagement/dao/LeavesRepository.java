package com.alexa.leaveManagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.alexa.leaveManagement.model.Leaves;

public interface LeavesRepository extends CrudRepository<Leaves, Integer>{

}
