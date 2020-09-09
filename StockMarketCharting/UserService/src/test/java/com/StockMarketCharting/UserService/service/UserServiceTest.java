package com.StockMarketCharting.UserService.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.StockMarketCharting.UserService.dao.UserDao;
import com.StockMarketCharting.UserService.model.User;
import com.StockMarketCharting.UserService.model.UserType;

public class UserServiceTest {

	@Mock
	private UserDao dao;
	@InjectMocks
	private UserServiceImpl serviceImpl;
	
	private User u1 = new User(1,"pratik","banjare","pb@gm.co",UserType.ADMIN,"0987654321", true);
	private User u2 = new User(2,"ouch","lel","ra@gm.co",UserType.REGULAR,"0987655677", false);
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindAllUser() {
		
		given(dao.findAll()).willReturn(Arrays.asList(u1,u2));
		
		Iterable<User> ul = serviceImpl.findAllUsers();
		
		assertThat(ul).hasSize(2);
		assertUserFields(((List<User>) ul).get(0));
		
		verify(dao,times(1)).findAll();
	}
	@Test
	public void testFindUserById() {
		given(dao.findById(1)).willReturn(Optional.of(u1));
		Optional<User> u = serviceImpl.findUserById(1);
		
		assertThat(u.isPresent()).isTrue();
		
		assertUserFields(u.get());
		
		verify(dao,times(1)).findById(1);
	}
	
	@Test
	public void testFindUserByName() {
		given(dao.findByName("pratik")).willReturn(Optional.of(u1));
		Optional<User> u = serviceImpl.findUserByName("pratik");
		assertThat(u.isPresent()).isTrue();
		assertUserFields(u.get());
		verify(dao, times(1)).findByName("pratik");
	}
	
	@Test
	public void testUpdateUser() {
		given(dao.save(u1)).willReturn(u1);
		User u = serviceImpl.updateUser(u1);
		assertUserFields(u);
		verify(dao, times(1)).save(u1);
		
	}
	
	@Test
	public void testAddUser() {
		given(dao.save(u1)).willReturn(u1);
		User u = serviceImpl.AddUser(u1);
		assertUserFields(u);
		verify(dao, times(1)).save	(u1);
		
	}
	
	
	public void assertUserFields( User u ) {
		assertThat( u.getUserId() ).isInstanceOf(Integer.class);
		assertThat( u.getUserId()).isEqualTo(1);
		assertThat(u.getUsername()).isEqualTo("pratik");
		assertThat( u.getEmailId()).isEqualTo("pb@gm.co");
		assertThat(u.getUserType()).isEqualTo(UserType.ADMIN);
		
		
	}
}
