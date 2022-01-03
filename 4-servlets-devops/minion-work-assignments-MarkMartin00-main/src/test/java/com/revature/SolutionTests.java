package com.revature;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

public class SolutionTests {

	@Test
	public void testSorted0() {

		int[] data = { 1, 2, 3 };
		int n = 0;

		int[] expected = new int[0];
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));

	}

	@Test
	public void testSorted1() {

		int[] data = { 1, 2, 2, 3, 3, 3, 4, 5, 5 };
		int n = 1;

		int[] expected = { 1, 4 };
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void testSorted2() {

		int[] data = { 1, 2, 2, 3, 3, 3, 4, 5, 5 };
		int n = 2;

		int[] expected = { 1, 2, 2, 4, 5, 5 };
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void testUnsorted0() {

		int[] data = { 5, 10, 15, 10, 15, 100, 7 };
		int n = 0;

		int[] expected = new int[0];
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void testUnsorted1() {

		int[] data = { 5, 10, 15, 10, 7 };
		int n = 1;

		int[] expected = { 5, 15, 7 };
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void testUnsorted2() {

		int[] data = { 5, 10, 15, 10, 34, 5, 5, 10, 15, 7, 1, 15 };
		int n = 2;

		int[] expected = { 34, 7, 1 };
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void testAllSameNumber_noRemoval() {

		int[] data = { 10, 10, 10, 10, 10 };
		int n = 5;

		int[] expected = data;
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));

	}

	@Test
	public void testAllSameNumber_nIs1_returnsEmpty() {

		int[] data = { 10, 10, 10, 10, 10 };
		int n = 1;

		int[] expected = new int[0];
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));
	}
	
	@Test
	public void testManyRepeatedNumbers_returnsOneValueInArr() {

		int[] data = { 10, 10, 10, 10, 10, 10, 4 };
		int n = 1;

		int[] expected = {4};
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));
	}
	
	@Test
	public void testDescendingArray() {
		
		int[] data = {10, 9, 8, 8, 7, 7, 6, 5, 4, 3, 3, 2, 1};
		int n = 1;
		
		int[] expected = {10, 9, 6, 5, 4, 2, 1};
		int[] actual = Solution.solution(data, n);

		assertTrue(Arrays.equals(expected, actual));
	}

}
