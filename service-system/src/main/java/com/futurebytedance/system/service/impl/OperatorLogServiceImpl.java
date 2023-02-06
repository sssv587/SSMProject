package com.futurebytedance.system.service.impl;

import com.futurebytedance.model.system.SysOperLog;
import com.futurebytedance.system.mapper.OperatorLogMapper;
import com.futurebytedance.system.service.OperatorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
