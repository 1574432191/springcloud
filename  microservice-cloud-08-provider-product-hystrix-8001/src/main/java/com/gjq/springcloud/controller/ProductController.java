package com.gjq.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gjq.springcloud.pojo.Product;
import com.gjq.springcloud.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController//每个方法返回的都是一个json字符串
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping(value  =  "/product/add",  method  =  RequestMethod.POST) 
	/*
	 * @RequestBody注解对应的类在将HTTP的输入流（含请求体）装配
	 * 到目标类（即@RequestBody后面的类）。它会根据json字符串中的key来匹配对应实体类的属性
	 * 如果匹配一致且json中的该key对应的值符合（或可转换为）
	 */
	public  boolean  add(@RequestBody  Product  product) throws Exception  {
		return  productService.add(product);
	}
	//当get方法出现异常时，则会调用hystrixGet方法处理
			//处理方法的返回值和参数类型要一致 
		@HystrixCommand(fallbackMethod = "getFallback")
	@RequestMapping(value  =  "/product/get/{id}",  method  =  RequestMethod.GET) 
	public  Product  get(@PathVariable("id")  Long  id) throws Exception  {
			Product product = productService.get(id);
			
				if (product == null) {
					throw new RuntimeException("ID="+id+"无效");
				}
			
			return  product;
	}
		//当get方法出现异常时，则会调用此方法. 注意此方法的返回值，参数列表与原方法一致
	public Product getFallback(@PathVariable("id") Long id) {
		   return new Product(id, "ID=" + id + "无效--@HystrixCommand", "无有效数据库");
  }
	@RequestMapping(value  =  "/product/list",  method  =  RequestMethod.GET) 
	public  List<Product>  list() throws Exception  {
		return  productService.list();
	}
	
}
