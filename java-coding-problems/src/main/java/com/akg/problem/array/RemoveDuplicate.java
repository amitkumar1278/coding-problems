/**
 * 
 */
package com.akg.problem.array;

import java.util.Arrays;
import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1. Java program to remove duplicates from this array. You don't need to
 * physically delete duplicate elements, replacing with null, or empty or
 * default value is ok.
 *
 * @author amit
 */

public class RemoveDuplicate {
	private static final Logger logger = LoggerFactory.getLogger(RemoveDuplicate.class);

	public static void main(String args[]) {

		int[][] array1 = new int[][] { { 1, 1, 2, 2, 3, 4, 5 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 2, 3, 4, 5, 6, 7 },
				{ 1, 2, 1, 1, 1, 1, 1 }, };

		int[][] array2 = new int[][] { { 3, 1, 1, 4, 1, 4, 5 } };

		/** Scenario 1 */
		logger.info(" ======================== Scenario 1 ============================");
		for (int[] input : array2) {
			long start = System.currentTimeMillis();
			logger.info("Array with Duplicates       : " + Arrays.toString(input));
			logger.info("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)) + " took: "
					+ (System.currentTimeMillis() - start));
		}

		/** Scenario 2 */
		logger.info(" ======================== Scenario 2 ============================");
		int[][] array3 = new int[][] { { 3, 1, 1, 4, 1, 4, 5 } };
		for (int[] input : array3) {
			long start2 = System.currentTimeMillis();
			logger.info("Array with Duplicates       : " + Arrays.toString(input));
			logger.info("After removing duplicates   : " + Arrays.toString(removeDuplicates2(input)) + " took: "
					+ (System.currentTimeMillis() - start2));
		}

		/** Scenario 3 */
		logger.info(" ======================== Scenario 3 ============================");
		int[][] array4 = new int[][] { { 3, 1, 1, 4, 1, 4, 5 } };
		for (int[] input : array4) {
			long start2 = System.currentTimeMillis();
			logger.info("Array with Duplicates       : " + Arrays.toString(input));
			logger.info("After removing duplicates   : " + removeDuplicates3(input) + " took: "
					+ (System.currentTimeMillis() - start2));
		}
	}

	/**
	 * @param numbersWithDuplicates
	 * @return
	 */
	public static int[] removeDuplicates(int[] numbersWithDuplicates) {

		// Sorting array to bring duplicates together
		Arrays.sort(numbersWithDuplicates);

		int[] result = new int[numbersWithDuplicates.length];
		int previous = numbersWithDuplicates[0];
		result[0] = previous;

		for (int i = 1; i < numbersWithDuplicates.length; i++) {
			int ch = numbersWithDuplicates[i];

			if (previous != ch) {
				result[i] = ch;
			}
			previous = ch;
		}

		return result;
	}

	/**
	 * @param a
	 * @return
	 */
	public static int[] removeDuplicates2(int[] a) {

		Arrays.sort(a);
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			if (i + 1 < a.length && a[i] == a[i + 1]) {
				count++;
			}
		}

		int[] b = new int[a.length - count];
		int c = 0;

		for (int j = 0; j < a.length; j++) {
			if (j + 1 < a.length && a[j] == a[j + 1]) {

			} else {
				b[c] = a[j];
				c++;
			}
		}

		a = b;

		return a;
	}

	/**
	 * @param a
	 * @return
	 */
	public static BitSet removeDuplicates3(int[] in) {

		BitSet filter = new BitSet(in.length);
		for (int i = 0; i < in.length; i++) {
			if (filter.get(in[i])) {
				in[i] = 0;
			} else {
				filter.set(in[i]);
			}
		}

		return filter;
	}

}
