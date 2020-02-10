package com.doumuxie.service;

import com.doumuxie.dto.DemoDto;
import com.github.pagehelper.PageInfo;

/**
 * @author doumuxie
 * @version 1.0
 * @date 2020/2/7 11:06
 * @description 业务接口层
 **/
public interface DemoService {

    DemoDto query(DemoDto dto);

    PageInfo<DemoDto> page(DemoDto dto);
}
