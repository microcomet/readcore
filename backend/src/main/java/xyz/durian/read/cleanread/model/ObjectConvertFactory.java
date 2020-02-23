package xyz.durian.read.cleanread.model;

import xyz.durian.read.cleanread.controller.model.BookVO;
import xyz.durian.read.cleanread.controller.model.ChapterVO;
import xyz.durian.read.cleanread.controller.model.VolumeVO;
import xyz.durian.read.datalayer.dao.entity.BookDO;
import xyz.durian.read.datalayer.dao.entity.ChapterDO;
import xyz.durian.read.datalayer.dao.entity.VolumeDO;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * 对象的映射
 */
public class ObjectConvertFactory {

    private static final Function<byte[], List<String>> convertChapterContent = content -> {
        if (Objects.isNull(content) || content.length == 0) {
            return null;
        }
        String contentUtf = new String(content, Charset.forName("UTF-8"));

        String[] paragraphArray = contentUtf.split("[\\r\\n]");

        return Arrays.asList(paragraphArray);
    };

    private static final BiFunction<ChapterDO, Boolean, ChapterVO> convertChapterDO2VO = (chapterDO, withChapterContent) -> {
        ChapterVO chapterVO = new ChapterVO();
        chapterVO.setChapterId(chapterDO.getId());
        chapterVO.setChapterName(chapterDO.getName());
        chapterVO.setVolumeId(chapterDO.getVolumeId());
        if (withChapterContent && Objects.nonNull(chapterDO.getContent())) {
        	chapterVO.setParagraphList(convertChapterContent.apply(chapterDO.getContent()));
        }
        chapterVO.setPreviousChapterId(chapterDO.getPreChapterId());
        chapterVO.setNextChapterId(chapterDO.getNextChapterId());
        return chapterVO;
    };

    private static final Function<ChapterVO, ChapterDO> convertChapterVO2DO = chapterVO -> {
        ChapterDO chapterDO = new ChapterDO();
        if (Objects.nonNull(chapterVO.getChapterId())) {
            chapterDO.setId(chapterVO.getChapterId());
        } else {
            chapterDO.setId(UUID.randomUUID().toString());
        }
        
        chapterDO.setName(chapterVO.getChapterName());
        chapterDO.setVolumeId(chapterVO.getVolumeId());
        chapterDO.setPreChapterId(chapterVO.getPreviousChapterId());
        chapterDO.setNextChapterId(chapterVO.getNextChapterId());
        chapterDO.setCreateTime(LocalDateTime.now());

        String content = String.join("", chapterVO.getParagraphList());
        chapterDO.setContent(content.getBytes(Charset.forName("UTF-8")));

        return chapterDO;
    };

    private static final Function<VolumeDO, VolumeVO> convertVolumeDO2VO = volumeDO -> {
        VolumeVO volumeVO = new VolumeVO();
        volumeVO.setBookId(volumeDO.getBookId());
        volumeVO.setVolumeId(volumeDO.getId());
        volumeVO.setVolumeName(volumeDO.getName());

        return volumeVO;
    };

    private static final Function<VolumeVO, VolumeDO> convertVolumeVO2DO = volumeVO -> {
        VolumeDO volumeDO = new VolumeDO();
        volumeDO.setBookId(volumeVO.getBookId());
        volumeDO.setName(volumeVO.getVolumeName());
        if (Objects.nonNull(volumeVO.getVolumeId())) {
            volumeDO.setId(volumeVO.getVolumeId());
        } else {
            volumeDO.setId(UUID.randomUUID().toString());
        }
        volumeDO.setChapterCount(0);
        volumeDO.setCreateTime(LocalDateTime.now());

        return volumeDO;
    };

    private static final Function<BookDO, BookVO> convertBookDO2VO = bookDO -> {
        BookVO bookVO = new BookVO();
        bookVO.setAuthor(bookDO.getAuthor());
        bookVO.setAuthorName(bookDO.getAuthor());
        bookVO.setBookDescription(bookDO.getDescription());
        bookVO.setBookId(bookDO.getId());
        bookVO.setBookKeyWord(bookDO.getKeyWord());
        bookVO.setBookName(bookDO.getName());
        bookVO.setCategoryId(bookDO.getCategoryId());
        bookVO.setCreateTime(bookDO.getCreateTime().toString());
        bookVO.setUpdateTime(
                Objects.isNull(bookDO.getUpdateTime()) ? null : bookDO.getUpdateTime().toString());
        return bookVO;
    };

    private static final Function<BookVO, BookDO> convertBookVO2DO = bookVO -> {
        BookDO bookDO = new BookDO();
        bookDO.setAuthor(bookVO.getAuthor());

        if (Objects.nonNull(bookVO.getBookId())) {
            bookDO.setId(bookVO.getBookId());
        } else {
            bookDO.setId(UUID.randomUUID().toString());
        }

        bookDO.setCategoryId(bookVO.getCategoryId());
        bookDO.setName(bookVO.getBookName());
        bookDO.setDescription(bookVO.getBookDescription());
        bookDO.setKeyWord(bookVO.getBookKeyWord());
        bookDO.setCreateTime(LocalDateTime.now());
        bookDO.setVolumeCount(0);

        return bookDO;
    };

    public static ChapterVO apply(ChapterDO chapterDO, Boolean withChapterContent) {
        return convertChapterDO2VO.apply(chapterDO, withChapterContent);
    }

    public static ChapterDO apply(ChapterVO chapterVO) {
        return convertChapterVO2DO.apply(chapterVO);
    }

    public static List<ChapterVO> apply(List<ChapterDO> chapterDOS, Boolean withChapterContent) {
        List<ChapterVO> chapterVOS = new ArrayList<>(chapterDOS.size());

        chapterDOS.forEach(chapterDO -> chapterVOS.add(convertChapterDO2VO.apply(chapterDO, withChapterContent)));

        return chapterVOS;
    }

    public static VolumeVO apply(VolumeDO volumeDO) {
        return convertVolumeDO2VO.apply(volumeDO);
    }

    public static VolumeDO apply(VolumeVO volumeVO) {
        return convertVolumeVO2DO.apply(volumeVO);
    }

    public static BookVO apply(BookDO bookDO) {
        return convertBookDO2VO.apply(bookDO);
    }

    public static BookDO apply(BookVO bookVO) {
        return convertBookVO2DO.apply(bookVO);
    }

//    private static List<String> splitChapterContent(String content) {
//
//        String endMark = "。";
//        List<String> paragraphList = new ArrayList<>();
//
//        int start = 0, end;
//
//        int index = content.indexOf(endMark);
//
//        while (index > 0) {
//            end = index + 1;
//            if (end - start > 150) {
//                paragraphList.add(content.substring(start, end));
//                start = end;
//            }
//            index = content.indexOf(endMark, index + 1);
//        }
//        if (start < content.length()) {
//            paragraphList.add(content.substring(start));
//        }
//
//        return paragraphList;
//    }

}
