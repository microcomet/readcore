package xyz.durian.read.datalayer.dao.repository;

import java.util.List;

import xyz.durian.read.datalayer.dao.entity.BookDO;

public interface CustomBookRepository {

    List<BookDO> getAllBooks();

}
