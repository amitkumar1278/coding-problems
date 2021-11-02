/**
 * 
 */
package com.akg.problem.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author amit
 *
 */
public class PairsOfIntForObjSumFromArray {

	/**
	 * @param args
	 */	
	public static void main(String args[]) { 

		int[] numbers = { 3,6,14,16 }; 
		int objectiveSum = 9;

		System.out.println("Given array : " + Arrays.toString(numbers)); 
		System.out.println("Given sum : " + objectiveSum); 
		System.out.println("Integer numbers & Index, whose sum is equal to value : " + objectiveSum); 

		System.out.println("=================  1st approach  =================");
		printPairs(numbers, objectiveSum); 

		System.out.println("=================  2nd approach  =================");
		printPairsUsingMap(numbers, objectiveSum);

		System.out.println("=================  3rd approach  =================");
		printPairsUsingSet(numbers, objectiveSum);

		System.out.println("=================  4th approach  =================");
		printPairsUsingTwoPointers(numbers, objectiveSum);
	} 

	/** 
	 * complexity: O(n^2) 
	 * */ 
	public static void printPairs(int[] array, int sum) { 

		for (int i = 0; i < array.length; i++) { 
			for (int j = i + 1; j < array.length; j++) { 

				if ((array[i] + array[j]) == sum) { 
					System.out.printf("(%d, %d) at position (%d, %d) %n", array[i], array[j], i, j); 
				}

			} 
		} 

	} 


	public static void printPairsUsingMap(int[] numbers, int n){ 

		if(numbers.length < 2)	return; 

		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < numbers.length; i++){ 

			int target = n - numbers[i]; // if target number is not in set then add 
			if(!map.containsKey(target)){ 
				map.put(numbers[i], i);
			}else { 
				System.out.printf("(%d, %d) at position (%d, %d) %n", target, numbers[i], map.get(target), i); 
			} 
		} 
	}


	public static void printPairsUsingSet(int[] numbers, int n){ 

		if(numbers.length < 2){ 
			return; 
		} 

		Set<Integer> set = new HashSet<Integer>(numbers.length); 
		for(int value : numbers){ 

			int target = n - value; // if target number is not in set then add 
			if(!set.contains(target)){ 
				set.add(value); 
			}else { 
				System.out.printf("(%d, %d) %n", value, target); 
			} 
		} 
	}

	public static void printPairsUsingTwoPointers(int[] numbers, int k){ 
		if(numbers.length < 2){ return; } 
		Arrays.sort(numbers); 
		int left = 0; int right = numbers.length -1; 

		while(left < right){ 
			int sum = numbers[left] + numbers[right]; 
			if(sum == k){ 
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]); 
				left = left + 1; right = right -1; 
			}else if(sum < k){ 
				left = left +1; 
			}else if (sum > k) { 
				right = right -1; 
			} 
		} 
	}

}





