package com.lee.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProviderDemoApplication.class, args);
    }
}
