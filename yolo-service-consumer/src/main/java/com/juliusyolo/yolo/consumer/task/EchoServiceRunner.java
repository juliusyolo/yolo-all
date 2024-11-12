package com.juliusyolo.yolo.consumer.task;

import com.juliusyolo.yolo.api.EchoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Julius Wong
 * <p>
 *
 * <p>
 * @since 1.0.0
 */


@Component
public class EchoServiceRunner implements CommandLineRunner {

    @Autowired
    private EchoApi echoApi;

    @Autowired
    private DiscoveryClient discoveryClient;
//    @Autowired
//    ServiceInstanceListSupplier serviceInstanceListSupplier;
    @Override
    public void run(String... args) throws Exception {
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        String hello = echoApi.sayHello();
        System.out.println(
                hello
        );
    }
}
