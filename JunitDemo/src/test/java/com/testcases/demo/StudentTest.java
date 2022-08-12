package com.testcases.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.vfi.exception.InValidNumberException;
import com.vfi.exception.NegativeValueException;
import com.vfi.training.Student;

class StudentTest {
	Student student= null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student=new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student=null;
	}

	@Test @DisplayName("Testing calcTotal")
	void testCalcTotal() throws NegativeValueException, InValidNumberException {
		assertEquals(220,student.calcTotal(90, 60, 70));
	}
	
	@Test @DisplayName("Testing Negative value")
	void testNegative() {
		//lambda expression will return the value so we have given in same line
		assertThrows(NegativeValueException.class, ()->student.calcTotal(-90, 90, 80)); 
	}
	
	@Test @DisplayName("Testing marks greater than 100")
	void testGreaterTotal() {
		assertThrows(InValidNumberException.class, ()->student.calcTotal(110,80,80));
	}
	
	@Test @DisplayName("Testing grade - A")
	void testGetGradeA() {
		int[] marks= {90,92,98};
		String grade=student.getGrade(marks);
		assertEquals("A", grade, "Expecting grade A");
	}
	@Test @DisplayName("Testing grade - B")
	void testGetGradeB() {
		int[] marks= {90,88,80};
		String grade=student.getGrade(marks);
		assertEquals("B", grade, "Expecting grade B");
	}
	@Test @DisplayName("Testing grade - C")
	void testGetGradeC() {
		int[] marks= {70,88,60};
		String grade=student.getGrade(marks);
		assertEquals("C", grade, "Expecting grade C");
	}
	@Test @DisplayName("Testing grade - D")
	void testGetGradeD() {
		int[] marks= {55,50,60};
		String grade=student.getGrade(marks);
		assertEquals("D", grade, "Expecting grade D");
	}
	@Test @DisplayName("Testing grade - Fail")
	void testGetGradeFail() {
		int[] marks= {40,45,48};
		String grade=student.getGrade(marks);
		assertEquals("Fail", grade, "Expecting Fail"); 
	}
	@Test @DisplayName("Testing marks Negative")
	void testGetGradeNegative() {
		int[] marks= {-80,45,48};
		assertThrows(NegativeValueException.class,()->student.getGrade(marks));
	}
	@Test @DisplayName("Testing marks Greater than 100")
	void testGetGradeInvalidNumber() {
		int[] marks= {80,45,148};
		assertThrows(InValidNumberException.class,()->student.getGrade(marks));
	}
	
	@Test @DisplayName("NullCheck")
	void testNullCheck() {
		int[] marks =null;
	assertNull(student.getGrade(marks));
	}

}
