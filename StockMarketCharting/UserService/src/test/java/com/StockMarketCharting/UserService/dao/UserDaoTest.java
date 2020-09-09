package com.StockMarketCharting.UserService.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.StockMarketCharting.UserService.model.User;

@DataJpaTest
public class UserDaoTest {
	
	@Autowired
	private UserDao dao;
	

	@Test
	public void testFindByName() {
		User u = dao.findByName( "pratik" ).get();
		assertEquals("pratik",u.getUsername());
		
	}
}
