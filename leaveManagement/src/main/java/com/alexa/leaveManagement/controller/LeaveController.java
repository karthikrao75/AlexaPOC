package com.alexa.leaveManagement.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		User user = userRepository.findByUserName(leaveVO.getUserName());
		Leave leave = leaveManagementHelper.transformLeaveVo(leaveVO);
		leave.setUsers(user);
		leaveRepository.save(leave);
		return leaveVO;
	}

	@Transactional
	@RequestMapping(value = "/leave", method = RequestMethod.GET)
	public List<LeaveVO> getLeavePlan(@RequestParam("userName") String userName) {
		List<Leave> leaves = leaveRepository.findByStartDateGreaterThanEqualAndUser(new Date(),
				userRepository.findByUserName(userName));
		return leaveManagementHelper.transformLeaves(leaves);
	}

	@Transactional
	@RequestMapping(value = "/leave/upcoming", method = RequestMethod.GET)
	public List<LeaveVO> getUpComingLeavePlans() throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date todayWithZeroTime = formatter.parse(formatter.format(new Date()));
		List<Leave> leaves = leaveRepository.findByStartDateGreaterThanEqual(todayWithZeroTime);
		return leaveManagementHelper.transformLeaves(leaves);
	}

}
