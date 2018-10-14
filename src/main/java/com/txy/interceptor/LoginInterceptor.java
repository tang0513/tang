package com.txy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.txy.entity.User;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	//进入拦截器之前执行的方法
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}
	//进入拦截器执行的逻辑
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
	    if(user==null){
	    	response.sendRedirect("http://localhost:80/login.jsp");
	    	return ;
	    }else{
	    	super.postHandle(request, response, handler, modelAndView);
	    } 
		
	}
	//拦截器执行完后，执行该方法
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
