package com.futurebytedance.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.futurebytedance.model.system.SysRole;
import com.futurebytedance.model.vo.SysRoleQueryVo;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/10 - 23:18
 * @Description
 */
public interface SysRoleService extends IService<SysRole> {
    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo);
}
