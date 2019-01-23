package com.yr.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // 方法统一返回json格式 ,类似于类上带有 @ResponseBody 标签
//@EnableAutoConfiguration // -- 因为有Main统一启动了,所以这里不用 自动配置,在Mian类中 自动配置
public class FirstTest {

	@RequestMapping("/hello") // 访问名 -- 默认端口为 8080
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/exce") // 访问名 -- 默认端口为 8080
	public String exceptionTest() {
		int a = 1/0;
		System.out.println(a);
		return "ε＝ε＝ε＝(#>д<)ﾉ";
	}
	
//	@ExceptionHandler(Exception.class) // 仅供自己类使用的异常(如果有多个类需使用就可以配置全局异常)
//	@ResponseBody // 返回json格式
//	public Map<String, Object> exceptionHandler() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("errorCode", "101");
//		map.put("errorMsg", "系統错误!");
//		return map;
//	}
	
//	public static void main(String[] args) {
//		SpringApplication.run(FirstTest.class, args);
//	}
	
}
