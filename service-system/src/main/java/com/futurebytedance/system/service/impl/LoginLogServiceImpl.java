package com.futurebytedance.system.service.impl;

import com.futurebytedance.model.system.SysLoginLog;
import com.futurebytedance.system.mapper.LoginLogMapper;
import com.futurebytedance.system.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/6 - 0:17
 * @Description
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public void recordLoginLog(String username, Integer status, String ip, String message) {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(username);
        sysLoginLog.setStatus(status);
        sysLoginLog.setIpaddr(ip);
        sysLoginLog.setMsg(message);
        loginLogMapper.insert(sysLoginLog);
    }
}
