package com.doumuxie.mapper;

import com.doumuxie.dto.DemoDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMapper {

    @Select("select id,name,create_time,update_time from user")
    List<DemoDto> list(DemoDto dto);

    @Select("<script>" +
            "select id,name,create_time,update_time " +
            "from " +
            "user " +
            "where 1=1 " +
            "<if test='id != null'>" +
            " and id = #{id}" +
            "</if>" +
            "<if test='name != null'>" +
            " and name = #{name}" +
            "</if>" +
            " limit 1" +
            "</script>")
    DemoDto query(DemoDto dto);

    @Delete("delete from user where id = #{id}")
    void delete(DemoDto dto);

    @Insert("insert into user " +
            "(id, name, create_time, update_time) " +
            "values " +
            "(#{id}, #{name}, #{createTime}, #{updateTime})")
    int insert(DemoDto dto);

    @Insert("update user set " +
            "name = #{name}," +
            "update_time = #{updateTime}" +
            "where id = #{id}")
    int update(DemoDto dto);
}
