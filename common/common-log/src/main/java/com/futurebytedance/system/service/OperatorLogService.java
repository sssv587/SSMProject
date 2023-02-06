package com.futurebytedance.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.futurebytedance.model.system.SysOperLog;
import com.futurebytedance.model.vo.SysOperLogQueryVo;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/6 - 23:32
 * @Description
 */
public interface OperatorLogService {
    void saveSysLog(SysOperLog sysOperLog);

    //操作日志分页查询
    IPage<SysOperLog> selectPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo);
}
