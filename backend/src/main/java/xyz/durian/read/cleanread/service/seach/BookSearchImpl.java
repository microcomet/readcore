package xyz.durian.read.cleanread.service.seach;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.durian.read.cleanread.controller.model.BookVO;
import xyz.durian.read.cleanread.service.book.BookService;
import xyz.durian.read.datalayer.dao.entity.BookDO;
import xyz.durian.read.datalayer.dao.entity.VolumeDO;
import xyz.durian.read.datalayer.dao.repository.BookRepository;
import xyz.durian.read.datalayer.dao.repository.ChapterRepository;
import xyz.durian.read.datalayer.dao.repository.VolumeRepository;

import java.util.*;

@Service
public class BookSearchImpl implements BookSearch {
    private static final Logger logger = LoggerFactory.getLogger(BookSearchImpl.class);

    private BookRepository bookRepository;

    private VolumeRepository volumeRepository;

    private BookService bookService;

    @Autowired
    public BookSearchImpl(BookRepository bookRepository,
                           VolumeRepository volumeRepository,
                           ChapterRepository chapterRepository,
                          BookService bookService) {
    	logger.info("book service impl init.");
        this.bookRepository = bookRepository;
        this.volumeRepository = volumeRepository;
        this.bookService = bookService;
    }

    @Override
    public List<BookVO> searchInTitles(String nameKeyword) {
        if (Objects.isNull(nameKeyword) || nameKeyword.trim().length() == 0) {
            return null;
        }
        nameKeyword = nameKeyword.trim();
        List<BookDO> bookDOS = bookRepository.findByAuthorContainingOrKeyWordContainingOrNameContainingOrDescriptionContainingOrSubNameContaining(
                nameKeyword, nameKeyword, nameKeyword, nameKeyword, nameKeyword);
        List<VolumeDO> volumeDOS = volumeRepository.findByNameContainingOrDescriptionContaining(nameKeyword, nameKeyword);
//        List<ChapterDO> chapterDOS = chapterRepository.findByChapterTitleContainingOrChapterSubTitleContaining(nameKeyword, nameKeyword);
        Set<String> bookIds = new HashSet<>();

        for (BookDO bookDO : bookDOS) {
            bookIds.add(bookDO.getId());
        }
        for (VolumeDO volumeDO : volumeDOS) {
            bookIds.add(volumeDO.getBookId());
        }
//        for (ChapterDO chapterDO : chapterDOS) {
//            String volumeId = chapterDO.getVolumeId();
//            Optional<VolumeDO> volumeDO = volumeRepository.findById(volumeId);
//            volumeDO.ifPresent(aDo -> bookIds.add(aDo.getBookId()));
//        }
        return bookService.getBooksByIds(bookIds);
    }

    @Override
    public List<BookVO> searchInContent(String contentKeyword) {
        return null;
    }
}
