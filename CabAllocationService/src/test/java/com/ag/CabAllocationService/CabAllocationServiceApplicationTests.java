package com.ag.CabAllocationService;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(classes = CabAllocationServiceApplicationTests.IntegrationTest.class)
class CabAllocationServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	
	 @Configuration
	    @EntityScan( basePackages = {"com.ag.entities"} )
	    @EnableAutoConfiguration(exclude = {
	        WebMvcAutoConfiguration.class
	    })
	    protected static class IntegrationTest {
	        public static void main(String[] args) {
	            SpringApplication.run(CabAllocationServiceApplication.class, args);
	        }
	    }

}
