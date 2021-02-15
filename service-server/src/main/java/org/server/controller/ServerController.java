package org.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gzm
 * @date 2021/2/5 10:40 上午
 * @desc
 */
@RestController
@RequestMapping("/server")
public class ServerController {

    @GetMapping("/hello")
    public String hello() {
        return "service - hell0";
    }
}
