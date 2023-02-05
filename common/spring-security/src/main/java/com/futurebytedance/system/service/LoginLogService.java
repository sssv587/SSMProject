package com.futurebytedance.system.service;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/6 - 0:15
 * @Description
 */
public interface LoginLogService {
    //登录日志信息
    void recordLoginLog(String username, Integer status, String ip,String message);
}
