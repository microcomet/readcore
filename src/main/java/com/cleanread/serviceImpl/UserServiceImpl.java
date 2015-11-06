/**
 * Copyright  2015 Clean-Read's Studio
 * 
 * All right reserved.
 * 
 * Created by fanwei on 2015年11月2日 下午10:32:35.
 */

package com.cleanread.serviceImpl;

import java.util.List;

import com.cleanread.mapper.UserMapper;
import com.cleanread.model.User;
import com.cleanread.service.UserService;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author fanwei
 *
 */
public class UserServiceImpl implements UserService{

	SqlSessionTemplate sqlSessionTemplate;

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try {
			UserMapper userDao = sqlSessionTemplate.getMapper(UserMapper.class);
			userDao.insert(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			UserMapper userDao = sqlSessionTemplate.getMapper(UserMapper.class);
			userDao.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User queryUserByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			UserMapper userDao = sqlSessionTemplate.getMapper(UserMapper.class);
			return userDao.selectByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		try {
			UserMapper userDao = sqlSessionTemplate.getMapper(UserMapper.class);
			return userDao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}


	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
