package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		
		String base = "";
		for(int i= string.length()-1; i>=0; i--) {
			base += string.charAt(i);
		}
		
		return "";
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		char letter;
		String acronym = "";
		for (int i=0; i<phrase.length(); i++) {
			letter = phrase.charAt(i);
			if(i == 0) {
				acronym = acronym + Character.toUpperCase(phrase.charAt(i));
			}
			if(letter == ' ' || letter == '-') {
				acronym = acronym + Character.toUpperCase(phrase.charAt(i+1));
				
			}
		}		
		return "";
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo && sideTwo == sideThree && sideOne == sideThree) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree){
			    return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int score = 0 ;
		for(int i=0; i < string.length(); i++) {
			char letter = string.charAt(i);
			switch(letter) {
				case 'a':
				case 'A':
				case 'e':
				case 'E':
				case 'i':
				case 'I':
				case 'o':
				case 'O':
				case 'u':
				case 'U':
				case 'l':
				case 'L':
				case 'n':
				case 'N':
				case 'r':
				case 'R':
				case 's':
				case 'S':
				case 't':
				case 'T':
					score += 1;
					break;
				case 'd':
				case 'D':
				case 'g':
				case 'G':
					score += 2;
					break;
				case 'b':
				case 'B':
				case 'c':
				case 'C':
				case 'm':
				case 'M':
				case 'p':
				case 'P':
					score += 3;
					break;
				case 'f':
				case 'F':
				case 'h':
				case 'H':
				case 'v':
				case 'V':
				case 'w':
				case 'W':
				case 'y':
				case 'Y':
					score += 4;
					break;
				case 'k':
				case 'K':
					score += 5;
					break;
				case 'j':
				case 'J':
				case 'x':
				case 'X':
					score += 8;
					break;
				case 'q':
				case 'Q':
				case 'z':
				case 'Z':
					score += 10;
					break;
			}
		}
		return 0;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String number = "";
		for(int i=0; i<string.length(); i++) {
			char digit = string.charAt(i);
			if(digit == '-' || digit == ' ' || digit == '(' || digit == ')' || digit == '.') {
				continue;
			}
			number = number + string.charAt(i);
			
		}
		return number;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your Phrase");
		String input = in.nextLine();
	    String[] arr1 = input.split(" ");
	    int count = 0;
	    for (int i = 0; i < arr1.length; i++) {
	        count = 0;

	        for (int j = 0; j < arr1.length; j++) {
	            String temp = arr1[j];
	            String temp1 = arr1[i];

	            if (j < i && temp.contentEquals(temp1)) {
	                break;

	            }
	            if (temp.contentEquals(temp1)) {
	                count = count + 1;

	            }

	            if (j == arr1.length - 1) {
	                System.out.println(">>" + arr1[i] + " = " + count + "  number of times");

	            }

	        }

	    }
	    in.close();
		return null;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			  int start = 0;
		        int end = sortedList.size() - 1;
		        
		        while(start <= end) {
		            int mid = (start + end) / 2 ;
		            T listt = sortedList.get(mid);
		            if (listt.equals(t)) {
		                return mid;
		            }
		            
		            int comp = t.compareTo(listt);
		            if (comp < 0) {
		                end = mid - 1;
		            } else if (comp > 0) {
		                start = mid + 1;
		            }
		        }
		        return -1 ;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	 public static Boolean isVowel(char c)
	 {
	     if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' ||
	        c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U')
	        return true;
	        return false;
	 }
	public String toPigLatin(String string) {
		int size = string.length();
		String pigl ="";
		int i;
		for(i=0;i<size;i++) {
			if(isVowel(string.charAt(i))) {
				break;
			}
		}
		if(i==size) {
			return null;
		}
		pigl=string.substring(i);
		pigl=pigl+string.substring(0,i-0);
		pigl=pigl+"ay";
		return pigl;


	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		 int n = order(input);
	        int temp = input, sum = 0;
	        while (temp != 0) {
	            int r = temp % 10;
	            sum = sum + power(r, n);
	            temp = temp / 10;
	        }
	  
	         
	        return (sum == input);
		
		
	}

	private int order(int x) {
	    int n = 0;
	     while (x != 0) {
	         n++;
	         x = x / 10;
	     }
	     return n;
	}

	private int power(int x, int y) {
		if (y == 0)
	         return 1;
	     if (y % 2 == 0)
	         return power(x, y / 2) * power(x, y / 2);
	     return x * power(x, y / 2) * power(x, y / 2);
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		 List<Long> list = new ArrayList<Long>();
			Long number = null;
			list.add(number);
		      Scanner sc = new Scanner(System.in);
		      System.out.println("Enter a number ::");
		      number = sc.nextLong();
		     
		      for(int i = 2; i< number; i++) {
		         while(number%i == 0) {
		            System.out.println(i+" ");
		            number = number/i;
		         }
		      }
		      if(number >2) {
		         System.out.println(number);
		      }
		      sc.close();
		      return list ;
		      
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String message, encryptedMessage = "";
			char ch;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a message: ");
			message = sc.nextLine();
			System.out.println("Enter key: ");
			key = sc.nextInt();
			for(int i = 0; i < message.length(); ++i){
				ch = message.charAt(i);
				if(ch >= 'a' && ch <= 'z'){
				            ch = (char)(ch + key);
				            
				            if(ch > 'z'){
				                ch = (char)(ch - 'z' + 'a' - 1);
				            }
				            
				            encryptedMessage += ch;
				        }
				        else if(ch >= 'A' && ch <= 'Z'){
				            ch = (char)(ch + key);
				            
				            if(ch > 'Z'){
				                ch = (char)(ch - 'Z' + 'A' - 1);
				            }
				            
				            encryptedMessage += ch;
				        }
				        else {
				         encryptedMessage += ch;
				        }
				}
				System.out.println("Encrypted Message = " + encryptedMessage);
				sc.close();
				return null;
		}
			
		}

	

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Enter n to compute the nth prime number: ");
	    int nth = sc.nextInt(); 
	    int num, count;
	    num=1;
	    count=0;
	 
	    while (count < nth){
	      num=num+1;
	      for (i = 2; i <= num; i++){ 
	        if (num % i == 0) {
	          break;
	        }
	      }
	      if ( i == num){
	        count = count+1;
	      }
	    }
	    System.out.println("Value of nth prime: " + num);
	  
		return 0;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String ciphertext = "";
			string = removeUnwantedChars(string.toLowerCase());
	        for(char c : string.toCharArray())
	        {
	            if(Character.isLetter(c))
	            {
	                ciphertext += (char) ('a' + ('z' - c));
	            }
	            else
	            {
	                ciphertext += c;
	            }
	        }
	        return getSubStrings(ciphertext).trim();
		}

		private static String getSubStrings(String input) {
			String out = "";
	        for(int i = 0; i < input.length(); i += 5)
	        {
	            if(i + 5 <= input.length())
	            {
	                out += (input.substring(i, i + 5) + " ");
	            }
	            else
	            {
	                out += (input.substring(i) + " ");
	            }
	        }
	        return out;
		}

		private static String removeUnwantedChars(String input) {
			  String out = "";
		        for(char c : input.toCharArray())
		        {
		            if(Character.isLetterOrDigit(c))
		            {
		                out += c;
		            }
		        }
		        return out;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String plaintext = "";
			string = removeUnwantedChars(string.toLowerCase());
	        for(char c : string.toCharArray())
	        {
	            if(Character.isLetter(c))
	            {
	                plaintext += (char) ('z' + ('a' - c));
	            }
	            else
	            {
	                plaintext += c;
	            }
	        }
	        return plaintext;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		 int count = 0;
	        int sum = 0;
	        int cksum = 0;
	        char checkDigit = string.charAt(string.length() - 1);
	        
	        if ((checkDigit != 'X') && (!Character.isDigit(checkDigit))) {
	            return false;
	        }
	        
	        for (int i = 0; i < string.length() - 1; i++) {
	            char ch = string.charAt(i);
	            if (Character.isDigit(ch)) {
	                sum += Character.getNumericValue(ch);
	                cksum += sum;
	                count++;
	            } else if (ch != '-') {
	                return false;
	            }
	        }
	        
	        if (count == 9) {
	            cksum += (sum + (checkDigit == 'X' ? 10 : Character.getNumericValue(checkDigit)));
	        } else {
	            return false;
	        }
	        
	        return (cksum % 11 == 0);
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter string::");
		string = scan.nextLine();
		boolean[] alphaList = new boolean[26];
	      int index = 0;
	      int flag = 1;
	      for (int i = 0; i < string.length(); i++) {
	         if ( string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
	            index = string.charAt(i) - 'A';
	         }else if( string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
	            index = string.charAt(i) - 'a';
	      }
	      alphaList[index] = true;
	   }
	   for (int i = 0; i <= 25; i++) {
	      if (alphaList[i] == false)
	      flag = 0;
	   }
	   System.out.print("String: " + string);
	   if (flag == 1)
	      System.out.print("\nThe above string is a pangram.");
	   else
	      System.out.print("\nThe above string is not a pangram.");
	   scan.close();
	   return false;
		
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int a, int n) {
		// TODO Write an implementation for this method declaration
		Scanner scan = new Scanner(System.in);
		  System.out.println("Input the first number: ");
		   a = scan.nextInt();
		  System.out.println("Input the second number: ");
		   n = scan.nextInt();
		  
		   int m = n / a;
			 
		    // sum of first m natural numbers
		    int sum = m * (m + 1) / 2;
		 
		    // sum of multiples
		    int ans = a * sum;

	    System.out.println("Sum of multiples of " + a +
	                       " up to " + n + " = " + ans);
	    scan.close();
		return 0;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		int sum = 0;
        boolean todouble = false;
        int digitCount = 0;
        
        for (int i = string.length() - 1; i >= 0; i--) {
            char ch = string.charAt(i);
            
            if (ch != ' ' && !Character.isDigit(ch)) {
                return false;
            }
            
            if (ch == ' ') {
                continue;
            }
            
            digitCount++;
            int digitVal = Character.getNumericValue(ch);
            if (todouble) {
                digitVal *=  2;
                if (digitVal > 9) {
                    digitVal = digitVal - 9;
                }
                
            }
            sum += digitVal;
            todouble = !todouble;
        }
        
        return (digitCount > 1 && sum % 10 == 0);
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		  Scanner scan = new Scanner(System.in);
		  System.out.println("Input the first number: ");
		  int n1 = scan.nextInt();
		  System.out.println("Input the second number: ");
		  int n2 = scan.nextInt();
		  int sum = n1 + n2;
		  int minus = n1 - n2;
		  int multiply = n1 * n2;
		  int divide = n1 / n2;
		  System.out.printf("Sum = \nMinus = \nMultiply = \nDivide  = \n ", sum, minus, multiply, divide );
		  scan.close();
		return 0;
	}

}
