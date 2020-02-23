package xyz.durian.read.datalayer.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.durian.read.datalayer.dao.entity.VolumeDO;

import java.util.List;

public interface VolumeRepository extends JpaRepository<VolumeDO, String> {

    List<VolumeDO> findByNameContainingOrDescriptionContaining(String volumeName, String description);

    List<VolumeDO> findAllByBookId(String bookId);

    void deleteAllByBookId(String bookId);

}
