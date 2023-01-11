package com.futurebytedance.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futurebytedance.common.result.Result;
import com.futurebytedance.model.system.SysRole;
import com.futurebytedance.model.vo.SysRoleQueryVo;
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
    public Result<List<SysRole>> findAddRole() {
        //调用service
        return Result.ok(sysRoleService.list());
    }

    //2.逻辑删除接口
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result<Object> removeRole(@PathVariable Long id) {
        //调用方法删除
        return sysRoleService.removeById(id) ? Result.ok() : Result.fail();
    }

    //3.条件分页查询
    //page:当前页 limit每页记录数
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result<IPage<SysRole>> findPageQueryRole(@PathVariable Long page,
                                                    @PathVariable Long limit,
                                                    SysRoleQueryVo sysRoleQueryVo) {
        //创建page对象
        Page<SysRole> pageParam = new Page<>(page, limit);
        //调用service方法
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, sysRoleQueryVo);
        //返回
        return Result.ok(pageModel);
    }

    //4.添加
    //@RequestBody 不能使用get提交方式
    //传递json格式数据,把json格式数据封装到对象里面{...}
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result<Object> saveRole(@RequestBody SysRole sysRole) {
        return sysRoleService.save(sysRole) ? Result.ok() : Result.fail();
    }
}
