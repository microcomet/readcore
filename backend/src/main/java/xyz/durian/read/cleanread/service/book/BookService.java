package xyz.durian.read.cleanread.service.book;

import xyz.durian.read.cleanread.controller.model.BookVO;
import xyz.durian.read.cleanread.controller.model.ChapterVO;
import xyz.durian.read.cleanread.controller.model.VolumeVO;

import java.util.List;

public interface BookService {

    ChapterVO getChapterByChapterId(String chapterId);

    List<VolumeVO> getContentsByBookId(String bookId);

    BookVO getBookById(String bookId);

    List<BookVO> getBooksByIds(Iterable<String> bookIds);

    List<BookVO> getAllBooks();

    void deleteBook(String bookId);

}
