package com.yr.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 使用配置加入静态资源使用
 * @author zxy-un
 * 
 * 2018年7月12日 下午5:41:02
 */
@Configuration
public class Config extends WebMvcConfigurerAdapter{
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 后面的静态资源会使用test访问到,而自己访问不到 (后面的映射到前面)
//        registry.addResourceHandler("/test/**").addResourceLocations("classpath:/static/"); // http://localhost:8080/test/15.jpg
        registry.addResourceHandler("/test/**").addResourceLocations("file:/F:/zxy/my.png/Those funny/10.jpg"); // http://localhost:8080/test/10.jpg
    }
}
