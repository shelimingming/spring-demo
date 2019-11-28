package com.sheliming.spring.jdbcTemplate.dao;

public interface AccountDao {
    void update(String name,double money);

    double queryMoney(String name);
}
