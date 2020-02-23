package xyz.durian.read.cleanread.controller.model;


import java.util.List;

/**
 * 章节视图
 * <p>
 * 视图层对象
 *
 * @author fanwei
 * @version 1.0 28-9月-2018 0:39:58
 */
public class ChapterVO {

    private String bookId;
    private String bookName;
    private String chapterId;
    private String chapterName;
    private List<String> paragraphList;
    private String volumeId;
    private String volumeName;
    private String previousChapterId;
    private String nextChapterId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    public List<String> getParagraphList() {
        return paragraphList;
    }

    public void setParagraphList(List<String> paragraphList) {
        this.paragraphList = paragraphList;
    }

    public String getPreviousChapterId() {
        return previousChapterId;
    }

    public void setPreviousChapterId(String previousChapterId) {
        this.previousChapterId = previousChapterId;
    }

    public String getNextChapterId() {
        return nextChapterId;
    }

    public void setNextChapterId(String nextChapterId) {
        this.nextChapterId = nextChapterId;
    }
}