/**
 * 
 */
package com.akg.problem.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Java program to count the number of occurrence of any character on String.
 * 
 * @author amit
 */
public class CountCharacters {

	private static final Logger logger = LoggerFactory.getLogger(CountCharacters.class);

	public static void main(String args[]) {

		String input = "Today is Holiday"; // count number of "a" on this String.
		String occuranceOf = "a";

		logger.info("count of occurrence of character: '{}' on String: '{}' using Spring StringUtils: {}.", occuranceOf,
				input, countUsingSpringStringUtils(input, occuranceOf));

		logger.info("\"count of occurrence of character: '{}' on String: '{}' using for loop:  {}.", occuranceOf, input,
				charCountUsingFor(input, occuranceOf));

		logger.info("\"count of occurrence of character: '{}' on String: '{}' using for each loop:  {}.", occuranceOf, input,
				charCountUsingForeach(input, occuranceOf));
	}

	/**
	 * @param input
	 * @param occuranceOf
	 * @return
	 */
	private static int charCountUsingForeach(String input, String occuranceOf) {
		// a more elegant way of counting occurrence of character in String using
		// foreach loop

		int charCount = 0; // resetting character count
		for (char ch : input.toCharArray()) {
			if (ch == 'a') {
				charCount++;
			}
		}

		return charCount;
	}

	/**
	 * @param input
	 * @param occuranceOf
	 * @return
	 */
	private static int charCountUsingFor(String input, String occuranceOf) {
		// counting occurrence of character with loop
		int charCount = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'a') {
				charCount++;
			}
		}
		return charCount;
	}

	/**
	 * @param input
	 * @param string
	 * @return
	 */
	private static int countUsingSpringStringUtils(String input, String occuranceOf) {
		// Using Spring framework StringUtils class for finding occurrence of another
		// String
		return StringUtils.countOccurrencesOf(input, occuranceOf);
	}

}
