package xyz.durian.read.datalayer.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.durian.read.datalayer.dao.entity.ChapterContentDO;

public interface ChapterContentRepository extends JpaRepository<ChapterContentDO, String> {
}
