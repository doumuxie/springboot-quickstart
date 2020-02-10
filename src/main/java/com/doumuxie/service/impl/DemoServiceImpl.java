package com.doumuxie.service.impl;

import com.doumuxie.dto.DemoDto;
import com.doumuxie.mapper.DemoMapper;
import com.doumuxie.service.DemoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;


/**
 * @author doumuxie
 * @version 1.0
 * @date 2020/2/7 11:06
 * @description 业务实现层
 **/
@Service
public class DemoServiceImpl implements DemoService {


    private DemoMapper demoMapper;

    @Override
    @GetMapping
    public DemoDto query(DemoDto dto) {
        DemoDto demoDto = new DemoDto();
        demoDto.setId(dto.getId());
        demoDto.setName("demo");
        demoDto.setCreateTime(new Date());
        demoDto.setUpdateTime(new Date());
        return demoDto;
    }

    @Override
    public PageInfo<DemoDto> page(DemoDto dto) {
        PageHelper.startPage(1, 5);
        List<DemoDto> list = demoMapper.list(dto);
        PageInfo<DemoDto> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
