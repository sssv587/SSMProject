package com.futurebytedance.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.futurebytedance.model.system.SysLoginLog;
import com.futurebytedance.model.vo.SysLoginLogQueryVo;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/6 - 0:15
 * @Description
 */
public interface LoginLogService {
    //登录日志信息
    void recordLoginLog(String username, Integer status, String ip,String message);

    //条件分页查询登录日志
    IPage<SysLoginLog> recordLoginLog(Long page, Long limit, SysLoginLogQueryVo sysLoginLogQueryVo);

    SysLoginLog getById(Long id);
}
