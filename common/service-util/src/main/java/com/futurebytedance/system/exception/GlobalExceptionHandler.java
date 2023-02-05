package com.futurebytedance.system.exception;

import com.futurebytedance.common.result.Result;
import com.futurebytedance.common.result.ResultCodeEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/12 - 0:23
 * @Description 异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //1.全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> error(Exception e) {
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }

    //2.特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result<Object> error(ArithmeticException e) {
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");
    }

    //3.自定义异常处理
    @ExceptionHandler(ByteDanceException.class)
    @ResponseBody
    public Result<Object> error(ByteDanceException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public Result<Object> error(AccessDeniedException e) throws AccessDeniedException {
        return Result.fail().code(ResultCodeEnum.PERMISSION.getCode()).message("没有当功能操作权限!");
    }
}
