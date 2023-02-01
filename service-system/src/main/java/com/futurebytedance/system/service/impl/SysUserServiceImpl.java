package com.futurebytedance.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futurebytedance.model.system.SysUser;
import com.futurebytedance.model.vo.RouterVo;
import com.futurebytedance.model.vo.SysUserQueryVo;
import com.futurebytedance.system.mapper.SysUserMapper;
import com.futurebytedance.system.service.SysMenuService;
import com.futurebytedance.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yuhang.sun
 * @since 2023-01-17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public IPage<SysUser> selectPage(Page<SysUser> pageParam, SysUserQueryVo sysUserQueryVo) {
        return baseMapper.selectPage(pageParam, sysUserQueryVo);
    }

    //更改用户状态
    @Override
    public void updateStatus(String id, Integer status) {
        //根据用户id查询
        SysUser sysUser = baseMapper.selectById(id);

        //设置修改状态
        sysUser.setStatus(status);

        //调用方法修改
        baseMapper.updateById(sysUser);
    }

    //根据用户名称查询
    @Override
    public SysUser getUserInfoByUserName(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return baseMapper.selectOne(wrapper);
    }

    //根据用户名称获取用户信息(基本信息 和 菜单权限 和 按钮权限数据)
    @Override
    public Map<String, Object> getUserInfo(String username) {
        //根据username查询用户基本信息
        SysUser sysUser = this.getUserInfoByUserName(username);
        //根据userid查询菜单权限值
        List<RouterVo> routerVoList = sysMenuService.getUserMenuList(sysUser.getId());
        //根据userid查询按钮权限值
        List<String> permsList = sysMenuService.getUserButtonList(sysUser.getId());

        Map<String, Object> result = new HashMap<>();
        result.put("name", username);
        result.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        result.put("roles", "[\"admin\"]");
        //菜单权限数据
        result.put("routers", routerVoList);
        //按钮权限数据
        result.put("buttons", permsList);
        return result;
    }
}
