package com.testcases.trial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.vfi.training.Shape;

class ShapeTest {
	Shape shape;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		shape=new Shape();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test @DisplayName("Testing Area")
	void test() {
		assertEquals(300, shape.calcArea(30, 10));
		
	}

}
