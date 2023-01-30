package com.futurebytedance.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.futurebytedance.model.system.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author yuhang.sun
 * @since 2023-01-30
 */
public interface SysMenuService extends IService<SysMenu> {

    //菜单列表(树形)
    List<SysMenu> findNodes();
}
