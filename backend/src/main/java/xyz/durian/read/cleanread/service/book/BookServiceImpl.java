package xyz.durian.read.cleanread.service.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.durian.read.cleanread.controller.model.BookVO;
import xyz.durian.read.cleanread.controller.model.ChapterVO;
import xyz.durian.read.cleanread.controller.model.VolumeVO;
import xyz.durian.read.cleanread.model.ObjectConvertFactory;
import xyz.durian.read.datalayer.dao.ChapterDaoImpl;
import xyz.durian.read.datalayer.dao.entity.BookDO;
import xyz.durian.read.datalayer.dao.entity.ChapterDO;
import xyz.durian.read.datalayer.dao.entity.VolumeDO;
import xyz.durian.read.datalayer.dao.repository.BookRepository;
import xyz.durian.read.datalayer.dao.repository.VolumeRepository;

import javax.transaction.Transactional;
import java.util.*;

/**
 * 书籍服务类实现
 * <p>
 * 1. 获取书籍信息
 * 2. 获取书籍目录
 * 3. 获取章节内容
 *
 * @author fanwei 2018-09-28
 * @version 0.1
 * @since 0.1
 */
@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private BookRepository bookRepository;

    private VolumeRepository volumeRepository;

    private ChapterDaoImpl chapterRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           VolumeRepository volumeRepository,
                           ChapterDaoImpl chapterRepository) {
        this.bookRepository = bookRepository;
        this.volumeRepository = volumeRepository;
        this.chapterRepository = chapterRepository;
    }

    @Override
    public ChapterVO getChapterByChapterId(String chapterId) {
        ChapterDO chapterDO = chapterRepository.getChapterByChapterId(chapterId);
        if (Objects.isNull(chapterDO)) {
            logger.error("chapter is not exists.");
            return null;
        }

        ChapterVO chapterVO = ObjectConvertFactory.apply(chapterDO, true);
        Optional<VolumeDO> volumeResult = volumeRepository.findById(chapterDO.getVolumeId());
        volumeResult.ifPresent(volumeDO -> {
            chapterVO.setVolumeName(volumeDO.getName());
            Optional<BookDO> bookResult = bookRepository.findById(volumeDO.getBookId());
            bookResult.ifPresent(bookDO -> {
                chapterVO.setBookName(bookDO.getName());
                chapterVO.setBookId(bookDO.getId());
            });
        });

        return chapterVO;
    }

    @Override
    public List<VolumeVO> getContentsByBookId(String bookId) {
        Optional<BookDO> bookResult = bookRepository.findById(bookId);
        if (!bookResult.isPresent()) {
            return null;
        }

        List<VolumeVO> volumeVOS = new ArrayList<>();

        List<VolumeDO> volumeDOS = volumeRepository.findAllByBookId(bookId);
        if (Objects.nonNull(volumeDOS) && volumeDOS.size() > 0) {
            for (VolumeDO volumeDO : volumeDOS) {
                VolumeVO volumeVO = ObjectConvertFactory.apply(volumeDO);
                List<ChapterDO> chapterDOS = getChaptersByHeadChapterId(volumeDO.getHeadChapterId());
                if (Objects.nonNull(chapterDOS)) {
                    List<ChapterVO> chapterVOS = ObjectConvertFactory.apply(chapterDOS, false);
                    chapterVOS.forEach(chapterVO -> {
                        chapterVO.setBookId(bookResult.get().getId());
                        chapterVO.setBookName(bookResult.get().getName());
                    });
                    volumeVO.setChapters(chapterVOS);
                }
                volumeVOS.add(volumeVO);
            }
        }
        return volumeVOS;
    }

    private List<ChapterDO> getChaptersByHeadChapterId(String headChapterId) {
        Optional<ChapterDO> headChapterResult = chapterRepository.getBookContent(headChapterId);
        if (headChapterResult.isPresent()) {
            List<ChapterDO> chapterDOS = new ArrayList<>();
            chapterDOS.add(headChapterResult.get());
            String nextChapterId = headChapterResult.get().getNextChapterId();
            while (nextChapterId != null) {
                Optional<ChapterDO> nextChapterResult = chapterRepository.getBookContent(nextChapterId);
                if (nextChapterResult.isPresent()) {
                    chapterDOS.add(nextChapterResult.get());
                    nextChapterId = nextChapterResult.get().getNextChapterId();
                } else {
                    break;
                }
            }
            return chapterDOS;
        }
        return null;
    }

    @Override
    public BookVO getBookById(String bookId) {
        if (Objects.isNull(bookId) || bookId.trim().length() == 0) {
            return null;
        }
        Optional<BookDO> bookResult = bookRepository.findById(bookId);
        return bookResult.map(ObjectConvertFactory::apply).orElse(null);
    }

    @Override
    public List<BookVO> getBooksByIds(Iterable<String> bookIds) {
        List<BookVO> bookVOS = new ArrayList<>();
        for (String bookId : bookIds) {
            BookVO bookVO = getBookById(bookId);
            if (Objects.nonNull(bookVO)) {
                bookVOS.add(bookVO);
            }
        }
        return bookVOS.size() > 0 ? bookVOS : null;
    }

    @Override
    public List<BookVO> getAllBooks() {
        List<BookDO> bookDOS = bookRepository.findAll();

        List<BookVO> bookVOS = new ArrayList<>(bookDOS.size());
        bookDOS.forEach(bookDO -> bookVOS.add(ObjectConvertFactory.apply(bookDO)));

        return bookVOS;
    }

    @Override
    @Transactional
    public void deleteBook(String bookId) {
        Optional<BookDO> bookResult = bookRepository.findById(bookId);

        if (bookResult.isPresent()) {
            List<VolumeDO> volumeDOS = volumeRepository.findAllByBookId(bookId);

            volumeDOS.forEach(volumeDO -> chapterRepository.deleteAllByVolumeId(volumeDO.getId()));

            volumeRepository.deleteAllByBookId(bookId);
            bookRepository.deleteById(bookId);
        }
    }
}
