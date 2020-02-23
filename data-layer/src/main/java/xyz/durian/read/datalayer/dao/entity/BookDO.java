package xyz.durian.read.datalayer.dao.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import xyz.durian.read.datalayer.model.BookProfile;

/**
 * #书籍的数据库层对象
 *
 * @author fanwei
 * @version 1.0 28-9月-2018 0:24:48
 */
@Entity
@Table(name = "book")
public class BookDO extends BookProfile {

    /**
	 *序列号 
	 */
	private static final long serialVersionUID = -1632903768485157208L;

    /**
     * #书籍所属书籍类别
     */
    @Column(nullable = false, length = 36)
    private String categoryId;

    /**
     * #卷的数量
     */
    @Column(nullable = false, columnDefinition = " int default 0 ")
    private Integer volumeCount;

    /**
     * #首卷ID
     */
    @Column(length = 36)
    private String headVolumeId;

    /**
     * #尾卷ID
     */
    @Column(length = 36)
    private String tailVolumeId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getVolumeCount() {
        return volumeCount;
    }

    public void setVolumeCount(Integer volumeCount) {
        this.volumeCount = volumeCount;
    }

    public String getHeadVolumeId() {
        return headVolumeId;
    }

    public void setHeadVolumeId(String headVolumeId) {
        this.headVolumeId = headVolumeId;
    }

    public String getTailVolumeId() {
        return tailVolumeId;
    }

    public void setTailVolumeId(String tailVolumeId) {
        this.tailVolumeId = tailVolumeId;
    }
    
    @Override
    public String toString() {
    	List<String> summary = new ArrayList<String>();
    	summary.add(getId());
    	summary.add(getName());
    	summary.add(getAuthor());
    	summary.add(headVolumeId);
    	summary.add(tailVolumeId);
    	summary.add(String.valueOf(volumeCount));
    	return String.join("--", summary);
    }

}