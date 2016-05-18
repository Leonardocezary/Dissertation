package com.cfj.stack.main;

import com.cfj.stack.Stack;

/**
 * 
 * @author Leonardocezary_Ioan
 *
 */
public class Main {

	public static void main(String[] args) {

		Stack<Integer> myStack = new Stack<Integer>();

		long startTime = System.nanoTime();

		for (int i = 0; i < 1000000; i++) {
			myStack.push(i);
		}

		/*
		 * myStack.push(1); myStack.push(2); myStack.push(3);
		 */

		long endTime = System.nanoTime();
		double x = (double) (endTime - startTime) / 1000000000.0;

		System.out.println("\nTotal execution time is: " + x + " seconds.");

	}

}
