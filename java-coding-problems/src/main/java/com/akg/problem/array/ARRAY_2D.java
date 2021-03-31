/**
 * 
 */
package com.akg.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author amit
 *
 */
public class ARRAY_2D {


	static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < A.size(); i++) {
			B.add(new ArrayList<Integer>());

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).add(0);
			}

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
			}
		}
		return B;
	}
	
	
	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		 // TODO Auto-generated method stub

		 ArrayList<Integer> a1 = new ArrayList<>();
		 Collections.addAll(a1, 1, 2, 3, 4);
		 ArrayList<Integer> a2 = new ArrayList<>();
		 Collections.addAll(a2, 5, 6, 7, 8);
		 ArrayList<Integer> a3 = new ArrayList<>();
		 Collections.addAll(a3, 9, 10, 11, 12);
		 
		 ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		 A.add(a1);
		 A.add(a2);
		 A.add(a3);
		 
		 ArrayList<ArrayList<Integer>> B = performOps(A);
		 for (int i = 0; i < B.size(); i++) {
		     for (int j = 0; j < B.get(i).size(); j++) {
		             System.out.print(B.get(i).get(j) + " ");
		     }
		 }
	 }

}
