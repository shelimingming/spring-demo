package com.sheliming.spring.jdbcTemplate.service;

public interface AccountService {

	void transfer(String from, String to, double money);
}
