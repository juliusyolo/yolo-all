package com.juliusyolo.yolo.echo.controller;

import com.juliusyolo.yolo.api.EchoApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julius Wong
 * <p>
 * echo 控制层
 * <p>
 * @since 1.0.0
 */
@RestController
public class EchoController implements EchoApi {


    @Override
    @GetMapping("/hello/say")
    public String sayHello() {
        System.out.println("Hello World");
        return "hello,julius";
    }

}
