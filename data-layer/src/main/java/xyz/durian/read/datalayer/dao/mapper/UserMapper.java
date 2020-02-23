package xyz.durian.read.datalayer.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import xyz.durian.read.datalayer.dao.entity.UserDO;

@Mapper
public interface UserMapper {

	@Select("select * from user where user_id = #{userId}")
    UserDO getUserById(String userId);

}
