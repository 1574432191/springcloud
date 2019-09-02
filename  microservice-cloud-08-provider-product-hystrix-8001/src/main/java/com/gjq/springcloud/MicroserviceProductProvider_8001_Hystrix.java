package com.gjq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix //开启Hystrix熔断机制的支持
@EnableEurekaClient//本服务启动后会自动注册进Eureka中心
@SpringBootApplication
public class MicroserviceProductProvider_8001_Hystrix {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProductProvider_8001_Hystrix.class, args);
	}
}
