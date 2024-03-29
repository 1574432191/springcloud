package com.gjq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient//本服务启动后会自动注册进Eureka中心
@SpringBootApplication
public class MicroserviceProductProvider_8001 {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProductProvider_8001.class, args);
	}
}
