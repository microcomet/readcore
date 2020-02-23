package xyz.durian.read.cleanread.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyz.durian.read.cleanread.controller.model.BookVO;
import xyz.durian.read.cleanread.service.book.BookService;
import xyz.durian.read.cleanread.service.seach.BookSearch;

import java.util.List;

@Controller
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;

    private BookSearch bookSearch;

    @Autowired
    public IndexController(BookService bookService, BookSearch bookSearch) {
        this.bookService = bookService;
        this.bookSearch = bookSearch;
    }

    @GetMapping("/")
    @ResponseBody
    public ModelAndView index() {
    	logger.info("test url implements.");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        List<BookVO> bookVOList = bookService.getAllBooks();
        modelAndView.addObject("books", bookVOList);
        return modelAndView;
    }

    @GetMapping("/search/book")
    @ResponseBody
    public List<BookVO> search(@RequestParam("keyword") String nameKeyword) {
        return bookSearch.searchInTitles(nameKeyword);
    }

}
