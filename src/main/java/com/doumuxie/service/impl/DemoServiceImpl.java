package com.doumuxie.service.impl;

import com.doumuxie.dto.DemoDto;
import com.doumuxie.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author doumuxie
 * @version 1.0
 * @date 2020/2/7 11:06
 * @description 业务实现层
 **/
@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public DemoDto query(DemoDto dto) {
        DemoDto demoDto = new DemoDto();
        demoDto.setId(dto.getId());
        demoDto.setName("demo");
        demoDto.setCreateTime(new Date());
        demoDto.setUpdateTime(new Date());
        return demoDto;
    }
}
