package xyz.durian.read.datalayer.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import xyz.durian.read.datalayer.dao.entity.BookDO;

import java.util.List;

@Mapper
public interface BookMapper {

	@Select("select * from book")
    List<BookDO> getAllBooks();

}
