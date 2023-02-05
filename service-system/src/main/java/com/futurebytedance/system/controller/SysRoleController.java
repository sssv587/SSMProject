package com.futurebytedance.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futurebytedance.common.result.Result;
import com.futurebytedance.model.system.SysRole;
import com.futurebytedance.model.vo.AssginRoleVo;
import com.futurebytedance.model.vo.SysRoleQueryVo;
import com.futurebytedance.system.exception.ByteDanceException;
import com.futurebytedance.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/10 - 23:54
 * @Description 角色模块、用户管理模块
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
        //模拟异常效果
//        try {
//            int i = 9 / 0;
//        } catch (Exception e) {
//            //手动抛出异常
//            throw new ByteDanceException(20001, "执行自定义异常处理");
//        }
        //调用service
        return Result.ok(sysRoleService.list());
    }

    //2.逻辑删除接口
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result<Object> removeRole(@PathVariable Long id) {
        //调用方法删除
        return sysRoleService.removeById(id) ? Result.ok() : Result.fail();
    }

    //3.条件分页查询
    //page:当前页 limit每页记录数
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
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
    @PreAuthorize("hasAuthority('bnt.sysRole.add')")
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result<Object> saveRole(@RequestBody SysRole sysRole) {
        return sysRoleService.save(sysRole) ? Result.ok() : Result.fail();
    }

    //5.修改-根据id查询
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @ApiOperation("根据id查询")
    @PostMapping("findRoleById/{id}")
    public Result<SysRole> findRoleById(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    //6.修改-根据id查询
    @PreAuthorize("hasAuthority('bnt.sysRole.update')")
    @ApiOperation("最终修改")
    @PostMapping("update")
    public Result<SysRole> updateRole(@RequestBody SysRole sysRole) {
        return sysRoleService.updateById(sysRole) ? Result.ok() : Result.fail();
    }

    //7.批量删除
    //多个id值 [1,2,3]
    //json数组格式 --- java的list集合
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result<Object> batchRemove(@RequestBody List<Long> ids) {
        return sysRoleService.removeByIds(ids) ? Result.ok() : Result.fail();
    }

    @ApiOperation("获取用户的角色数据")
    @GetMapping("/toAssign/{userId}")
    public Result<Map<String, Object>> toAssign(@PathVariable String userId) {
        Map<String, Object> roleMap = sysRoleService.getRolesByUserId(userId);
        return Result.ok(roleMap);
    }

    @ApiOperation("用户分配角色")
    @PostMapping("doAssign")
    public Result<Object> doAssign(@RequestBody AssginRoleVo assginRoleVo) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }
}
