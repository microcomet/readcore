/**
 * Copyright  2015 Clean-Read's Studio
 * 
 * All right reserved.
 * 
 * Created by fanwei on 2015年11月19日 下午9:35:59.
 */

package com.cleanread.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cleanread.model.User;
import com.cleanread.service.UserService;

/**
 * @author fanwei
 *
 */
@Controller
@RequestMapping("/user/")
public class UserAction {
	
	@Resource(name="userService")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("register.req")
	public ModelAndView register(String username, String password){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(username);
		userService.addUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ok");
		return mv;
	}
}
