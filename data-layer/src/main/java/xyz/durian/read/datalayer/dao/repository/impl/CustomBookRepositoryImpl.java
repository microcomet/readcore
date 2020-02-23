package xyz.durian.read.datalayer.dao.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xyz.durian.read.datalayer.dao.entity.BookDO;
import xyz.durian.read.datalayer.dao.mapper.BookMapper;
import xyz.durian.read.datalayer.dao.repository.CustomBookRepository;

import java.util.List;

@Component
public class CustomBookRepositoryImpl implements CustomBookRepository {

    private BookMapper bookMapper;

    @Autowired
    public CustomBookRepositoryImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

	public List<BookDO> getAllBooks() {
		return bookMapper.getAllBooks();
	}

}
