package com.cleanread.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cleanread.model.User;
import com.cleanread.service.UserService;

public class UserTest {
	UserService userService;
	ApplicationContext ac = null;
	@Before
	public void setUp(){
		ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
	
	@Test
	public void testUserQuery(){
		User user = new User();
		user.setEmail("1234567@163.com");
		user.setUsername("张三");
		user.setPassword("123456");
		boolean result = ((UserService)ac.getBean("userService")).addUser(user);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void testUserQueryByEmail(){
		User user = new User();
		user.setEmail("1234567@163.com");
		user.setUsername("张三");
		user.setPassword("123456");
	    User actualUser = ((UserService)ac.getBean("userService")).queryUserByEmail("1234567@163.com");
		System.out.println(actualUser);
	}
	
	@Test
	public void testQueryAllUser(){
		List<User> resultList = ((UserService)ac.getBean("userService")).queryAllUser();
		System.out.println(resultList);
	}
	
	
	@Test
	public void testUpdateUser(){
		User user = new User();
		user.setEmail("1234567@163.com");
		user.setUsername("张三");
		user.setPassword("cabbage1");
	    boolean result = ((UserService)ac.getBean("userService")).updateUser(user);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testUpdateUserWithoutName(){
		User user = new User();
		user.setEmail("1234567@163.com");
		user.setUsername(null);
		user.setPassword("cabbage1");
	    boolean result = ((UserService)ac.getBean("userService")).updateUser(user);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testUpdateUserWithoutPassword(){
		User user = new User();
		user.setEmail("1234567@163.com");
		user.setUsername("张三");
		user.setPassword(null);
	    boolean result = ((UserService)ac.getBean("userService")).updateUser(user);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testUpdateUserWithNothing(){
		User user = new User();
		user.setEmail("1234567@163.com");
		user.setUsername(null);
		user.setPassword(null);
	    boolean result = ((UserService)ac.getBean("userService")).updateUser(user);
		Assert.assertEquals(true, result);
	}
	
	@After
	public void tearDown(){
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
