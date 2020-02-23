package xyz.durian.read.cleanread.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.durian.read.cleanread.controller.model.BookVO;
import xyz.durian.read.cleanread.controller.model.Catalogue;
import xyz.durian.read.cleanread.controller.model.ChapterVO;
import xyz.durian.read.cleanread.controller.model.VolumeVO;
import xyz.durian.read.cleanread.controller.model.query.RequestParameterValidator;
import xyz.durian.read.cleanread.service.book.BookService;

import java.util.List;
import java.util.Objects;

/**
 * clean-read
 * <p>
 * 书籍请求
 *
 * @author fanwei
 * @version 1.0 created at 2018/9/28 22:40
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;

    private RequestParameterValidator requestParameterValidator;

    @Autowired
    public BookController(BookService bookService, RequestParameterValidator requestParameterValidator) {
        this.bookService = bookService;
        this.requestParameterValidator = requestParameterValidator;
    }

    @GetMapping("/")
    @ResponseBody
    public List<BookVO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    @ResponseBody
    public Catalogue bookCatalogue(@PathVariable("bookId") String bookId) {
        if (Objects.nonNull(bookId) && bookId.trim().length() > 0) {
            BookVO bookVO = bookService.getBookById(bookId);
            List<VolumeVO> contents = bookService.getContentsByBookId(bookId);
            Catalogue catalogue = new Catalogue();
            catalogue.setBookVO(bookVO);
            catalogue.setVolumeVOS(contents);
            return catalogue;
        }
        return null;
    }

    @GetMapping("/{bookId}/{chapterId}")
    @ResponseBody
    public ChapterVO chapterContent(@PathVariable("bookId") String bookId, @PathVariable("chapterId") String chapterId) {
        if (requestParameterValidator.checkUUID(bookId) && requestParameterValidator.checkUUID(chapterId)) {
            return bookService.getChapterByChapterId(chapterId);
        }
        return null;
    }

    @PostMapping("/delete/{bookId}")
    @ResponseBody
    public void deleteBook(@PathVariable String bookId) {
        logger.info("delete book {}", bookId);
        bookService.deleteBook(bookId);
    }

}
