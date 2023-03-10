package com.futurebytedance.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.futurebytedance.model.system.SysRole;
import com.futurebytedance.model.system.SysUserRole;
import com.futurebytedance.model.vo.AssginRoleVo;
import com.futurebytedance.model.vo.SysRoleQueryVo;
import com.futurebytedance.system.mapper.SysRoleMapper;
import com.futurebytedance.system.mapper.SysUserRoleMapper;
import com.futurebytedance.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/10 - 23:18
 * @Description
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(pageParam, sysRoleQueryVo);
    }

    //获取用户的角色数据
    @Override
    public Map<String, Object> getRolesByUserId(String userId) {
        //获取所有角色
        List<SysRole> roles = baseMapper.selectList(null);
        //根据用户id查询,已经分配角色
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        List<SysUserRole> userRolesList = sysUserRoleMapper.selectList(wrapper);
        //从userRoles集合获取所有角色id
        List<String> userRoleIds = new ArrayList<>();
        for (SysUserRole userRole : userRolesList) {
            String roleId = userRole.getRoleId();
            userRoleIds.add(roleId);
        }
        //封装到map集合
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("allRoles", roles);//所有的角色
        returnMap.put("userRoleIds", userRoleIds);//用户分配角色id集合
        return returnMap;
    }

    //用户分配角色
    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        //根据用户id删除之前分配角色
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", assginRoleVo.getUserId());
        sysUserRoleMapper.delete(wrapper);

        //获取所有角色id,添加角色用户关系表
        //角色id列表
        List<String> roleIdList = assginRoleVo.getRoleIdList();
        for (String roleId : roleIdList) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assginRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleMapper.insert(sysUserRole);
        }
    }
}
