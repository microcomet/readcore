/**
 * Copyright  2015 Clean-Read's Studio
 * 
 * All right reserved.
 * 
 * Created by fanwei on 2015年11月2日 下午10:15:27.
 */

package com.cleanread.service;

import java.util.List;

import com.cleanread.model.User;

/**
 * @author fanwei
 *
 */
/**
 * @author fanwei
 *
 */
public interface UserService {

	/**
	 * 新增用户
	 * @author fanwei
	 * @param user 新增用户信息
	 * @return 返回是否增加成功标志
	 */
	public boolean addUser(User user);
	
	
	/**
	 * 更新用户
	 * @author fanwei
	 * @param user 更新用户信息
	 * @return 返回是否更新成功标志
	 */
	public boolean updateUser(User user);
	
	
	/**
	 * 根据邮箱查询用户
	 * @author fanwei
	 * @param email 用户邮箱
	 * @return 返回单个用户
	 */
	public User queryUserByEmail(String email);
	
	
	/**
	 * 查询数据库当前的所有用户信息
	 * @author fanwei
	 * @return 返回用户列表
	 */
	public List<User> queryAllUser();
}
