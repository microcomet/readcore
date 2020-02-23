/**
 * Copyright © 2000-2019 by Fanwei, Inc. or related companies. All rights reserved. 
 */
package xyz.durian.read.datalayer.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author sgfan
 *
 */
@MappedSuperclass
public class VolumeProfile implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7180554321076170341L;
	/**
     * UUID
     */
    @Id
    @Column(nullable = false, length = 36)
	private String id;
    /**
     * 卷名
     */
    @Column(nullable = false, columnDefinition = " varchar(100) default 'default' ")
    private String name;
    private String subName;
    /**
     * 卷描述
     */
    @Column
    private String description;
    /**
     * 卷的创建时间
     */
    @Column(nullable = false)
    private LocalDateTime createTime;
    /**
     * 卷的更新时间
     */
    @Column
    private LocalDateTime updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
