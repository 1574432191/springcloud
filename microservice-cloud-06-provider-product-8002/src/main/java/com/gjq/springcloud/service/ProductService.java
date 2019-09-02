package com.gjq.springcloud.service;

import java.util.List;

import com.gjq.springcloud.pojo.Product;

public interface ProductService {
	public boolean add(Product product)throws Exception;
	public Product get(Long id)throws Exception;
	public List<Product> list()throws Exception;
}
