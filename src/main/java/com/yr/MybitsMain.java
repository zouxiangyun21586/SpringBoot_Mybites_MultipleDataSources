package com.yr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.yr") // 扫描所有注解
//@MapperScan(basePackages = "com.yr.mapper") // 扫描Mapper类 -- 注解多个包@MapperScan({"com.yr.mapper1","com.yr.mapper2"})
@EnableAutoConfiguration // 如果在数据源类中使用 mapperscan扫描了 mvc三层+ 实体类 会在页面访问时报找不到service中的方法
//@SpringBootApplication注解 等价于以默认属性使用 @Configuration，@EnableAutoConfiguration 和 @ComponentScan
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // 取消默认加载数据源 exclude ,使用多数据源时使用
public class MybitsMain {
	public static void main(String[] args) {
		SpringApplication.run(MybitsMain.class, args);
	}
}
