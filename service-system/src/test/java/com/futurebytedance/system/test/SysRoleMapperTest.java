package com.futurebytedance.system.test;

import com.futurebytedance.model.system.SysRole;
import com.futurebytedance.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
