/**
 * Copyright  2015 Clean-Read's Studio
 * 
 * All right reserved.
 * 
 * Created by fanwei on 2015年11月2日 下午10:38:03.
 */

package com.cleanread.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cleanread.model.User;

/**
 * @author fanwei
 *
 */
public interface UserMapper {

	
	/**
	 * 用户表中插入一条记录
	 * @author fanwei
	 * @param user
	 */
	public void insert(User user);
	
	
	/**
	 * 用户表中更新一条记录
	 * @author fanwei
	 * @param user
	 */
	public void update(User user);
	
	
	/**
	 * 用户表中查询一条记录
	 * @author fanwei
	 * @param email
	 * @return
	 */
	public User selectByEmail(@Param("email")String email);
	
	
	/**
	 * 获取用户表所有记录
	 * @author fanwei
	 * @return
	 */
	public List<User> selectAll();
}
