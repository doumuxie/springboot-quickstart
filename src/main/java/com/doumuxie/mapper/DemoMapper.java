package com.doumuxie.mapper;

import com.doumuxie.dto.DemoDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMapper {

    @Select("select * from user")
    List<DemoDto> list(DemoDto dto);

}
