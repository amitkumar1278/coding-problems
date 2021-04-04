/**
 * 
 */
package com.akg.problem.array.math;

import java.util.ArrayList;

/**
 * @author amit
 *
 */


/**
 * Problem Description
 * =======================
 * 
 * You are in an infinite 2D grid where you can move in any of the 8 directions
 * 
 * (x,y) to 
 * 		(x+1, y), 
 * 		(x - 1, y), 
 * 		(x, y+1), 
 * 		(x, y-1), 
 * 		(x-1, y-1), 
 * 		(x+1,y+1),
 *  	(x-1,y+1), 
 *  	(x+1,y-1) 
 *  
 *  You are given a sequence of points and the order in which you need to cover the points.. 
 *  Give the minimum number of steps in which you can achieve it. You start from the first point.
 * 
 * 
 * NOTE: 
 * This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.
 *  
 * Input Format: 
 * Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.
 *  
 * Output Format: 
 * Return an Integer, i.e minimum number of steps.
 * 
 * Example Input:
 * ================
 * Input 1:		A = [0, 1, 1] 		B = [0, 1, 2] 
 * 
 * Example Output:
 * =================
 * Output 1: 2 
 * 
 * Example Explanation
 * ===================
 * 
 * => Explanation 1:
 * 
 * Given three points are: (0, 0), (1, 1) and (1, 2). 
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * 
 * NOTE: You only need to implement the given function. Do not read input, instead use the arguments to the function. 
 * Do not print the output, instead return values as specified. 
 * 
 * 
 * 
 * 
 * Hints:
 * ========================================================
 * 
 * => Access Hint 1: 
 * Note that because the order of covering the points is already defined, the problem just reduces to figuring out the way to calculate the distance between 2 points (A, B) and (C, D).
 * Can you think of a formula for calculating the distance in O(1) ?
 * 
 * 
 * => Solution Approach:
 * Note that because the order of covering the points is already defined, the problem just reduces to figuring out the way to calculate the distance between 2 points (A, B) and (C, D).
 * 
 * Note that what only matters is X = abs(A-C) and Y = abs(B-D).
 * 
 * While X and Y are positive, you will move along the diagonal and X and Y would both reduce by 1. 
 * When one of them becomes 0, you would move so that in each step the remaining number reduces by 1. 
 * In other words, the total number of steps would correspond to max(X, Y).
 * 
 * => Complete Solution:
 * 
 * 
 * 
 */
public class MinStepsInInfiniteGrid {


	// X and Y co-ordinates of the points in order.
	// Each point is represented by (X.get(i), Y.get(i))
	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		int numSteps = 0;
		for(int i = 1; i < X.size(); i++){
			numSteps += Math.max( Math.abs(X.get(i) - X.get(i-1)), Math.abs(Y.get(i) - Y.get(i-1)) ); 
		}
		return numSteps;
	}


	public static int coverPoints2(ArrayList<Integer> A, ArrayList<Integer> B) {

		int distance = 0;
		for (int i = 1; i < A.size(); i++) {
			int pointA = Math.abs(A.get(i) - A.get(i - 1));
			int pointB = Math.abs(B.get(i) - B.get(i - 1));
			distance += Math.max(pointA, pointB);
		}
		return distance;

	}


	public static int coverPoints3(ArrayList<Integer> A, ArrayList<Integer> B) {

		int steps = 0;
		int i=0;
		int j=i+1;

		for(i=0;i<A.size()-1;i++){

			if(A.get(i)==A.get(j) && B.get(i)!=B.get(j)){
				steps += Math.abs(B.get(j)-B.get(i));
				j++;

			}else if(A.get(i)!=A.get(j) && B.get(i)==B.get(j)){
				steps += Math.abs(A.get(j)-A.get(i));
				j++;

			}else{
				steps += Math.max(Math.abs(A.get(j)-A.get(i)), Math.abs(B.get(j)-B.get(i)));
				j++;
			}
		}
		return steps;
	}


	static int findDis(int x1, int y1, int x2, int y2){

		int min = Math.abs(x1-x2) < Math.abs(y1-y2) ? Math.abs(x1-x2) : Math.abs(y1-y2);
		int f1 = x1>x2 ? 1 : -1;
		int f2 = y1>y2 ? 1 : -1;
		x1=x1-f1 * min;
		y1=y1-f2 * min;

		return Math.abs(x1-x2)+Math.abs(y1-y2)+min;
	}


	/*
	 * here we tried travelling the diagonal first and then reaching to the destination straight.
	 */
	public static int coverPoints4(ArrayList<Integer> A, ArrayList<Integer> B) {

		int a=A.size(), b=B.size();
		if(a==1 && b==1)
			return 0;

		int sum=0;
		for(int i=0;i<a-1; i++){
			sum+=findDis(A.get(i), B.get(i), A.get(i + 1), B.get(i + 1));
		}

		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> pointX =  new ArrayList<>();
		ArrayList<Integer> pointY = new ArrayList<>();

		/** Fist call */
		pointX.add(0);
		pointX.add(3);

		pointY.add(0);
		pointY.add(4);		

		System.out.println("pointX : "+pointX +", pointY : "+pointY);
		System.out.println("coverPoints2 :: total steps: "+coverPoints2(pointX, pointY));
		System.out.println("coverPoints3 :: total steps: "+coverPoints3(pointX, pointY));
		System.out.println("coverPoints4 :: total steps: "+coverPoints4(pointX, pointY));
		System.out.println("============================================");


		/** Second call */
		pointX =  new ArrayList<>();
		pointX.add(0);
		pointX.add(1);
		pointX.add(1);

		pointY =  new ArrayList<>();
		pointY.add(0);
		pointY.add(1);		
		pointY.add(2);

		System.out.println("pointX : "+pointX +", pointY : "+pointY);
		System.out.println("coverPoints2 :: total steps: "+coverPoints2(pointX, pointY));
		System.out.println("coverPoints3 :: total steps: "+coverPoints3(pointX, pointY));
		System.out.println("coverPoints4 :: total steps: "+coverPoints4(pointX, pointY));
		System.out.println("============================================");
		
		/** Third call */
		pointX =  new ArrayList<>();
		pointX.add(0);

		pointY =  new ArrayList<>();
		pointY.add(0);

		System.out.println("pointX : "+pointX +", pointY : "+pointY);
		System.out.println("coverPoints2 :: total steps: "+coverPoints2(pointX, pointY));
		System.out.println("coverPoints3 :: total steps: "+coverPoints3(pointX, pointY));
		System.out.println("coverPoints4 :: total steps: "+coverPoints4(pointX, pointY));
		System.out.println("============================================");

	}

}
