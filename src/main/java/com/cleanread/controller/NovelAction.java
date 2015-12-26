/*
 * Copyright  2015 Clean-Read's Studio
 * 
 * All right reserved.
 * 
 * Created by fanwei on 2015年12月11日 上午2:07:34.
 */
package com.cleanread.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cleanread.model.Article;
import com.cleanread.model.Chapter;
import com.cleanread.service.NovelService;

@Controller
@RequestMapping("/pages/novel/")
public class NovelAction {
	@Resource(name="novelService")
	NovelService novelService;
	
	@CrossOrigin(origins={"chrome-extension://kebbgifdcejanmjnkobjjpjhcbdnofia"})
	@RequestMapping(value = "saveOneArticle.req", method = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.HEAD})
	public ModelAndView saveAritcle(@RequestBody Article article){
		List<?> articleContent = article.getContent();
		int count = 0;
		for(int i = 0; i < articleContent.size(); i++){
			Chapter cp = (Chapter) articleContent.get(i);
			if(cp.getContent() != null) count++;
		}
		System.out.println("fw" + count);
		novelService.saveArticle(article);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/pages/novel/saveStatus.html");
//		mv.addObject("userName", "fanwei");
		return mv;
	}
	
}
