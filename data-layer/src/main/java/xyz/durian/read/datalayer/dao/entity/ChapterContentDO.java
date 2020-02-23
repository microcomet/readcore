/**
 * Copyright © 2000-2019 by Fanwei, Inc. or related companies. All rights reserved. 
 */
package xyz.durian.read.datalayer.dao.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author sgfan
 *
 */
@Entity
@Table(name = "chapter_content")
public class ChapterContentDO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2751742621244243149L;
	@Id
    @Column(nullable = false, length = 36)
	private String id;

    @Column
    private byte[] content;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
}
