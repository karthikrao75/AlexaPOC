package com.alexa.leaveManagement.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alexa.leaveManagement.model.Leave;
import com.alexa.leaveManagement.model.User;

public interface LeaveRepository extends CrudRepository<Leave, Integer> {

	List<Leave> findByStartDateGreaterThanEqualAndUser(Date startDate, User user);

	List<Leave> findByStartDateGreaterThanEqual(Date futureDate);
}
