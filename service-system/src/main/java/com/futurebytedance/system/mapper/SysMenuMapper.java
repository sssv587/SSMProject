package com.futurebytedance.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.futurebytedance.model.system.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author yuhang.sun
 * @since 2023-01-30
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    //根据userid查询菜单权限数据
    List<SysMenu> findMenuListUserId(@Param("userId") String userId);
}
