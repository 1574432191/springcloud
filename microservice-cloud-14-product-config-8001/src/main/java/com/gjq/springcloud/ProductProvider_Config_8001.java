package com.gjq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient  //将此服务注册大Eureka服务注册中心
@SpringBootApplication
public class ProductProvider_Config_8001 {
	public static void main(String[] args) {
		SpringApplication.run(ProductProvider_Config_8001.class, args);
	}
}
