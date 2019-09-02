package com.gjq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient//向服务注册中心进行注册
@SpringBootApplication
@EnableFeignClients(basePackages={"com.gjq.springcloud"})
public class ProductConsumer_80_Feign {
	public static void main(String[] args) {
		SpringApplication.run(ProductConsumer_80_Feign.class, args);
	}
}
