package com.futurebytedance.system.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.futurebytedance.model.system.SysRole;
import com.futurebytedance.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/10 - 0:12
 * @Description
 */
@SpringBootTest
public class SysRoleMapperTest {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    //7.条件删除
    @Test
    public void testDelete() {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name", "用户管理员");
        sysRoleMapper.delete(wrapper);
    }

    //6.条件查询
    @Test
    public void testSelect() {
        //创建条件构造器对象
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        //设置条件
        //wrapper.eq("role_name", "用户管理员");
        wrapper.like("role_name", "管理员");
        //调用方法查询
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);
    }

    //5.批量删除
    @Test
    public void testBatchDelete() {
        int rows = sysRoleMapper.deleteBatchIds(Arrays.asList(1612484561466298370L, 1612484561466298371L));
        System.out.println(rows);
    }

    //4.id删除
    @Test
    public void deleteId() {
        int rows = sysRoleMapper.deleteById(1612484561466298370L);
        System.out.println(rows);
    }

    //3.修改操作
    @Test
    public void update() {
        //根据id查询
        SysRole sysRole = sysRoleMapper.selectById(1612484561466298370L);

        //设置修改值
        sysRole.setDescription("系统管理员");

        //调用方法实现修改
        sysRoleMapper.updateById(sysRole);
    }

    //2.添加操作
    @Test
    public void add() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("测试角色");
        sysRole.setRoleCode("testManager");
        sysRole.setDescription("测试角色");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println(rows);
    }

    //1.查询表所有记录
    @Test
    public void getAll() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole);
        }
    }
}
