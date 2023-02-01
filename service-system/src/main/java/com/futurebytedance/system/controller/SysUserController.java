package com.futurebytedance.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futurebytedance.common.result.Result;
import com.futurebytedance.common.utils.MD5;
import com.futurebytedance.model.system.SysUser;
import com.futurebytedance.model.vo.SysUserQueryVo;
import com.futurebytedance.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yuhang.sun
 * @since 2023-01-17
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("用户列表")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<SysUser>> list(@PathVariable Long page,
                                       @PathVariable Long limit,
                                       SysUserQueryVo sysUserQueryVo) {
        //创建page对象
        Page<SysUser> pageParam = new Page<>(page, limit);
        //调用service方法
        IPage<SysUser> pageModel = sysUserService.selectPage(pageParam, sysUserQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation("添加用户")
    @PostMapping("save")
    public Result<Object> save(@RequestBody SysUser user) {
        //把输入密码进行加密 MD5
        user.setPassword(MD5.encrypt(user.getPassword()));
        return sysUserService.save(user) ? Result.ok() : Result.fail();
    }

    @ApiOperation("修改用户")
    @PostMapping("update")
    public Result<Object> update(@RequestBody SysUser user) {
        return sysUserService.updateById(user) ? Result.ok() : Result.fail();
    }

    @ApiOperation("根据id查询")
    @GetMapping("getUser/{id}")
    public Result<SysUser> getUser(@PathVariable String id) {
        SysUser user = sysUserService.getById(id);
        return Result.ok(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("remove/{id}")
    public Result<Object> remove(@PathVariable String id) {
        return sysUserService.removeById(id) ? Result.ok() : Result.fail();
    }

    @ApiOperation("更改用户状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result<Object> updateStatus(@PathVariable String id,
                               @PathVariable Integer status) {
        sysUserService.updateStatus(id, status);
        return Result.ok();
    }
}

