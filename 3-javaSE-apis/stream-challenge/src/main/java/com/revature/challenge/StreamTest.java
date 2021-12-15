package com.revature.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;
import com.revature.models.TempStudent;

public class StreamTest {
	
    public static void main(String[] args) {
    	
    	/*
    	 * ============== Don't alter the code between lines 24 - 42 ==============
    	 */
 
        Student student1 = new Student(
            "Bob",
            20,
            new Address("1234"),
            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
 
        Student student2 = new Student(
            "Alice",
            20,
            new Address("1235"),
            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
 
        Student student3 = new Student(
            "Wally",
            20,
            new Address("1236"),
            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
 
        List<Student> students = Arrays.asList(student1, student2, student3);
        
    	/*
    	 *========== Don't alter the code above (lines 24 - 42) ===============
    	 */
        
        /***************************************************************************
         (1) Get the student with the name "Bob" and print his name to the console.
             If "Bob" does not exist, print "No student found".
     	     HINT: Store students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/

        
        Optional<Student> s = students.stream()
        			.filter(student -> student.getName().equals("Bob"))
        			.findFirst();

        // ternary operator - if the optional<Student> object is NOT null (we found the student! -> Optional class' .get() returns the value of the obj/Student
        System.out.println(s.isPresent() ? s.get().getName() : "No Student Found");
        
        
        
        /***************************************************************************
         (2) Get the student with matching zipcode "1235" and print their name to the console.
             If the address does not exist, print "No student found".
             HINT: Store students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/

        Optional<Student> s1 = students.stream()
        			.filter(student -> student.getAddress().getZipcode().equals("1235"))
        			.findFirst();
        
        System.out.println(s1.isPresent() ? s1.get().getName() : "No Student found");
        			
        
        /****************************************************************************
         (3) Get all the students that have the mobile number "3333" and print their
             names to the console.
        *****************************************************************************/

        List<Student> sWith3333 = students.stream()
        		.filter(stud -> stud.getMobileNumbers().stream().anyMatch(el -> Objects.equals(el.getNumber(), "3333")))
        		.collect(Collectors.toList());

        // this prints out each student 
        sWith3333.forEach(System.out::println);
        
        
        
        /***************************************************************************
         (4) Get all students having mobile numbers "1233" and "1234" and print their
             names to the console.
         ***************************************************************************/

        // Shout out to Kenny for solution 
        List<Student> studentsWithNums = students.stream()
        		
        		.filter(stud -> stud.getMobileNumbers()
        			.stream().anyMatch(el -> Objects.equals(el.getNumber(), "1233")))
        		// check that it includes BOTH 1233 & 1234 (set up another stream on the prev. stream)
        				.filter(s5 -> s5.getMobileNumbers().stream().anyMatch(el -> Objects.equals(el.getNumber(), "1234")))
        			.collect(Collectors.toList());
        
        String result = studentsWithNums.stream()
        		.map(Student::getName) // method referencing! Apply the getName() method from the Student class to each element
        		.collect(Collectors.joining(",", "[", "]"));
        
        System.out.println("=========================");
        System.out.println(result);
        
        
        /***************************************************************************
	     (5)**** Create a List<Student> from the tmpStudents List. Call it studentList.
	         Hint: Use Collectors.toList(). Print it to the console. 
	         Resource: https://www.geeksforgeeks.org/collectors-tolist-method-in-java-with-examples/
        ****************************************************************************/
        TempStudent tmpStud1 = new TempStudent(
            "Bob1",
            201,
            new Address("12341"),
            Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
 
        TempStudent tmpStud2 = new TempStudent(
            "Alice1",
            202,
            new Address("12351"),
            Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
 
        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
        
        // Code your Solution here, don't touch the code above
        
        List<Student> studentList = tmpStudents.stream()
        			.map(temp -> new Student(temp.name, temp.age, temp.address, temp.mobileNumbers))
        			.collect(Collectors.toList());
        
        // use a forEach loop to print this out 
 

        
        
        
 
        /***************************************************************************
         (6) Convert the List<Student> called studentList that you made in question (5) to 
             List<String> of just their names. Call this new list "studentNames". 
             Print it to the console.
        ****************************************************************************/

        
        // Code your Solution here

        
        
        
        
        /***************************************************************************
          (7) Convert List<Students> to a single String called name with just their names.
          	  Print that String to the console.
        ****************************************************************************/

        
        // Code your Solution here

        
        
        
        
        /****************************************************************************
         (8) Change all the Strings within the List<String> nameList to Upper Case.
             Print it to the screen.
        *****************************************************************************/
        List<String> nameList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        // Code your Solution here, don't touch the code above
        List<String> covertedNames = nameList.stream()
        		.map(element -> {
        		// multi line map in a stream
        			return element.toUpperCase();
        		})
        		.collect(Collectors.toList()); // terminal operator!
        
        covertedNames.forEach(System.out::println);
        
        /****************************************************************************
         (9) Sort List<String> namesList by natural order.
             Hint: Research .sorted() method https://www.geeksforgeeks.org/stream-sorted-in-java/#:~:text=Stream%20sorted()%20returns%20a,streams%2C%20no%20stability%20is%20guaranteed.
         *****************************************************************************/
        List<String> namesList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        // Code your Solution here, don't touch the code above


        
        
 
    }
    
    
}






