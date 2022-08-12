package com.vfi.training;

import java.util.Arrays;
import java.util.List;

public class User {
	
	public String greet(String username) { 
		return "Have a great day "+username;
	}
	public List<String> showFruit(){
		List<String> fruit=Arrays.asList("Mango","Apple","Orange");
		
		return fruit;
	}

}
