package org.server.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gzm
 * @date 2021/2/5 11:24 上午
 * @desc
 */
@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    @NacosInjected
    private NamingService namingService;

    /**
     * 测试服务注册中心的服务拉取代码
     * @return
     * @throws NacosException
     */
    @GetMapping("/hello")
    public String hello() throws NacosException {
        logger.info("===>>> namingService: {}", namingService);
        List<Instance> allInstances = namingService.getAllInstances("service-server");
        allInstances.forEach(instance -> {
            logger.info(" instance.info: {}, {}, {}", instance.getServiceName(), instance.getIp(), instance.getPort());
        });

        return "Hello, This is server";
    }
}
