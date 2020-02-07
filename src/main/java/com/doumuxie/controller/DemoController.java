package com.doumuxie.controller;


import com.doumuxie.dto.DemoDto;
import com.doumuxie.service.DemoService;
import com.doumuxie.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author doumuxie
 * @version 1.0
 * @date 2020/2/7 11:06
 * @description 控制层
 **/
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/query")
    public ResultUtil demo(DemoDto dto) {
        return ResultUtil.success(demoService.query(dto));
    }


}
