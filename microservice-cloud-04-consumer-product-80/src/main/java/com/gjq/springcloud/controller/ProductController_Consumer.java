package com.gjq.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gjq.springcloud.pojo.Product;

@RestController
public class ProductController_Consumer {
	@Autowired
	private RestTemplate restTemplate;
	//private static final String REST_URL_PREFIX="http://localhost:8001";
	private  static  final  String  REST_URL_PREFIX  =  "http://MICROSERVICE-PRODUCT";
	@RequestMapping(value = "/consumer/product/add")
	public boolean add(Product product)throws Exception{
		return restTemplate.postForObject(REST_URL_PREFIX+"/product/add", product, Boolean.class);
	}
	@RequestMapping(value = "/consumer/product/get/{id}")
	public Product get(@PathVariable("id") Long id)throws Exception{
		return restTemplate.getForObject(REST_URL_PREFIX+"/product/get/"+id,Product.class);
	}
	@RequestMapping(value  =  "/consumer/product/list")
	public  List<Product>  list() throws Exception {
	    return  restTemplate.getForObject(REST_URL_PREFIX  +  "/product/list", List.class);
	}
}
