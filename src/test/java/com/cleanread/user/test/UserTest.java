package com.cleanread.user.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cleanread.entity.User;
import com.cleanread.mybatis.entitymapper.UserMapper;
import com.cleanread.mybatis.util.MyBatisUtils;

public class UserTest {
	SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void setUp(){
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	@Test
	public void testUserQuery(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper  = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectUserByEmail("123456@qq.com");
		User exceptedUser = new User();
		exceptedUser.setEmail("123456@qq.com");
		sqlSession.close();
		Assert.assertEquals(exceptedUser, user);
	}
	
	@After
	public void tearDown(){
		
	}
}
