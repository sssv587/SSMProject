package com.futurebytedance.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.futurebytedance.model.system.SysRole;
import com.futurebytedance.model.vo.SysRoleQueryVo;
import com.futurebytedance.system.mapper.SysRoleMapper;
import com.futurebytedance.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/10 - 23:18
 * @Description
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(pageParam, sysRoleQueryVo);
    }
}