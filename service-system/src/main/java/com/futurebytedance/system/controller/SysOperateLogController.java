package com.futurebytedance.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futurebytedance.common.result.Result;
import com.futurebytedance.model.system.SysOperLog;
import com.futurebytedance.model.vo.SysOperLogQueryVo;
import com.futurebytedance.system.service.OperatorLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/7 - 0:03
 * @Description
 */
@Api(value = "SysOperLog管理", tags = "SysOperLog管理")
@RestController
@RequestMapping(value = "/admin/system/sysOperLog")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysOperateLogController {
    @Autowired
    private OperatorLogService operatorLogService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result<IPage<SysOperLog>> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "sysOperLogVo", value = "查询对象", required = false)
                    SysOperLogQueryVo sysOperLogQueryVo) {
        IPage<SysOperLog> pageModel = operatorLogService.selectPage(page, limit, sysOperLogQueryVo);
        return Result.ok(pageModel);
    }
}
