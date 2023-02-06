package com.futurebytedance.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futurebytedance.model.system.SysOperLog;
import com.futurebytedance.model.vo.SysOperLogQueryVo;
import com.futurebytedance.system.mapper.OperatorLogMapper;
import com.futurebytedance.system.service.OperatorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/6 - 23:28
 * @Description
 */
@Service
public class OperatorLogServiceImpl implements OperatorLogService {
    @Autowired
    private OperatorLogMapper operatorLogMapper;

    @Override
    public void saveSysLog(SysOperLog sysOperLog) {
        operatorLogMapper.insert(sysOperLog);
    }

    //操作日志分页查询
    @Override
    public IPage<SysOperLog> selectPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo) {
        Page<SysOperLog> pageParam = new Page<>(page, limit);
        //获取条件值
        String title = sysOperLogQueryVo.getTitle();
        String operName = sysOperLogQueryVo.getOperName();
        String createTimeBegin = sysOperLogQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysOperLogQueryVo.getCreateTimeEnd();
        //封装参数
        QueryWrapper<SysOperLog> wrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(operName)) {
            wrapper.like("oper_name", operName);
        }
        if (!StringUtils.isEmpty(createTimeBegin)) {
            wrapper.ge("create_time", createTimeBegin);
        }
        if (!StringUtils.isEmpty(createTimeEnd)) {
            wrapper.le("create_time", createTimeEnd);
        }
        //调用mapper方法实现分页条件查询
        return operatorLogMapper.selectPage(pageParam, wrapper);
    }
}
