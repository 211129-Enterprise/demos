package com.revature.scanner;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // prompt the user to enter their name
        System.out.println("Please Enter your Name: ");
        
        // capture the users input and save it to a local variable
        String name = scan.nextLine();
        
        // ask the user for their age
        System.out.println("Please Enter your Age: ");
        
        // save the age to an int variable
        int age = scan.nextInt();
        
        // print the output
        System.out.println("Your name is " + name + " and you are " + age + " years old");
        
        int futureAge = getFutureAge(age);
        
        // print the future age
        System.out.println("In a century you will be " + futureAge + " years old.");
        
        // close the scanner
        scan.close();
    }

    
    // method: getFutureAge
    public static int getFutureAge(int age)
    {
        return age + 100;
    }
}
