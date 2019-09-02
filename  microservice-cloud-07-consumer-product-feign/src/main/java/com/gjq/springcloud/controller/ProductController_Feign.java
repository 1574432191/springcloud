package com.gjq.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gjq.springcloud.pojo.Product;
import com.gjq.springcloud.service.ProductClientService;

@RestController
public class ProductController_Feign {
	@Autowired
	private ProductClientService service;
	@RequestMapping(value = "/consumer/product/add")
	public boolean add(Product product) throws Exception {
		return service.add(product);
	}

	@RequestMapping(value = "/consumer/product/get/{id}")
	public Product get(@PathVariable("id") Long id) throws Exception {
		System.out.println("ddddddddd"+id);
		return service.get(id);
	}

	@RequestMapping(value = "/consumer/product/list")
	public List<Product> list() throws Exception {
		return service.list();
	}
}
