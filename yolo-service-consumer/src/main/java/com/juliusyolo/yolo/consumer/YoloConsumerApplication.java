package com.juliusyolo.yolo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Julius Wong
 * <p>
 * 消费服务
 * <p>
 * @since 1.0.0
 */
@SpringBootApplication
@EnableFeignClients("com.juliusyolo.yolo.api")
@EnableDiscoveryClient
@LoadBalancerClient("yolo-echo-service")
public class YoloConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(YoloConsumerApplication.class, args);
    }
}
