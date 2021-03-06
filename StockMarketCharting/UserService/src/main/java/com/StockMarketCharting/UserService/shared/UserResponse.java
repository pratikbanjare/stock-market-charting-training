package com.StockMarketCharting.UserService.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	
	private Integer userId;
	
	private String username;
	
	private String email;
		
	private String mobileNumber;
	
	private boolean confirmed; 

}
