package com.juliusyolo.yolo.echo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Julius Wong
 * <p>
 * echo 服务启动类
 * <p>
 * @since 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan
public class YoloEchoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(YoloEchoServiceApplication.class, args);
    }
}
