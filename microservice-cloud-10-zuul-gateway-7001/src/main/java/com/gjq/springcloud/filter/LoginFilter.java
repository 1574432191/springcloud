package com.gjq.springcloud.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class LoginFilter extends ZuulFilter{
	Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
	    HttpServletRequest request = context.getRequest();
	    //获取请求参数token的值
	    String token = request.getParameter("token");
	    if (token == null) {
	        logger.warn("此操作需要先登录系统...");
	        context.setSendZuulResponse(false);// 拒绝访问
	        context.setResponseStatusCode(200);// 设置响应状态码
	        try {
	            //响应结果
	            context.getResponse().getWriter().write("token is empty");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	         return null;
	     }
	      logger.info("ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;  //int值来定义过滤器的执行顺序，数值越小优先级越高
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre"; //请求路由前调用
	}

}
