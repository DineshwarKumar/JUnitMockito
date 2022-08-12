package com.bookapp.testcases;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.service.Course;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class CourseTest {
	@Spy
	Course course;
	
	@Mock
	Course mcourse;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mcourse=new Course();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testShowCourses() {
		List<String> courses=course.showCourse();
		System.out.println(courses);
	}
	
	@Test
	void testShowCoursesMock() {
		//call the proxy method using mock object and return some data
		when(mcourse.showCourse()).thenReturn(Arrays.asList("Java"));
		
		//the mock object calls the proxy method.original method is not called
		//use when()thenReturn() to call the proxy method and return some data
		List<String> courses=mcourse.showCourse();
		System.out.println(courses);
	}
	@Test
	void testShowCoursesSpy() {
		//call the proxy method using mock object and return some data
		//when(course.showCourse()).thenReturn(Arrays.asList("Java"));
		
		//the mock object calls the proxy method.original mmethod is not called
		//use when()thenReturn() to call the proxy method and return some data
		List<String> courses=mcourse.showCourse();
		System.out.println(courses);
	}
	
	
}
