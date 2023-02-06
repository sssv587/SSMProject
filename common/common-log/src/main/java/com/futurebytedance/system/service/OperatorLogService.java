package com.futurebytedance.system.service;

import com.futurebytedance.model.system.SysOperLog;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/6 - 23:32
 * @Description
 */
public interface OperatorLogService {
    void saveSysLog(SysOperLog sysOperLog);
}
