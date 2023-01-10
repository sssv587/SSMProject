package com.futurebytedance.system.controller;

import com.futurebytedance.model.system.SysRole;
import com.futurebytedance.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/10 - 23:54
 * @Description
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    //http://localhost:8800/admin/system/sysRole/findAll
    //1.查询所有记录
    @ApiOperation("查询所有记录")
    @GetMapping("findAll")
    public List<SysRole> findAddRole() {
        //调用service
        return sysRoleService.list();
    }

    //2.逻辑删除接口
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public boolean removeRole(@PathVariable Long id) {
        //调用方法删除
        return sysRoleService.removeById(id);
    }
}
