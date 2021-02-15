package org.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gzm
 * @date 2021/2/5 11:24 上午
 * @desc
 */
@RestController
public class TestController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String h() {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-server");
        instances.forEach(instance -> {
            System.out.println(instance.getServiceId());
        });

        return "kkk";
    }
}
