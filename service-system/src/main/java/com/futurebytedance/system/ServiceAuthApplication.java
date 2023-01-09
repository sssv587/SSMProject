package com.futurebytedance.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2023/1/10 - 0:03
 * @Description 启动类
 */
@SpringBootApplication
@MapperScan("com.futurebytedance.system.mapper")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class);
    }
}
