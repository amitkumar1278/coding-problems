/**
 * 
 */
package com.akg.problem.timeComplexity.math;

/**
 * @author amit
 * 
 * What is the time complexity of the above function assuming n > m?
 * 
 */
public class GCD {


	static int gcd(int n, int m) {

		int t = 0;

		if (n%m ==0) return m;

		if (n < m) {
			n = n - m;
			m = n + m;
			n = m - n;
		}

		while(m > 0) {
			t = n % m;
			n = m;
			m = t;
		}

		return n;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 80;
		int m = 120;

		System.out.println("n: "+n +", m: "+m);
		int r = gcd(n, m);
		System.out.println("r: "+r);
	}

}


/**
 * Answer: Θ(logn)
 * The complexity of this algorithm is worst case right? 
 * Then why it is Θ(log n) and not O(log n) ?
 * 
 * Explanation:
 * 
 * Let us say n = fibonacci(N) and m = fibonacci(N - 1)
 * 
 * fibonacci(N) = fibonacci(N-1) + fibonacci(N-2)
 * 
 * OR n = m + k where k < m. 
 * 
 * Therefore the step: 
 *   	n = n % m will make n = k
 *      swap(n, m) will result in
 *      n = fibonacci(N-1)
 *      m = k = fibonacci(N-2)
 *      
 * So, it will take N steps before m becomes 0.
 * This means, in the worst case, this algorithm can take N step if **n** is Nth fibonacci number. 
 * **Think of what the relation between N and n**. 
 * 
 * 
 * observation on above time and space complexity problem:
 * =======================================================
 * 
 * 
 * You may be wondering, Where does Fib() come in ? Like how does? How is fibonacci involved in this wholes problem.
 * 
 * fibonacci comes in because of its definition. 
 * To make the worst case we need to assure that while loop runs maximum number of times and it can be assured if m and n have a fibonacci relationship. 
 * Since two fibonacci numbers will give a result which can be broken down as a sum of another two numbers hence the remainder will go on till the kth step.
 * One can then easily find the complexity of fib series by making a recursion tree.
 * 
 * 
 * 
 * 
 * **Explanation 1 ** 
 * =======================
 * Here , if we think carefully when we divide a Greater number ‘a’ by another Smaller number ‘b’ , the largest Remainder is (b - 1).
 * 
 * Example :
 * 
 * if a = 15 , b=8 , then r = (a % b) = 7
 * Now (a/2) = (15/2) = 7
 * so r = (a/2)
 * 
 * Now if we have any Other Number like a = 14 or a =13 or …less than that …
 * 
 * Then r = (14 % 8) = 6 is less than (14 / 2) = 7.
 * or (13 % 8) = 5 is less than (13 / 2) = 6.
 * Thus r is at most r = a / 2 or r < (a / 2).
 * 
 * Thus , at every step value of the greater number is reduced to (Half) or (Less Than half).
 * Now Worst Case Complexity Is When r = ( a / 2 ) in every Iteration .
 * 
 * This Is similar To a Loop Where for(i=n ; i >0 ; i/=2).
 * 
 * So Worst Time Complexity is O(log N) .
 * 
 * => THE WORST CASE HAPPENS WHEN : The 2 numbers are Fibonacci numbers and the remainder when we divide a Fibonacci number by another is another Fibonacci number.
 * 
 * EG : 8 AND 13.
 * (13 % 8) = 5 which is the previous fibonacci number of 8.
 * Same way : (8 % 5) = 3 , (5 % 3) = 2 , (3 % 2) = 1 , (2 % 1) = 0.
 * And log(N) = log8(base 2) = 3
 * No of steps = 4 = log(N) + 1
 * Remove Constants We Get Worst Complexity = log(N)
 * 
 * 
 * 
 * **Explanation 2 ** 
 * =======================
 * 
 * This algorithm requires to know before hand that
 * **the best case for GCD is the n is a multiple of m, ie, n=km (Complexity O(1)).**
 * **the worst case for GCD is when n and m are adjacent Fibonacci numbers.**
 * Only then can you proceed to solving for the worst case time complexity.
 * 
 * For the worst case, If two numbers are adjacent Fibonacci numbers (say n = Fib(N) and m = Fib(N-1))-
 * 
 * ITERATION 1:
 * Fib(N) = Fib(N-1) + Fib(N-2)
 * => n = m + k where k = Fib(N-2)
 * Therefore, n%m = k;
 * now n->m and m->k
 * clearly, n->m means n=Fib(N-1) and m->k means m=Fib(N-2) for the next iteration
 * 
 * ITERATION 2:
 * again, Fib(N-1) = Fib(N-2) + Fib(N-3)
 * => n = m + k
 * => n%m = k
 * now n->m and m->k
 * clearly, n->m means n=Fib(N-2) and m->k means m=Fib(N-3) for the next iteration
 * 
 * ITERATION 3:
 * again, Fib(N-2) = Fib(N-3) + Fib(N-4)
 * => n = m + k
 * => n%m = k
 * now n->m and m->k
 * clearly, n->m means n=Fib(N-3) and m->k means m=Fib(N-4) for the next iteration
 * 
 * AND SO ON
 * 
 * So, we will end up traversing through all the Fibonacci numbers till we reach 1.
 * How many Fibonacci numbers are there given N?
 * (1,1,2,3,5,8,…,N)
 * This follows from the statement that Fib(n) <= 2^n
 * 
 * PROOF BY INDUCTION-
 * 
 * Base Case -
 * Fib(1) = 1 and 2^1 = 2;
 * Hence Fib(1)<=2^1 is true.
 * 
 * Induction Hypothesis-
 * Fib(k) <= 2^k
 * 
 * To show -
 * Fib(k+1) <= 2^(k+1)
 * 
 * Proof- Fib(k+1) = Fib(k) + Fib(k-1)
 * < Fib(k) + Fib(k-1) + Fib(k-2)
 * = Fib(k) + Fib(k)
 * = 2Fib(k)
 * = 22^k
 * = 2^(k+1)
 * Hence, Fib(k+1) < 2^(k+1)
 * 
 * Hence proved.
 * 
 * Using this, Fib(1),Fib(2),Fib(3)…Fib(N) can be seen as
 * 2^1,2^2,2^3,…,2^N. This has N terms. Now, to express N in terms of n-
 * 
 * we have n = Fib(N) < 2^N
 * Hence n < 2^N
 * => log(n) < log(2^N)
 * => log(n) < N
 * so Fib(N) has approximately log(n) terms from 1,1,2,3,5,8,…,N
 * so the overall complexity is O(log n).
 * 
 * 
 * 
 * 
 * 
 */
