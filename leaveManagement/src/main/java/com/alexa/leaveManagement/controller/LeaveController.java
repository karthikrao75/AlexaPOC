package com.alexa.leaveManagement.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.leaveManagement.Vo.LeaveVO;
import com.alexa.leaveManagement.dao.LeaveRepository;
import com.alexa.leaveManagement.dao.UserRepository;
import com.alexa.leaveManagement.helper.LeaveManagementHelper;
import com.alexa.leaveManagement.model.Leave;
import com.alexa.leaveManagement.model.User;

@RestController
public class LeaveController {

	@Autowired
	private LeaveRepository leaveRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LeaveManagementHelper leaveManagementHelper;

	@RequestMapping(value = "/leave", method = RequestMethod.POST)
	public LeaveVO addLeavePlan(@RequestBody LeaveVO leaveVO) throws ParseException {
		User user = userRepository.findUserByUserName(leaveVO.getUserName());
		Leave leave= leaveManagementHelper.transformLeaveVo(leaveVO);
		leave.setUsers(user);
		leaveRepository.save(leave);
		return leaveVO;

	}

}
