package xyz.durian.read.datalayer.dao;

import org.springframework.stereotype.Repository;
import xyz.durian.read.datalayer.dao.entity.ChapterContentDO;
import xyz.durian.read.datalayer.dao.entity.ChapterDO;
import xyz.durian.read.datalayer.dao.repository.ChapterContentRepository;
import xyz.durian.read.datalayer.dao.repository.ChapterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ChapterDaoImpl {

    private ChapterRepository chapterRepository;

    private ChapterContentRepository chapterContentRepository;

    public ChapterDaoImpl(ChapterRepository chapterRepository, ChapterContentRepository chapterContentRepository) {
        this.chapterRepository = chapterRepository;
        this.chapterContentRepository = chapterContentRepository;
    }

    public ChapterDO getChapterByChapterId(String chapterId) {
        Optional<ChapterDO> chapterDOOptional = chapterRepository.findById(chapterId);
        if (chapterDOOptional.isPresent()) {
            ChapterDO chapterDO = chapterDOOptional.get();
            Optional<ChapterContentDO> chapterContentDOOptional = chapterContentRepository.findById(chapterId);
            if (chapterContentDOOptional.isPresent()) {
                chapterDO.setContent(chapterContentDOOptional.get().getContent());
                return chapterDO;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Optional<ChapterDO> getBookContent(String chapterId) {
        return chapterRepository.findById(chapterId);
    }

    public void saveAll(List<ChapterDO> chapterDOS) {
        if (Objects.nonNull(chapterDOS) && chapterDOS.size() > 0) {
            List<ChapterContentDO> chapterContentDOS = new ArrayList<>(chapterDOS.size());
            chapterDOS.forEach(chapterDO -> {
                ChapterContentDO chapterContentDO = new ChapterContentDO();
                chapterContentDO.setId(chapterDO.getId());
                chapterContentDO.setContent(chapterDO.getContent());
                chapterContentDOS.add(chapterContentDO);
            });

            chapterContentRepository.saveAll(chapterContentDOS);
            chapterRepository.saveAll(chapterDOS);
        }
    }

    public void deleteAllByVolumeId(String volumeId) {
        List<ChapterDO> chapterDOList = chapterRepository.findAllByVolumeId(volumeId);

        chapterDOList.forEach(chapterDO -> chapterContentRepository.deleteById(chapterDO.getId()));

        chapterRepository.deleteAllByVolumeId(volumeId);
    }

}
