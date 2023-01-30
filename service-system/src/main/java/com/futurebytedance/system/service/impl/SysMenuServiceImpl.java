package com.futurebytedance.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.futurebytedance.model.system.SysMenu;
import com.futurebytedance.system.exception.ByteDanceException;
import com.futurebytedance.system.mapper.SysMenuMapper;
import com.futurebytedance.system.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.futurebytedance.system.utils.MenuHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author yuhang.sun
 * @since 2023-01-30
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenu> findNodes() {
        //获取所有菜单
        List<SysMenu> sysMenuList = baseMapper.selectList(null);

        //所有菜单数据转换要求数据格式
        return MenuHelper.buildTree(sysMenuList);
    }

    //删除菜单
    @Override
    public void removeMenuById(String id) {
        //查询当前删除菜单下面是否有子菜单
        //根据id和parentid对应关系
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        Integer count = baseMapper.selectCount(wrapper);
        if (count > 0) { //有子菜单
            throw new ByteDanceException(201, "请先删除子菜单");
        }
        //调用删除
        baseMapper.deleteById(id);
    }
}
