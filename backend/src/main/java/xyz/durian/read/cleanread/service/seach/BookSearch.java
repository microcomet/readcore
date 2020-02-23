package xyz.durian.read.cleanread.service.seach;

import xyz.durian.read.cleanread.controller.model.BookVO;

import java.util.List;

public interface BookSearch {

    /**
     * 在书名、作者名、卷名、章节名中搜索
     * @param nameKeyword 搜索关键字
     * @return 书籍列表
     */
    List<BookVO> searchInTitles(String nameKeyword);

    /**
     * 在章节内容中搜索
     * TODO 这种搜索功能可能太慢，暂不提供
     * @param contentKeyword 搜索关键字
     * @return 书籍列表
     */
    List<BookVO> searchInContent(String contentKeyword);

}
