package com.alexa.leaveManagement.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.alexa.leaveManagement.Vo.LeaveVO;
import com.alexa.leaveManagement.model.Leave;

@Component
public class LeaveManagementHelper {

	public Leave transformLeaveVo(LeaveVO leaveVO) {
		Leave leave = new Leave();
		leave.setStartDate(leaveVO.getStartDate());
		leave.setEndDate(leaveVO.getEndDate());
		leave.setLeaveReason(leaveVO.getLeaveReason());
		return leave;
	}

	public LeaveVO transformLeave(Leave leave) {
		LeaveVO leaveVO = new LeaveVO();
		leaveVO.setStartDate(leave.getStartDate());
		leaveVO.setEndDate(leave.getEndDate());
		leaveVO.setLeaveReason(leave.getLeaveReason());
		leaveVO.setUserName(leave.getUser().getUserName());
		return leaveVO;
	}

	public List<LeaveVO> transformLeaves(List<Leave> leaves) {
		return leaves.stream().map(e-> transformLeave(e)).collect(Collectors.toList());
	}
}
