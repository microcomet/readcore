package xyz.durian.read.cleanread.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.durian.read.cleanread.service.book.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceTests.class);

    @Autowired
    private BookService bookService;
    
    @Test
    public void loadContext() {}

//    @Test
    public void deleteBook() {
        bookService.deleteBook("d30b9bda-c1a3-4033-90a7-1c19f564f25a");
        logger.info("test");
    }
}
