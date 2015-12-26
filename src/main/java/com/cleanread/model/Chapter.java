/**
 * Copyright  2015 Clean-Read's Studio
 * 
 * All right reserved.
 * 
 * Created by fanwei on 2015年12月11日 上午2:18:02.
 */

package com.cleanread.model;

import java.io.Serializable;

/**
 * @author fanwei
 *
 */
public class Chapter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chapterId;
	private String chapterName;
	private String content;
	/**
	 * @return the chapterId
	 */
	public String getChapterId() {
		return chapterId;
	}
	/**
	 * @param chapterId the chapterId to set
	 */
	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}
	/**
	 * @return the chapterName
	 */
	public String getChapterName() {
		return chapterName;
	}
	/**
	 * @param chapterName the chapterName to set
	 */
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
