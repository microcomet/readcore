package xyz.durian.read.datalayer.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.durian.read.datalayer.dao.entity.BookDO;

import java.util.List;

/**
 * 书籍的数据访问层
 */
public interface BookRepository extends JpaRepository<BookDO, String>, CustomBookRepository {

    List<BookDO> findByAuthorContainingOrKeyWordContainingOrNameContainingOrDescriptionContainingOrSubNameContaining(String author, String keyword, String name, String profile, String subName);

}
