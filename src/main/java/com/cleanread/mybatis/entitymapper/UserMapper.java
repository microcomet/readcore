package com.cleanread.mybatis.entitymapper;

import com.cleanread.entity.User;

public interface UserMapper {
	/*
	 * @author fanwei
	 * @param email 用户的电子邮件，唯一标识一个用户
	 * @return User 返回一个用户对象
	 * */
	public User selectUserByEmail(String email);
	
	/*
	 * @author fanwei
	 * @param email 用户的电子邮件，唯一标识一个用户
	 * @return boolean 返回是否删除成功标志
	 * */
	public boolean deleteUserByEmail(String email);
	
	/*
	 * @author fanwei
	 * @param email 用户的电子邮件，唯一标识一个用户
	 * @return boolean 返回密码是否成功修改标志
	 * */
	public boolean modifyPassword(String email);
	
	/*
	 * @author fanwei
	 * @param email 用户的电子邮件，唯一标识一个用户
	 * @return boolean 返回用户名是否成功修改标志
	 * */
	public boolean modifyUserName(String email);
}
