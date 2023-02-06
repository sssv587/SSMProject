package com.futurebytedance.system.annotation;

import com.futurebytedance.system.enums.BusinessType;
import com.futurebytedance.system.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/2/6 - 23:15
 * @Description 自定义操作日志记录注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;
}
