/**
 * Copyright  2015 Clean-Read's Studio
 * 
 * All right reserved.
 * 
 * Created by fanwei on 2015年12月11日 上午2:13:44.
 */

package com.cleanread.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author fanwei
 *
 */
public class Article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String articleId;
	private String author;
	private String articleName;
	private String description;
	private String last_update_time;
	private String headImgUrl;
	private List<Chapter> content;
	/**
	 * @return the articleId
	 */
	public String getArticleId() {
		return articleId;
	}
	/**
	 * @param articleId the articleId to set
	 */
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the articleName
	 */
	public String getArticleName() {
		return articleName;
	}
	/**
	 * @param articleName the articleName to set
	 */
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the last_update_time
	 */
	public String getLast_update_time() {
		return last_update_time;
	}
	/**
	 * @param last_update_time the last_update_time to set
	 */
	public void setLast_update_time(String last_update_time) {
		this.last_update_time = last_update_time;
	}
	/**
	 * @return the headImgUrl
	 */
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	/**
	 * @param headImgUrl the headImgUrl to set
	 */
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	/**
	 * @return the content
	 */
	public List<Chapter> getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(List<Chapter> content) {
		this.content = content;
	}
	
	
}
