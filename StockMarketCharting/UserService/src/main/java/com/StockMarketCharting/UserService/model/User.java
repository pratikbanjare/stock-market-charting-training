package com.StockMarketCharting.UserService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="user_type")
	private UserType userType;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="confirmed")
	private boolean confirmed; 
}
