package com.juliusyolo.yolo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Julius Wong
 * <p>
 * echo api feign接口
 * <p>
 * @since 1.0.0
 */

@FeignClient("yolo-echo-service")
public interface EchoApi {

    /**
     * say hello api
     * @return 返回hello
     */
     @GetMapping("/hello/say")
     String sayHello();
}
