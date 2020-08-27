package com.StockMarketCharting.UserService.service;

import java.util.Optional;

import com.StockMarketCharting.UserService.model.User;

public interface UserService {
	
	public Iterable<User> findAllUsers();
	public Optional<User> findUserById(Integer userId);
	public Optional<User> findUserByName(String username);
	public User updateUser(User user);
	public User AddUser(User user);
}
