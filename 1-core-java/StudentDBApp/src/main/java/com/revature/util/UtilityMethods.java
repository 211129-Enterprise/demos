package com.revature.util;

import com.revature.exceptions.NotAGradeYearException;
import com.revature.models.Student;

public class UtilityMethods {
<<<<<<< HEAD
	public static void validateGradeYear(int gradeYear) throws NotAGradeYearException {
		if (gradeYear <= 0 || gradeYear > 4) {
			throw new NotAGradeYearException("Please enter a valid grade year between 1-4");
		}
		
	}
	public static void printStudentInfo(Student[] students) {
		for (Student s : students) {
			System.out.println(s.toString());
		}
	}
=======
	
	public static void validateGradeYear(int gradeYear) throws NotAGradeYearException {
		
		if (gradeYear <= 0 || gradeYear > 4) {
			throw new NotAGradeYearException("Please enter a valid grade year between 1 - 4");
		} 
		
		
	}
	
	public static void printStudentInfo(Student[] students) {
		
		for (Student s : students) {
			System.out.println(s.toString());
		}
		
		
	}

>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
}
