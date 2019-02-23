package com.alexa.leaveManagement.dao;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.alexa.leaveManagement.model.Leave;

public interface LeaveRepository extends CrudRepository<Leave, Integer> {

	@Query("select l from Leave l where userName = :userName and startDate >= :futureDate")
	Stream<Leave> findFutureLeavesByUser(@Param("userName") String userName,@Param("futureDate") Date futureDate);

	@Query("select l from Leave l where startDate >= :futureDate")
	Stream<Leave> findUpcomingLeavePlans(@Param("futureDate") Date futureDate);
}
