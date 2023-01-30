package com.futurebytedance.system.service.impl;

import com.futurebytedance.model.system.SysMenu;
import com.futurebytedance.system.mapper.SysMenuMapper;
import com.futurebytedance.system.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
        return null;
    }
}
