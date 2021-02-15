package org.server;

import org.nirvana.server.autoconfig.EnableSelfGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author gzm
 * @date 2021/2/5 11:23 上午
 * @desc
 */
@SpringBootApplication
@EnableSelfGateway
// @EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
