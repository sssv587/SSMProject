package com.futurebytedance.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.futurebytedance.model.system.SysOperLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/6 - 23:30
 * @Description
 */
@Repository
@Mapper
public interface OperatorLogMapper extends BaseMapper<SysOperLog> {
}
