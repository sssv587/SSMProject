package com.futurebytedance.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/12 - 0:29
 * @Description 自定义异常
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ByteDanceException extends RuntimeException{
    private Integer code;
    private String msg;
}
