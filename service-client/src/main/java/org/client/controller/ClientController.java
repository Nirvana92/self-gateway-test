package org.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gzm
 * @date 2021/2/5 10:51 上午
 * @desc
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, This is client";
    }
}
