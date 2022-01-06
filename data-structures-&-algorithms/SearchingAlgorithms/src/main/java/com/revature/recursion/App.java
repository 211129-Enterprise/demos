package com.revature.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class App {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		reduceByOne(10);
		System.out.println(recursiveLinearSearch(new int[] {4,48,4,28,34,76,9,3}, 0, 28));
		System.out.println(recursiveBinarySearch(new int[] { 1, 2, 3, 4, 7, 9, 12, 18 }, 0, 7, 12));
	}

	public static void reduceByOne(int n) {

		if (n >= 0) { // we must add a condition to avoid a StackOverFlow error
						// this is also called a Base Case.
			reduceByOne(n - 1);
		}
		System.out.println("Completed Call: " + n);
	}

	public static int recursiveLinearSearch(int[] a, int i, int x) {

		if (i > a.length - 1) { // if evaluates to true, x was not found in the array
			return -1;

		} else if (a[i] == x) {
			return i;

		} else {
			System.out.println("index at: " + i); // this will show how many times it was invoked.
			return recursiveLinearSearch(a, i + 1, x); // instead of using a for loop we're incrementing i by one.
		}
	}

	public static int recursiveBinarySearch(int[] a, int min, int max, int x) {

		System.out.println("[ " + min + "..." + max + " ]");

		if (min > max) {
			return -1;

		} else {

			int mid = (min + max) / 2;

			if (a[mid] == x) {
				return mid;

			} else if (a[mid] > x) {
				return recursiveBinarySearch(a, min, mid - 1, x); // changing max to new mid

			} else {
				return recursiveBinarySearch(a, mid + 1, max, x); // changing min to new mid
			}
		}
	}
}
