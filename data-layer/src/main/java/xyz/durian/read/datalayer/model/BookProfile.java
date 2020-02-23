/**
 * Copyright © 2015-2019 by Fanwei, Inc. or related companies. All rights reserved. 
 */
package xyz.durian.read.datalayer.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * @author sgfan
 *
 */
@MappedSuperclass
public class BookProfile implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1565506774529326926L;
	/**
     * #书籍的作者
     */
	@Column(nullable = false, length = 36, name = "user_id")
    private String author;
    /**
     * #书籍简介
     */
    @Column
    private String description;
    @Id
    @Column(nullable = false, length = 36)
    private String id;
    /**
     * #书籍关键字
     */
    @Column(length = 200)
    private String keyWord;
    
    /**
     * #书籍名称
     */
    @Column(nullable = false, length = 100)
    private String name;
    /**
     * #书籍二级名称
     */
    @Column(length = 100)
    private String subName;
    @Transient
    private byte[] cover;
    @Transient
    private String category;
    /**
     * #创建时间
     */
    @Column(nullable = false)
    private LocalDateTime createTime;
    /**
     * #更新时间
     */
    @Column
    private LocalDateTime updateTime;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getCover() {
		return cover;
	}
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	
}
