/**
 * 
 */
package com.akg.problem.timeComplexity.math;

/**
 * @author amit
 *
 */
public class WHILE_CMPL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 9;
		int a = 0, i = N;
		while (i > 0) {
			a += i;
			i /= 2;
			
			System.out.println("a: "+ a +", i: "+i);
		}
	}

}


/**
 * Answer: O(log N)
 * Explanation: 
 * 
 * Hint (Solution Approach):   	Notice that in every iteration, i goes to i / 2
 * 								So, after x iterations, i will be N / 2^x
 * 								We have to find first x such that N / 2^x < 1 OR 2^x > N 
 * 
 * Hint (Complete Solution):	We have to find the smallest x such that `N / 2^x < 1 OR 2^x > N`
 * 								x = log(N) 
 * 
 * time complexity calculation:
 * ============================
 * for every iteration, i becomes i/2
 * more explicitly, if i = N, i becomes N/2, N/4, N/6 ......
 * OR in General, N/2^X for X iterations
 * 
 * thus when i<=0 or i<1, the loop terminates.
 * thus N/2^x < 1  	
 * =>		N < 2^x 
 * => 		log(N) < x log(2) 	
 * => 		log(N)/log(2) < x  	
 * => 		log2(N) < x 
 * 
 * thus when x = log2 (N), that will be the last iteration of the loop
 *  
 */

