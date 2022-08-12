package com.vfi.training;

import com.vfi.exception.InValidNumberException;
import com.vfi.exception.NegativeValueException;

public class Student {
	
	public int calcTotal(int m1,int m2,int m3) throws NegativeValueException, InValidNumberException{
		if(m1<0||m2<0||m3<0)
		{
			throw new NegativeValueException("Marks should be greater then zero");
		}
		if(m1>100||m2>100||m3>100)
		{
			throw new InValidNumberException("Marks is greater than 100");
		}
		 return (m1+m2+m3);
	}
	public String getGrade(int[] marks) 
	{
		int sum=0;
		if(marks==null)
			return null;
		for(int mark : marks) {
			if(mark>100)
				throw new InValidNumberException();
			if(mark<0)
				throw new NegativeValueException();
			sum+=mark;
		}
		int average=sum/marks.length;
		if(average>=90)
			return "A";
		else if(average>=80 && average<90)
			return "B";
		else if(average>=60 && average<80)
			return "C";
		else if(average>=50 && average<60)
			return "D";
		else 
			return "Fail";
		
		
		
	}

}
