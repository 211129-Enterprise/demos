import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

     private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        If (n%2!=0) {
            system.out.println("Weird");
        } else if(n<=5) {
            system.out.println("Not Weird");
        } else if(n<=20) {
            system.out.println("Weird");
        } else if (n>20) {
            system.out.println("Not Weird");
        }
        scanner.close();
    }
}

