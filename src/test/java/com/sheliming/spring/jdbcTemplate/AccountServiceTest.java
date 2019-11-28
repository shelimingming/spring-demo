package com.sheliming.spring.jdbcTemplate;

import com.sheliming.spring.jdbcTemplate.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_jdbctemplate.xml")
public class AccountServiceTest {

	@Autowired
	private AccountService service;
	
	@Test
	public void testTransfer() {
		service.transfer("老公", "老婆", 100);
	}

}
