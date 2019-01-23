package com.yr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//basePackages = "com.package" (扫描一个包) --- basePackages ="com.package1,com.package2"(扫描多个包)
@ComponentScan(basePackages = "com.yr.controller, com.yr.exception, com.yr.service, com.yr.dao, com.yr.dao2, com.yr.config.jdbc") // 自动扫描包下的注解类  
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration // 自动配置
public class Main {
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args); // 标识为启动类
	}
}

