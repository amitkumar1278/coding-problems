/**
 * 
 */
package com.akg.problem.timeComplexity.BasicPrimer;

/**
 * @author amit
 *
 */
public class LOOP_CMPL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/** What is the time, space complexity of following code : */

		double a = 0, b = 0;    
		int N = 5, M = 5;
		
		for (int i = 0; i < N; i++) {
			a =  a + Math.random();  
		}
		System.out.println("a: "+a);
		
		for (int j = 0; j < M; j++) {
			b =  b + Math.random();
		}
		System.out.println("b: "+b);
		
		/** Assume that Math.random() is O(1) time, O(1) space function. */
	}

}






/**
 * Answer: O(N + M) time, O(1) space
 * Explanation: 
 * 
 * Hint (Solution Approach):   	Notice that the 2 loops are independent and not nested. So, we can look at them separately and then add the result.
 * 			Assume that you do not know the relation between N and M. So, try to suggest your answer as a function of N and M ( max or addition maybe ).
 * 			Remember that space complexity is measured in terms of the largest amount of memory used during runtime.
 * 
 * 
 * Hint (Complete Solution):	The first loop is O(N) and the second loop is O(M). Since you don't know which is bigger, you say **this is O(N + M)**. 
 * 								This can also be written as O(max(N, M)).
 * 								Since there is no additional space being utilized, the space complexity is constant / O(1)	
 * 
 * 
 * observation on above time and space complexity problem:  
 * =======================================================
 * 
 * => The time complexity of an algorithm is the number of operations involved.
 * => Space Complexity is O(1) only because a and b are replaced in memory and not taking new memory!
 * => Space Complexity is the extra space which your program will use to store some values.
 * => Space complexity includes both Auxiliary space and space used by input.
 * 
 * 
 * => Space complexity explanation:  
 * 		variable a and b are constants. Both loops are doing some processing and storing the values to a or b. which is constant. so the bigOh is constant storage. so we denote constant storage as bogOh(1).
 * 		In the same way, if both loops are considering new variable to store values at each loop pass then it would be directly proportional to the number of elements in the array. 
 * 		Means If loop will run to 10 times then 10 storage would be needed. If loop will run to 1000 times then 1000 storage would be needed. It means bigOh in that case could be bigOh(N)
 * 
 * => Space Complexity with recursion:
 * 		For example, think about “Recursion”. It keeps going down and doing the job until it hit the end. 
 * 		While it keeps going, you need to keep all the results from every previous step, which means you need the spaces for all of them. 
 * 		On the contrary, even though the above questions takes O(n) for each loop but the calculation inside takes only O(1); no need to save any previous result
 * 
 * => Space Complexity with array:
 * 		Space complexity is all about variables used in your algorithm. 
 * 		For example if you are adding numbers in a loop and assigning it to a variable. In this case only this variable is used as container/memory for you algorithm. so space complexity would be O(1). 
 * 		In contrast if you are pushing elements inside an array through a loop then every time your container/memory is expanding and the expansion will be directly proportional to number of times loop is running. 
 * 		Hence this will cause space complexity of O(n).
 * 
 * 
 * 
 *  https://www.interviewbit.com/problems/loopcmpl/
 *  
 */




