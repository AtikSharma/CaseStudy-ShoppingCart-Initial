package com.eurekaserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EurekaServerApplicationTests {

	@Test
	void contextLoads() {
		int a = 10 ;
		int b =10 ;
		assertEquals(a,b);
	}

}
