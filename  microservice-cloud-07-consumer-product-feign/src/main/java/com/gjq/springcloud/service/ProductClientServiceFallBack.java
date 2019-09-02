package com.gjq.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gjq.springcloud.pojo.Product;

@Component //不要少了
public class ProductClientServiceFallBack implements ProductClientService{

	@Override
	public Product get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return new Product(id, "id="+ id + "无数据--feign&hystrix", "无有效数据库");
	}

	@Override
	public List<Product> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Product product) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
