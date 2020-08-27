package com.StockMarketCharting.UserService.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.StockMarketCharting.UserService.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	@Query(value = "select * from user u where u.username = ?1", nativeQuery = true)
	Optional<User> findByName(String username);
}
