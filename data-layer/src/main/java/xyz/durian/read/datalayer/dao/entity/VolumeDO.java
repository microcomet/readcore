package xyz.durian.read.datalayer.dao.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import xyz.durian.read.datalayer.model.VolumeProfile;

/**
 * 卷
 * <p>
 * 书籍的一册
 *
 * @author fanwei
 * @version 1.0 28-9月-2018 0:24:48
 */
@Entity
@Table(name = "volume")
public class VolumeDO extends VolumeProfile {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3115428196909353435L;

	/**
     * 卷所属书籍
     *
     * 卷与书籍存在多对一关系
     */
    @Column(nullable = false, length = 36)
    private String bookId;

    /**
     * 上一卷ID
     */
    @Column(length = 36)
    private String preVolumeId;

    /**
     * 下一卷ID
     */
    @Column(length = 36)
    private String nextVolumeId;

    /**
     * 卷内首章节ID
     */
    @Column(length = 36)
    private String headChapterId;

    /**
     * 卷内尾章节ID
     */
    @Column(length = 36)
    private String tailChapterId;

    /**
     * 当前卷内的章节数量
     */
    @Column(nullable = false, columnDefinition = " int default 0 ")
    private Integer chapterCount;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPreVolumeId() {
        return preVolumeId;
    }

    public void setPreVolumeId(String preVolumeId) {
        this.preVolumeId = preVolumeId;
    }

    public String getNextVolumeId() {
        return nextVolumeId;
    }

    public void setNextVolumeId(String nextVolumeId) {
        this.nextVolumeId = nextVolumeId;
    }

    public String getHeadChapterId() {
        return headChapterId;
    }

    public void setHeadChapterId(String headChapterId) {
        this.headChapterId = headChapterId;
    }

    public String getTailChapterId() {
        return tailChapterId;
    }

    public void setTailChapterId(String tailChapterId) {
        this.tailChapterId = tailChapterId;
    }

    public Integer getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }
    
    @Override
    public String toString() {
    	List<String> summary = new ArrayList<String>();
    	summary.add(getId());
    	summary.add(getName());
    	summary.add(bookId);
    	summary.add(headChapterId);
    	summary.add(tailChapterId);
    	summary.add(preVolumeId);
    	summary.add(nextVolumeId);
    	summary.add(String.valueOf(chapterCount));
    	return String.join("--", summary);
    }

}