package com.gjq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  //开启zuul的功能
public class ZuulServer_7001 {
	public static void main(String[] args) {
		SpringApplication.run(ZuulServer_7001.class, args);
	}

}
