package com.revature.util;

import com.revature.Exception.NoGradeYearException;
import com.revature.models.Student;

public class UtilityMethod {

	public static void validateGradYear( int gradeYear )  throws NoGradeYearException{
	
		if(gradeYear<= 0  || gradeYear > 4) {
			throw new NoGradeYearException("Please enter a valid grade year betwen 1 - 4");
			
		}
		
		
	}
	
	public static void printStudentInfo(Student[] students) {
		
		for(Student s: students) {
			System.out.println(s.toString());
		}
		
	}
	
	
	
}
