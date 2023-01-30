package com.futurebytedance.system.service.impl;

import com.futurebytedance.model.system.SysMenu;
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
}
