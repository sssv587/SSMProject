package com.futurebytedance.system.controller;


import com.futurebytedance.common.result.Result;
import com.futurebytedance.model.system.SysMenu;
import com.futurebytedance.model.vo.AssginMenuVo;
import com.futurebytedance.system.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author yuhang.sun
 * @since 2023-01-30
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    //菜单列表(树形)
    @ApiOperation("菜单列表")
    @GetMapping("findNodes")
    public Result<List<SysMenu>> findNodes() {
        List<SysMenu> list = sysMenuService.findNodes();
        return Result.ok(list);
    }

    //添加菜单
    @ApiOperation("添加菜单")
    @PostMapping("save")
    public Result<Object> save(@RequestBody SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return Result.ok();
    }

    //根据id查询
    @ApiOperation("根据id查询菜单")
    @GetMapping("findNode/{id}")
    public Result<SysMenu> findNode(@PathVariable String id) {
        SysMenu sysMenu = sysMenuService.getById(id);
        return Result.ok(sysMenu);
    }

    //修改
    @ApiOperation("修改菜单")
    @PostMapping("update")
    public Result<SysMenu> update(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateById(sysMenu);
        return Result.ok();
    }

    //删除菜单
    @ApiOperation("删除菜单")
    @DeleteMapping("remove/{id}")
    public Result<Object> remove(@PathVariable String id) {
        sysMenuService.removeMenuById(id);
        return Result.ok();
    }

    //根据角色分配菜单
    @ApiOperation("根据角色获取菜单")
    @GetMapping("/toAssign/{roleId}")
    public Result<List<SysMenu>> toAssign(@PathVariable String roleId) {
        List<SysMenu> list = sysMenuService.findMenuByRoleId(roleId);
        return Result.ok(list);
    }

    //给角色分配菜单权限
    @ApiOperation("给角色分配菜单权限")
    @PostMapping("/doAssign")
    public Result<Object> doAssign(@RequestBody AssginMenuVo assignMenuVo) {
        sysMenuService.doAssign(assignMenuVo);
        return Result.ok();
    }
}