package xyz.durian.read.datalayer.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.durian.read.datalayer.dao.entity.ChapterDO;

import java.util.List;

public interface ChapterRepository extends JpaRepository<ChapterDO, String> {

    List<ChapterDO> findAllByVolumeId(String volumeId);

    List<ChapterDO> findByNameContainingOrSubNameContaining(String title, String subTitle);

    void deleteAllByVolumeId(String volumeId);

}
