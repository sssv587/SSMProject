package com.futurebytedance.system.controller;

import com.futurebytedance.common.result.Result;
import com.futurebytedance.common.utils.JwtHelper;
import com.futurebytedance.common.utils.MD5;
import com.futurebytedance.model.system.SysUser;
import com.futurebytedance.model.vo.LoginVo;
import com.futurebytedance.system.exception.ByteDanceException;
import com.futurebytedance.system.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/16 - 22:32
 * @Description
 */
@Api(tags = "用户登录接口")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    @Autowired
    private SysUserService sysUserService;

    //login
    //{
    //    "code": 20000,
    //    "data": {
    //        "token": "admin-token"
    //    }
    //}
    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody LoginVo loginVo) {
        //根据username查询数据
        SysUser sysUser = sysUserService.getUserInfoByUserName(loginVo.getUsername());

        //如果查询数据为空
        if (sysUser == null) {
            throw new ByteDanceException(20001, "用户不存在!");
        }

        //判断密码是否一致
        if (!sysUser.getPassword().equals(MD5.encrypt(loginVo.getPassword()))) {
            throw new ByteDanceException(20001, "密码不正确!");
        }

        //判断用户是否可用
        if (sysUser.getStatus().intValue() == 0) {
            throw new ByteDanceException(20001, "用户已经被禁用!");
        }

        //根据userid和username生成token字符串，通过map返回
        String token = JwtHelper.createToken(sysUser.getId(), sysUser.getUsername());

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return Result.ok(map);
    }

    //info
    //{
    //    "code": 20000,
    //    "data": {
    //        "roles": [
    //            "admin"
    //        ],
    //        "introduction": "I am a super administrator",
    //        "avatar": "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
    //        "name": "Super Admin"
    //    }
    //}
    @GetMapping("info")
    public Result<Map<String, Object>> info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin Byte Dancer");
        return Result.ok(map);
    }
}
