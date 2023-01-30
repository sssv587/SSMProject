package com.futurebytedance.system.utils;

import com.futurebytedance.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/30 - 23:52
 * @Description
 */
public class MenuHelper {
    //构建树形结构
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        //创建集合封装最终数据
        List<SysMenu> trees = new ArrayList<>();
        //遍历所有菜单集合
        for (SysMenu sysMenu : sysMenuList) {
            //找到递归入口,parentid=0
            if (sysMenu.getParentId() == 0) {
                trees.add(findChildren(sysMenu, sysMenuList));
            }
        }
        return trees;
    }

    //从根节点进行递归查询,查询子节点
    //判断id=parentid是否相同,如果相同是子节点,进行数据封装
    private static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {
        //数据初始化
        sysMenu.setChildren(new ArrayList<SysMenu>());

        //遍历递归查找
        for (SysMenu it : treeNodes) {
            //获取当前菜单的id
//            Long cid = Long.parseLong(sysMenu.getId());
            //获取所有菜单parentid
//            Long parentId = it.getParentId();
            //比对
            if (Long.parseLong(sysMenu.getId()) == it.getParentId()) {
//                if (sysMenu.getChildren() == null) {
//                    sysMenu.setChildren(new ArrayList<>());
//                }
                sysMenu.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return sysMenu;
    }
}
