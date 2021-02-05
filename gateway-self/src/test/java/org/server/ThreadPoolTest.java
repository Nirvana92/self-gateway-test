package org.server;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author gzm
 * @date 2021/2/5 3:01 下午
 * @desc
 */
public class ThreadPoolTest {

    @Test
    public void threadPool() throws IOException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);
        threadPool.scheduleWithFixedDelay(()-> {
            // 去服务注册中心刷新服务
            System.out.println("开始拉取服务列表");
        }, 1, 1, TimeUnit.SECONDS);

        System.in.read();
    }
}
