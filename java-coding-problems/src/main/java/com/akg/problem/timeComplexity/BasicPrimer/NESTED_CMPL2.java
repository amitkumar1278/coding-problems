/**
 * 
 */
package com.akg.problem.timeComplexity.BasicPrimer;

/**
 * @author amit
 *
 */
public class NESTED_CMPL2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/** What is the time complexity of the following code : */

		int N = 5;
		
		int a = 0;
		for (int i = 0; i < N; i++) {
			for (int j = N; j > i; j--) {
				a = a + i + j;
			}
		}
		
		System.out.println("a : "+a);
		
	}

}



/**
 * Answer: O(N*N)
 * 
 * Explanation: 
 * 
 * Hint (Solution Approach):   	Count the number of times the loop runs.
 * 								When i = 0, it runs for N times.
 * 								When i = 1, it runs for N - 1 times …
 * 								When i = k, it runs for N - k times
 * 								So, total number of runs = N + (N - 1) + (N - 2) + … 1 + 0 = ???
 * 
 * 
 * Hint (Complete Solution):	Total number of runs = N + (N - 1) + (N - 2) + ... 1 + 0
 * 								= N * (N + 1) / 2
 * 								= 1/2 * N^2 + 1/2 * N
 * 								O(N^2) times. 
 * 
 * 								or
 * 
 * 								N + (N - 1) + (N - 2) + … + (N - N) =
 * 								= N * N - (1 + 2 + … + N) =
 * 								= N*N - N * (N + 1) / 2 =
 * 								= N^2 - 1/2 * N^2 + 1/2 * N =
 * 								= 1/2 * N^2 + 1/2 * N
 * 
 * 								both equation give O(N^2)
 * 
 * 
 * 
 * observation on above time and space complexity problem:  
 * =======================================================
 * 
 * => The time complexity of an algorithm is the number of operations involved.
 * => for space complexity it is only assigning values for a & b. No new memory is allocated when the loop is executed that is why space complexity is O(1).
 * 
 * 
 * => explanation: The outer loop will run N times, and the inner one, worst case, will also run for N times when i = 0.That’s how I calculated it to be O(n**2).
 * 
 * => in other words:
 * 		our main aim is to find how many time the inner statement :- a = a + i + j; is executing.
 * 		so
 * 		for i=0; second loop runs from n to 0 i.e n times --> a = a + i + j ran for n time
 * 		for i=1; second loop runs from n-1 to 0 i.e n-1 times --> a = a + i + j ran for n-1 time
 * 		for i=2; second loop runs from n-2 to 0 i.e n-2 times – > a = a + i + j ran for n-2 time
 * 		.
 * 		.
 * 		.
 * 		for i=n-1; second loop runs from 1 to 0 i.e 1 times
 * 		Hence total number of times the a = a + i + j executed is = n+n-1+n-2+…1+0=n*(n+1)/2
 * 		Therefore order of n^2.
 * 		So ans is O(n^2)
 * 
 *  
 *  =>	in other words:
 *  	T(n) = 1 + 2 + 3 … + n = n(n+1)/2
 *  
 *  	Our goal to find how many times will run inner lool.
 *  	Inner loop will run times:
 *  	n + n - 1 + n - 2 … + 1 + 0
 *  	n * n - 1 - 2 - 3 - 4 … - n
 *  	n * n - (1 + 2 + 3 + 4 … + n)
 *  	n * n - (n(n + 1)/2)
 *  	n * n + (n * n - 1)/2
 *  	(n * n + (n * n - 1)/2)*2/2
 *  	(2 * n * n + (n * n - 1))/2
 *  	(3 * n * n - 1)/2
 *  	1.5n^2 - 0.5 ≈ n^2
 *  
 *  
 */





