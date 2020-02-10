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

    /**
     * 查询详情
     * @param dto
     * @return
     */
    DemoDto query(DemoDto dto);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageInfo<DemoDto> page(DemoDto dto);

    /**
     * 删除数据
     * @param dto
     */
    void delete(DemoDto dto);

    /**
     * 新增 和 更新数据
     * @param dto
     * @return
     */
    String save(DemoDto dto);

}
