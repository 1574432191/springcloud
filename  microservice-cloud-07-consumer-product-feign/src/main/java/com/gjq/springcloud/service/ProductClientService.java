package com.gjq.springcloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gjq.springcloud.pojo.Product;
//指定调用的服务 MICROSERVICE-PRODUCT
//fallback作用:指定熔断处理类，如果被调用的方法处理异常,就会交给熔断处理类中的方法进行处理
@FeignClient(value="MICROSERVICE-PRODUCT",fallback=ProductClientServiceFallBack.class)
public interface ProductClientService {
	@RequestMapping(value = "/product/get/{id}",method = RequestMethod.GET)
	//请求路径后面要传参的话，就需要使用@Pathvariable()来映射URL中的占位符到目标方法的参数中
	public Product get(@PathVariable("id") Long id)throws Exception;
	
	@RequestMapping(value = "/product/list",method = RequestMethod.GET)
	public List<Product> list()throws Exception;
	
	@RequestMapping(value = "/product/add",method = RequestMethod.POST)
	public boolean add(Product product)throws Exception;
}
