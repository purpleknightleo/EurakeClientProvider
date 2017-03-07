package com.lee.demo.eureka.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 简易计算控制器
 *
 * Created by hzlifan on 2017/3/6.
 */
@RestController
public class ComputeController {

    private static final Logger logger = LoggerFactory.getLogger(ComputeController.class);

    @Autowired
    private DiscoveryClient     client;

    /**
     * GET请求
     *
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        Integer c = a + b;
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId()
                    + ", result:" + c);
        return c;
    }

    /**
     * POST请求
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "/sub", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer sub(@RequestBody String body) {
        JSONObject json = JSON.parseObject(body);
        Integer a = json.getInteger("a");
        Integer b = json.getInteger("b");
        Integer c = a - b;
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/sub, host:" + instance.getHost() + ", service_id:" + instance.getServiceId()
                    + ", result:" + c);
        return c;
    }

}
