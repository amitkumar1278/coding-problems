/**
 * 
 */
package com.akg.problem.timeComplexity.math;

/**
 * @author amit
 *
 */
public class NESTED_CMPL3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		int N = 9;

		for (int i = N; i > 0; i /= 2) {
			for (int j = 0; j < i; j++) {
				count += 1;

				System.out.println("i: " + i + ", j: " + j);
			}
			System.out.println("======================= One iteration of first loop is done =======================");
		}

		System.out.println("count : " + count);
	}

}

/**
 * Answer: O(N) according to https://www.interviewbit.com/problems/nestedcmpl3/
 * 
 * Answer: according to me O(N * log N) explanation: outer loop has log(n) then
 * it should be multiplied with inner loop which is n, hence over all complexity
 * should be n*log(n).
 * 
 * Not Satisfied, need proper explanation.
 * 
 * 
 * Explanation:
 * 
 * Hint (Complete Solution): In the first iteration, the j loop runs N times. 
 * In the second iteration, the j loop runs N / 2 times. 
 * In the ith iteration, the j loop runs N / 2^i times. 
 * So, the total number of runs of loop = N + N / 2 + N / 4 + ... 1 = **N * ( 1 + 1/2 + 1/4 + 1/8 + ... ) < 2 * N**
 * 
 * 
 * observation on above time and space complexity problem:
 * =======================================================
 * 
 * **Explanation 1 ** 
 * =======================
 * 
 * I see people having trouble with finding time complexity with nested loops like what to do multiply or add , lets see:
 * 
 * Every problem can be computed by addition method,they are actually same.
 * 
 * ** Similar problem: ** eg. 
 * for (i = n/2; i <= n; i++) { 
 * 		for (j = 2; j <= n; j = j * 2) { 
 * 			k = k + * n/2; 
 * 		} 
 * 	}
 * 
 * In the above problem we see that the outer loop has complexity O(n) and the inner loop has Olog(n), so the total time complexity is O(nlogn) which is correct, 
 * which can also be deduced in the following manner : 
 * 	for each iteration of outer loop the inner loop gets executed fixed number of time (logn times) 
 * 	so total time complexity is : logn + logn +logn +…+logn = ‘n’ times logn = nlogn (everything good till now)
 * 
 * 
 * ** now our problem ** 
 * 	for (int i = N; i > 0; i /= 2) { 
 * 		for (int j = 0; j < i; j++) { 
 * 			count += 1 ; 
 * 		} 
 * 	}
 * 
 * => here we see outer loop is logn and inner loop is ‘n’ so time complexity is nlogn, which is WRONG. 
 * => because for each iteration of outer loop the number of times inner loops executes is not fixed but depends on that outer loop, since here the condition in inner loop is (j=0; j<i; j++) but in last example it was (j=2 ; j<=n ; j=j*2) .
 * 
 * => we see " j<i " so we know that number of times inner loop runs is not fixed(which in previous example was fixed) 
 * => (try to dry run the code) so we cannot
 * 		find time complexity by multiplying the outer and inner loop’s complexity but we can find it by using a different application of multiplication i.e ADDITION
 * 		4*3 = 3+3+3+3 nlogn= logn+logn+logn…+logn (n times)
 * 
 * now : for each iteration of outer loop the inner loop gets executed some (not a fixed value) number of times
 * 		 1st 2nd 3rd 4th …(logn)th times N + N/2 + n/4 + … = N ( 1 +1/2 +1/4 +1/8…) = O(n)
 * 
 * remember we are not neglecting the outer loop in the same way in 4*3 = 3+3+3+3 we are not neglection the 4 but adding 3 four no of times.
 * 
 * 
 * **Explanation 2 ** 
 * =======================
 * 
 * in first look it seems, correct answer is: O(N*log N) but it’s actually O(2N-1), which simplifies to O(N).
 * 
 * Use an example of N=16. 
 * How many times will the outer loop execute? 
 * The first time outer loop runs, i = 16, the inner loop will run 16 times. 
 * When i = 8, inner loop will run 8 times. Carry on until the last loop.
 *  
 * If you think about it, the number of iterations run is N + N/2 + N/4 + N/8 + … + 1. 
 * Add this all up and you get 2N-1, or a time complexity of O(N).
 * 
 * => For this question, you can’t multiply the outer loop with the inner loop.
 * => It’s not the same as if you have nested for loops that are independent of each other. 
 * => I think when nested loops are dependent on each other, you have to use this kind of analysis. 
 * => It took me a while of thinking to get this straight. 
 * 
 * 
 * 
 * **Explanation 3 ** 
 * =======================
 * 
 * => It’s not that the complexity of the outer loop isn’t considered, its that it has to be considered in relation to the inner loop, because the inner loop is dependent upon the outer loop.
 * 
 * => “well that outer loop is O(log n) and the inner loop is O(n), so the solution must be O(n log n).” That would only be true, if the inner loop wasn’t dependent upon the outer loop. In that case we could simply say O(n * log n), and call it day.
 * 
 * => That’s not the case here, because the inner loop is only counting up to i. What this means is, because the inner loop is dependent upon the outer loop, we must then “count” how many times the inner loop actually gets executed. 
 * 		So for the first iteration, the inner loop is executed N times, 
 * 		the second iteration N/2 times, 
 * 		then N/4 times. 
 * 		So we end up having to write the following equation:	T(N) = N + N/2 + N/4 + N/8 +
 * 		This turns into to:		T(N) = N( 1 + 1/2 + 1/4 + 1/8 + 1/16…)
 * 		
 * 
 * **Explanation 4 ** 
 * =======================
 * 
 * We have to see how many times the statement inside the inner loop gets executed, in order to find the time complexity of the problem.
 * the inner loop will execute until "i" becomes 1 or equal to 0.
 * so the inner loop execute following no of times:-
 * 	
 * 	N + N/2 + N/4 + N/8 + ....... + N/2^K 
 * 									Until this become1 or 0;
 * 
 * Now, 
 * T(K) = N + N/2 + N/4 + N/8 + ....... + N/2^K ] -> (k+1) terms
 * This is a GP -> sum of GP = a ((1-r^n) / (1-r))
 * 
 * T(K) =  N (1-((1/2)^k=1)) / (1 - (1/2))
 * 
 * T(K) =  N ((1 - 1/(2^k * 2)) / (1/2))
 * 
 * T(K) =  2N (1 - (1 / (2 * 2^k)))
 * 		
 * T(K) =  N (2 - (1 / 2^k))
 * 
 * Now we have terminating condition for the loop, when (N/2^k = 1) or (N/2^k = 0) then the loop stops
 * 
 * lets take N/2^k = 1
 * 
 * 			=> N = 2^k
 * 			=> k = log2N
 * 
 * Now T(K) = N (2 - (1/2^k))
 * 			= N (2 - (1/2^log2N))
 * 			= N (2 - (1/N))
 * 			= 2N - 1
 * 
 * Hence T(K) = 2N - 1 = O(N)
 * 
 * 
 * ==>> pura nhi bujhaya :)
 * 
 *   https://www.interviewbit.com/problems/nestedcmpl3/
 * 
 */
	
