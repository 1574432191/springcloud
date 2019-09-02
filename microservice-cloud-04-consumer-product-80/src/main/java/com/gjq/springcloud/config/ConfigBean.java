package com.gjq.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
	@LoadBalanced  //代表开启了负载均衡
	@Bean
	public RestTemplate getRestTemplate(){
		//向spring容器当中添加RestTemplate组件，直接通过此组件调用Rest接口
		return new RestTemplate();		
	}

}
