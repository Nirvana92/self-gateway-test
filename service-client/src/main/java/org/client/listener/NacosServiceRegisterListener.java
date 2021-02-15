package org.client.listener;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.client.utils.IPUtil;
import org.nirvana.util.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author gzm
 * @date 2021/2/7 2:49 下午
 * @desc: 将服务注册到服务注册中心
 */
@Component
public class NacosServiceRegisterListener implements ApplicationListener<ContextRefreshedEvent> {
    Logger logger = LoggerFactory.getLogger(NacosServiceRegisterListener.class);

    @NacosInjected
    private NamingService namingService;
    @Autowired
    private Environment environment;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info(" context 启动完成事件。服务注册");
        String serviceName = environment.getProperty("spring.application.name");
        String ip = IpUtils.getLocalIpAddress();
        String servicePort = environment.getProperty("server.port");

        try {
            namingService.registerInstance(serviceName, ip, Integer.parseInt(servicePort));
        } catch (NacosException e) {
            e.printStackTrace();
        }

        logger.info(" 注册服务: serviceName: {}, ip: {}, servicePort: {}", serviceName, ip, servicePort);
    }
}
