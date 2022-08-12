package com.testcases.demo.check;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.vfi.training.User;

class UserTest {
	User user;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		user=new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		user=null;
	}
	
	@Test @DisplayName("Testing greet")
	@Tag("greet")
	void testGreet() {
		assertEquals("Have a great day John", user.greet("John"));
	}
	
	@Test
	void testFruit() {
		List<String> fruit=Arrays.asList("Mango","Apple","Orange");
		assertEquals(fruit, user.showFruit());
	}
	@Test
	void testFruitLength() {
		
		assertEquals(3, user.showFruit().size());
	}


}
