package com.gjq.springcloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gjq.springcloud.pojo.Product;

@Mapper //到项目启动时可以直接扫描到mapper接口，或者在启动类上加上一个注解
public interface ProductMapper {
	public Product  findById(Long  pid)throws Exception;

	public List<Product>  findAll()throws Exception;

	public boolean  addProduct(Product  product)throws Exception;
}
