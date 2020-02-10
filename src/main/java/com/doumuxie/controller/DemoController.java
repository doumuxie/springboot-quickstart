package com.doumuxie.controller;


import com.doumuxie.dto.DemoDto;
import com.doumuxie.service.DemoService;
import com.doumuxie.utils.ResultUtil;
import com.doumuxie.utils.SysCode;
import org.apache.commons.lang3.StringUtils;
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

    /**
     * 查询详情
     * @param dto id 主键id
     * @return
     */
    @RequestMapping("/query")
    public ResultUtil query(DemoDto dto) {
        if (dto == null || StringUtils.isAnyBlank(dto.getId())) {
            return ResultUtil.error(SysCode.PARAM_ERROR);
        }
        return ResultUtil.success(demoService.query(dto));
    }


    /**
     * 分页查询
     * @param dto
     * pageNo 分页页数
     * pageSize 分页大小
     * context 模糊查询条件
     * @return
     */
    @RequestMapping("/page")
    public ResultUtil page(DemoDto dto) {
        if (dto == null) {
            return ResultUtil.error(SysCode.PARAM_ERROR);
        }
        return ResultUtil.success(demoService.page(dto));
    }


    /**
     * 删除数据
     * @param dto id 主键id
     * @return
     */
    @RequestMapping("/delete")
    public ResultUtil delete(DemoDto dto) {
        if (dto == null || StringUtils.isAnyBlank(dto.getId())) {
            return ResultUtil.error(SysCode.PARAM_ERROR);
        }
        demoService.delete(dto);
        return ResultUtil.success();
    }

    /**
     * 插入 和 更新 数据
     * @param dto
     * @return
     */
    @RequestMapping("/save")
    public ResultUtil save(DemoDto dto) {
        if (dto == null) {
            return ResultUtil.error(SysCode.PARAM_ERROR);
        }
        String result = demoService.save(dto);
        if (StringUtils.isBlank(result)){
            return ResultUtil.success();
        }
        return ResultUtil.error(result);
    }

}
