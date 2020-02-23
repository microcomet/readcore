package xyz.durian.read.cleanread.controller.model;

import java.util.List;

/**
 * 书籍目录
 */
public class Catalogue {

    /**
     * 书籍信息
     */
    private BookVO bookVO;

    /**
     * 书籍目录
     */
    private List<VolumeVO> volumeVOS;

    public BookVO getBookVO() {
        return bookVO;
    }

    public void setBookVO(BookVO bookVO) {
        this.bookVO = bookVO;
    }

    public List<VolumeVO> getVolumeVOS() {
        return volumeVOS;
    }

    public void setVolumeVOS(List<VolumeVO> volumeVOS) {
        this.volumeVOS = volumeVOS;
    }
}
