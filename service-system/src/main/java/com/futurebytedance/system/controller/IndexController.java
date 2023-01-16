package com.futurebytedance.system.controller;

import com.futurebytedance.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //login
    //{
    //    "code": 20000,
    //    "data": {
    //        "token": "admin-token"
    //    }
    //}
    @PostMapping("/login")
    public Result<Map<String, Object>> login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
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
        map.put("roles","[admin]");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin Byte Dancer");
        return Result.ok(map);
    }
}
