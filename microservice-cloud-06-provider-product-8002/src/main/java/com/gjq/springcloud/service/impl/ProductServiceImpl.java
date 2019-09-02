package com.gjq.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjq.springcloud.mapper.ProductMapper;
import com.gjq.springcloud.pojo.Product;
import com.gjq.springcloud.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;
	@Override
	public boolean add(Product product) throws Exception {
		// TODO Auto-generated method stub
		return productMapper.addProduct(product);
	}

	@Override
	public Product get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return productMapper.findById(id);
	}

	@Override
	public List<Product> list() throws Exception {
		// TODO Auto-generated method stub
		return productMapper.findAll();
	}

}
