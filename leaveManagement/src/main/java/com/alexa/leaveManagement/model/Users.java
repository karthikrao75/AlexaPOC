package com.alexa.leaveManagement.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	@OneToMany(mappedBy="users")
	private Collection<Leaves> leaves = new ArrayList<>();

	public Users() {
	}

	public Users(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Leaves> getLeaves() {
		return leaves;
	}

	public void setLeaves(Collection<Leaves> leaves) {
		this.leaves = leaves;
	}

	
}