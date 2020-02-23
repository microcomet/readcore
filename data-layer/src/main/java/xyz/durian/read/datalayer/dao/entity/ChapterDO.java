package xyz.durian.read.datalayer.dao.entity;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * #章节
 * <p>
 * #数据库对象
 *
 * @author fanwei
 * @version 1.0 28-9月-2018 0:24:48
 */
@Entity
@Table(name = "chapter")
public class ChapterDO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5970361340078397105L;

    @Id
    @Column(nullable = false, length = 36)
    private String id;
    /**
     * 章节名称
     */
    @Column(nullable = false, length = 100)
    private String name;
    /**
     * 章节副标题
     */
    @Column(length = 100)
    private String subName;

    @Transient
    private byte[] content;

    /**
     * 章节所属卷ID
     */
    @Column(nullable = false, length = 36)
    private String volumeId;

    /**
     * 上一章节ID
     */
    @Column(length = 36)
    private String preChapterId;

    /**
     * 下一章节ID
     */
    @Column(length = 36)
    private String nextChapterId;

    /**
     * 章节的创建时间
     */
    @Column(nullable = false)
    private LocalDateTime createTime;
    /**
     * 章节的更新时间
     */
    @Column
    private LocalDateTime updateTime;

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    public String getPreChapterId() {
        return preChapterId;
    }

    public void setPreChapterId(String preChapterId) {
        this.preChapterId = preChapterId;
    }

    public String getNextChapterId() {
        return nextChapterId;
    }

    public void setNextChapterId(String nextChapterId) {
        this.nextChapterId = nextChapterId;
    }

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
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

    @Override
    public String toString() {
    	List<String> summary = new ArrayList<String>();
    	summary.add(getId());
    	summary.add(getName());
    	summary.add(volumeId);
    	summary.add(preChapterId);
    	summary.add(nextChapterId);
        return String.join("--", summary);	
    }

}
