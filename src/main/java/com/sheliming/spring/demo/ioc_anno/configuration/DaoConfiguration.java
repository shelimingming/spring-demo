package com.sheliming.spring.demo.ioc_anno.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {

	public DaoConfiguration() {
		System.out.println("DaoConfiguration被加载...");
	}
}
