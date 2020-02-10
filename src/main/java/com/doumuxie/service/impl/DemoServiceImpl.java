package com.doumuxie.service.impl;

import com.doumuxie.dto.DemoDto;
import com.doumuxie.mapper.DemoMapper;
import com.doumuxie.service.DemoService;
import com.doumuxie.utils.SysCode;
import com.doumuxie.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Autowired
    @SuppressWarnings("all")
    private DemoMapper demoMapper;

    /**
     * 查询详情
     *
     * @param dto
     * @return
     */
    @Override
    public DemoDto query(DemoDto dto) {
        DemoDto demoDto = demoMapper.query(dto);
        return demoDto;
    }

    /**
     * 分页查询
     *
     * @param dto
     * @return
     */
    @Override
    public PageInfo<DemoDto> page(DemoDto dto) {
        PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        List<DemoDto> list = demoMapper.list(dto);
        PageInfo<DemoDto> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 删除数据
     *
     * @param dto
     */
    @Override
    public void delete(DemoDto dto) {
        demoMapper.delete(dto);
    }

    /**
     * 保存和更新数据
     *
     * @param dto
     * @return
     */
    @Override
    public String save(DemoDto dto) {
        // 新增
        DemoDto findDto = new DemoDto();
        BeanUtils.copyProperties(dto, findDto);
        // id智控
        findDto.setId(null);
        DemoDto result = demoMapper.query(findDto);
        if (StringUtils.isBlank(dto.getId())) {
            if (result == null) {
                dto.setId(UUIDUtil.getUUID());
                dto.setUpdateTime(new Date());
                dto.setCreateTime(new Date());
                if (demoMapper.insert(dto) > 0) {
                    // 成功
                    return StringUtils.EMPTY;
                }
                return SysCode.INSERT_ERROR;
            }
            return SysCode.DATA_REPEAT;
        } else {
            // 更新
            if (result != null && !StringUtils.equals(result.getId(), dto.getId())) {
                return SysCode.DATA_REPEAT;
            }
            dto.setUpdateTime(new Date());
            demoMapper.update(dto);
            return StringUtils.EMPTY;
        }
    }
}
