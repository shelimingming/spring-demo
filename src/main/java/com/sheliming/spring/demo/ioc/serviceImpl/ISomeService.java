package com.sheliming.spring.demo.ioc.serviceImpl;

import com.sheliming.spring.demo.ioc.service.BaseService;

public class ISomeService implements BaseService {

	public String doSome() {
		// TODO Auto-generated method stub
		return "Hello mike";//增强效果，doSome方法返回值都是大写
	}

}
