/**
 * 
 */
package com.akg.problem.timeComplexity.BasicPrimer;

/**
 * @author amit
 *
 */
public class NESTED_CMPL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/** What is the time, space complexity of following code : */
		
		int a = 0, b = 0;    
		int N = 5;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a = a + j;
			}
		}
		System.out.println("a: "+a);

		
		for (int k = 0; k < N; k++) {
			b = b + k;
		} 
		System.out.println("b: "+b);

	}

}



/**
 * Answer: O(N * N) time, O(1) space
 * 
 * Explanation: 
 * 
 * Hint (Solution Approach):   	Notice how the nested loop behaves. The i loop iterates for N times and the j loop itself is run N times.
 * 								So, the total number of runs would be N + N + …. N times
 * 
 * 
 * Hint (Complete Solution):	The first set of nested loops is O(N^2) and the second loop is O(N). 
 * 								This is O(max(N^2,N)) which is O(N^2). 	
 * 
 * 
 * observation on above time and space complexity problem:  
 * =======================================================
 * 
 * => The time complexity of an algorithm is the number of operations involved.
 * => for space complexity it is only assigning values for a & b. No new memory is allocated when the loop is executed that is why space complexity is O(1).
 * 
 * 
 * => explanation: As per your logic It would be O(N*N) + O(N), being said that now take very very large inputs for N and look at the problem again. 
 * 		As the input grows exponentially the value of O(N) would be insignificant compared to the value O(N*N). So we would chuck the lower order terms. 
 * 		Now imagine and add another three nested for loop to this problem, the complexity becomes O(N*N*N) + O(N*N) + O(N) , 
 * 		again here for very large inputs O(N*N) and O(N) values will be insignificant compared to O(N*N*N) , so here we chuck the lower order terms O(N*N) and O(N).
 * 
 * 		in short, Since ,here the loop was nested. and and the complexity of nested loops depends upon the number of nested ladder.
 * 
 * 		in other words, the complexity of loops becomes on the nested ladder but here for large inputs we have to ignore the lower order terms leaving us with O(n^2).
 * 
 * => space complexity is O(1), because, here space(memory) taken only by two variables ‘a’ and ‘b’. it doesn’t depend on the input size(N)
 * 		
 * 		in other words, 
 * 			Here the assignment of int a = 0, b = 0; 
 * 			happens only once and inside the loop a and b values are just been replaced so the space of the a and b remains the same as we are just replacing it. 
 * 			If we would have pushed into a list and as the list grows with the loop then the space complexity would have been O(n).
 * 
 *  https://www.interviewbit.com/problems/nestedcmpl/
 *  
 */










