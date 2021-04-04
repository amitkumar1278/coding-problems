/**
 * 
 */
package com.akg.problem.array.math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author amit
 *
 */


/**
 * Max Sum Contiguous Subarray Asked in: Facebook Paypal Yahoo Microsoft, LinkedIn Amazon Goldman Sachs 
 * 
 * Problem: 
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 * or
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum. 
 * 
 * 
 * Input Format: 
 * The first and the only argument contains an integer array, A. 
 * 
 * Output Format:
 * Return an integer representing the maximum possible sum of the contiguous subarray. 
 * 
 * Constraints: 
 * 1 <= N <= 1e6 -1000 <= A[i] <= 1000 For example:
 * 
 * 
 * Input 1: A = [1, 2, 3, 4, -10] 
 * Output 1: 10 
 * Explanation 1: The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * 
 * 
 * Input 2: A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output 2: 6 
 * Explanation 2: The subarray [4,-1,2,1] has the maximum possible sum of 6.
 * 
 * NOTE: 
 * 
 * Kadane’s Algorithm: 
 * The simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). 
 * And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). 
 * Each time we get a positive-sum compare it with max_so_far and update max_so_far if it is greater than max_so_far. 
 * 
 * 
 * Question: What is a contiguous subarray?
 * Answer 1: 
 * This is just the ordinary dictionary definition of "contiguous": all adjacent in space. 
 * A subarray is defined by any subset of the indices of the original array; 
 * a contiguous subarray is defined by an interval of the indices: a first and last element and everything between them.
 * 
 * 
 * Question: What is difference between subarray and contiguous subarray?
 * Answer 1 :
 * Sub arrays are subsets of an array.
 * The difference between sub array and contiguous sub arrays is based on indexing.
 * 
 * for instance, {5,4,3,2,1} is an array of integers indexed from 0.
 * Sub arrays possible with the given array : {1},{2},{3},{4},{5},{1,5},{1,4} and so on.
 * Contiguous sub arrays must have consecutive indexes i.e., {5,4} is contiguous sub array as they have indexes that are consecutive (0,1) .
 * {5,3} cannot be contiguous as the indexes are non-consecutive (0,2)
 * 
 * 
 *  * Hints:
 * ========================================================
 * 
 * => Access Hint 1: 
 * 
 * => O(n^3) solution is simple:
 * You look at every pair (i,j) and compute the sum of elements between i and j and then take the maximum of the sums.
 * Obviously, this is not the best solution.
 * 
 * => Next improvement is O(n^2):
 * when you notice that you don’t need to sum up all the elements between i and j. 
 * You can just add A[j] to the sum you have already calculated in the previous loop from i to j-1.
 * 
 * However, we are looking for something better than N^2.
 * 
 * => For O(n) solution can you look at optimal subarray and deduce some observations from it?
 * If you start taking every element greedily when should you stop?
 * 
 * => Solution Approach:
 *
 * Let us say Ai, Ai+1 … Aj is our optimal solution.
 * Note that no prefix of the solution will ever have a negative sum.
 * 
 * 
 * Let us say Ai … Ak prefix had a negative sum.
 * Sum ( Ai Ai+1 … Aj ) = Sum (Ai … Ak) + Sum(Ak+1 … Aj)
 * Sum ( Ai Ai+1 … Aj) - Sum(Ak+1 … Aj) = Sum(Ai … Ak)
 * Now, since Sum(Ai … Ak) < 0,
 * Sum (Ai Ai+1 … Aj) - Sum (Ak+1 … Aj) < 0
 * which means Sum(Ak+1 … Aj ) > Sum (Ai Ai+1 … Aj)
 * This contradicts the fact that Ai, Ai+1 … Aj is our optimal solution.
 * Instead, Ak+1, Ak+2 … Aj will be our optimal solution.
 * 
 * Similarly, you can prove that for optimal solution, it is always good to include a prefix with positive sum.
 * Try to come up with a solution based on the previous 2 facts.
 * If this still does not make sense, watch this video for more detailed explanation : https://www.youtube.com/watch?v=ohHWQf1HDfU&ab_channel=mycodeschool
 * 
 * => Complete Solution:
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class MaxSumContiguousSubarray {


	public static int maxSubArray(final List<Integer> A) {

		int maxSum=A.get(0);
		int currSum=A.get(0);
		for(int i=1; i<A.size(); i++){
			currSum=Math.max(A.get(i),currSum+A.get(i));
			maxSum=Math.max(maxSum,currSum);
		}
		return maxSum;
	}

	// overall time complexity O(n^3) : Brute Force Algorithm
	static int maximumSubArray_N3(int arr[], int n) {

		int ans = Integer.MIN_VALUE;

		for(int subArraySize = 1; subArraySize <= n; ++subArraySize){ // O(n)
			for(int startIndex = 0; startIndex < n; ++startIndex) { // O(n)

				if(startIndex + subArraySize > n) // subarray exceeds array bounds
					break;

				int sum = 0;
				for(int i = startIndex; i < (startIndex + subArraySize); i++) { // O(n)
					sum += arr[i];
					ans = Math.max(ans, sum);
					//					System.out.println("subArraySize : "+ subArraySize +", startIndex : "+startIndex+", i : "+i+", sum : "+sum+", ans : "+ans);
				}
			}
		}

		return ans;
	}

	// overall time complexity O(n^2): Brute Force Algorithm
	static int maximumSubArray_N2(int arr[], int n) {

		int ans = Integer.MIN_VALUE;
		for(int startIndex = 0; startIndex < n; ++startIndex) { // O(n)

			int sum = 0;
			for(int subArraySize = 1; subArraySize <= n; ++subArraySize){ // O(n)

				if(startIndex + subArraySize > n) // subarray exceeds array bounds
					break;

				sum += arr[(startIndex + subArraySize) - 1]; // last elements of new subarray
				ans = Math.max(ans, sum);
			}
		}

		return ans;
	}

	/**
	 *  overall time complexity:
	 * @param arr
	 * @param n
	 * @return
	 * 
	 * T(n) = c   				if n =1
	 * T(n) = 2T(n/2) + c'n 	if n>1
	 * T(n) = cn + c'nlogn
	 * 
	 * O(nlogn)  => similar to merge sort
	 * 
	 *  Divide and Conquer problem:
	 */
	static int maximumSubArray_NLogN(int arr[], int n) {

		if(n == 1) return arr[0];

		int m = n/2;
		int[] intArray1 = Arrays.copyOfRange(arr, 0, arr.length/2);
		//		for (int i = 0; i < intArray1.length; i++)
		//            System.out.print(intArray1[i] + " ");
		//		System.out.println("\n");
		int[] intArray2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
		//		for (int i = 0; i < intArray2.length; i++)
		//            System.out.print(intArray2[i] + " ");
		//		System.out.println("\n");

		int leftMss = maximumSubArray_NLogN(intArray1, m);
		int rightMss = maximumSubArray_NLogN(intArray2, n-m);

		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;

		for(int i = m; i < n; i++) {
			sum += arr[i];
			rightSum = Math.max(rightSum, sum);
		}

		sum = 0;

		for(int i =(m-1); i >= 0; i--) {
			sum += arr[i];
			leftSum = Math.max(leftSum, sum);
		}

		//		System.out.println("\n leftMss : "+ leftMss +" , rightMss : "+rightMss+" , leftSum : "+leftSum+" , rightSum : "+rightSum);

		int ans = Math.max(leftMss, rightMss);
		return Math.max(ans, leftSum + rightSum);
	}
	
	
	/**
	 *  kadane's algorithm: 
	 *  it assume there is at least one positive element in given array so we can safely initialize the value of sum to "0"
	 * 
	 *  time complexity: O(n)
	 * @param arr
	 * @param n
	 * @return
	 */
	static int maximumSubArray_Kadanes(int arr[], int n) {
		
		int ans = arr[0], sum = 0;
		
		for(int i = 1;i < n; ++i)	//Check if all are negative
			ans = Math.max(ans,arr[i]);	
		
		if(ans<0)					//if Max < 0 return Max
			return ans;
		ans = 0;
		
		
		for(int i = 0; i<n; ++i) {
			
			if(sum + arr[i] > 0) {
				sum += arr[i];
			}else {
				sum =0;
			}
			
			ans = Math.max(ans, sum);
		}
		
		return ans;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		List<Integer> pointX = new LinkedList<>();
		pointX.add(1);
		pointX.add(2);
		pointX.add(3);
		pointX.add(4);
		pointX.add(-10);
		int[] intArray1 = new int[]{ 1, 2, 3, 4, -10 };
		for (int i = 0; i < intArray1.length; i++)
			System.out.print(intArray1[i] + " ");
		System.out.println("\n");
		System.out.println("maximumSubArray_N3 		==> "+maximumSubArray_N3(intArray1, 5));
		System.out.println("maximumSubArray_N2 		==> "+maximumSubArray_N2(intArray1, 5));
		System.out.println("maximumSubArray_NLogN		==> "+maximumSubArray_NLogN(intArray1, 5));
		System.out.println("maximumSubArray_Kadanes		==> "+maximumSubArray_Kadanes(intArray1, 5));
		System.out.println(" Max sum is        		==> "+maxSubArray(pointX));
		System.out.println("============================================");


		int intArray2[] = { 3, -2, 5, -1 };
		for (int i = 0; i < intArray2.length; i++)
			System.out.print(intArray2[i] + " ");
		System.out.println("\n");
		System.out.println("maximumSubArray_N3 		==> "+maximumSubArray_N3(intArray2, 4));
		System.out.println("maximumSubArray_N2 		==> "+maximumSubArray_N2(intArray2, 4));
		System.out.println("maximumSubArray_NLogN		==> "+maximumSubArray_NLogN(intArray2, 4));
		System.out.println("maximumSubArray_Kadanes		==> "+maximumSubArray_Kadanes(intArray2,4));
		System.out.println("============================================");

		int intArray3[] = { 1, -3, 2, -5, 7, 6, -1, -4, 11, -23 };
		for (int i = 0; i < intArray3.length; i++)
			System.out.print(intArray3[i] + " ");
		System.out.println("\n");
		System.out.println("maximumSubArray_N3 		==> "+maximumSubArray_N3(intArray3, 10));
		System.out.println("maximumSubArray_N2 		==> "+maximumSubArray_N2(intArray3, 10));
		System.out.println("maximumSubArray_NLogN		==> "+maximumSubArray_NLogN(intArray3, 10));
		System.out.println("maximumSubArray_Kadanes		==> "+maximumSubArray_Kadanes(intArray3, 10));
		System.out.println("============================================");

	}

}
