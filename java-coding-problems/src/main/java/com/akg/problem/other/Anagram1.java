/**
 * 
 */
package com.akg.problem.other;

import java.util.Arrays;

/**
 * @author amit
 *
 * How do you check if the given inputs below (strings) are Anagrams or Not?
 * • input 1: home
 * • input 2: mohe
 * 
 * You may assume the string contains only lowercase alphabets.
 * Write the code in Java and print the solution result to the system output (true or false).
 * Note: Two strings are called anagrams if they contain the same set of characters but in a different order.
 * 
 */

 
public class Anagram1 {


	static int NO_OF_CHARS = 256;

	static boolean isAnagram1(char[] input1, char[] input2){
		
		if (input1.length != input2.length)
			return false;
		
		/** Create a count array and initialize all values as 0 */
		int[] count = new int[NO_OF_CHARS];
		int i;

		/** For each character in input strings, increment count in the corresponding count array */
		for(i = 0; i < input1.length; i++) {
			count[input1[i] - 'a']++;  /** get the exact position of character and increment the value in count array for characters in input1; */
			count[input2[i] - 'a']--;  /** get the exact position of character and decrement the value in count array for characters in input2; */
			
			System.out.println("1st ==>>"+input1[i]+" -- "+ (input1[i] - 'a'));
			System.out.println("1st ==>>"+input2[i]+" -- "+ (input2[i] - 'a'));
		}

		/** See if there is any non-zero value in count array */
		for(i = 0; i < NO_OF_CHARS; i++) {
			if (count[i] != 0){
				return false;
			}
		}
		
		return true;
	}

	static boolean isAnagram2(char[] input1, char[] input2)	{

		/** If length of both strings is not same, then they cannot be anagram */
		if (input1.length != input2.length)
			return false;

		/** Sort both strings */
		Arrays.sort(input1);
		Arrays.sort(input2);

		/** Compare sorted strings */
		for (int i = 0; i < input1.length; i++) {
			if (input1[i] != input2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		
		char input1[] = "home".toCharArray();
		char input2[] = "mohe".toCharArray();

		System.out.println("=================  1st approach  =================");
		if (isAnagram1(input1, input2))
			System.out.println("Anagram 1: true");
		else
			System.out.println("Anagram 1: false");
		
		
		System.out.println("=================  2nd approach  =================");
		if (isAnagram2(input1, input2))
			System.out.println("Anagram 2: true");
		else
			System.out.println("Anagram 2: false");
	}
	
}
