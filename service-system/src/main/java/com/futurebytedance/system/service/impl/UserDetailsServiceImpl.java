package com.futurebytedance.system.service.impl;

import com.futurebytedance.model.system.SysUser;
import com.futurebytedance.system.custom.CustomUser;
import com.futurebytedance.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/5 - 21:35
 * @Description
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getUserInfoByUserName(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在!");
        }
        if (sysUser.getStatus().intValue() == 0) {
            throw new RuntimeException("用户已经被禁用了!");
        }
        return new CustomUser(sysUser, Collections.emptyList());
    }
}
