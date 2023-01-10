package com.futurebytedance.system.controller;

import com.futurebytedance.model.system.SysRole;
import com.futurebytedance.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/10 - 23:54
 * @Description
 */
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    //http://localhost:8800/admin/system/sysRole/findAll
    //1.查询所有记录
    @GetMapping("findAll")
    public List<SysRole> findAddRole() {
        //调用service
        return sysRoleService.list();
    }
}
