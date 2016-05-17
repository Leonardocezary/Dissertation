package com.c4j.stack;

import static de.vksi.c4j.Condition.ignored;
import static de.vksi.c4j.Condition.postCondition;
import static de.vksi.c4j.Condition.preCondition;
import static de.vksi.c4j.Condition.result;
import static de.vksi.c4j.Condition.old;
import de.vksi.c4j.ClassInvariant;
import de.vksi.c4j.Target;

public class StackContract<E> extends Stack<E> {

	@Target
	private Stack<E> target;

	@ClassInvariant
	public void classInvariant() {
		assert target.getSize() >= 0 : "size >= 0";
		assert target.getSize() <= MAX_CAPACITY : "size <= MAX_CAPACITY";
	}

	public StackContract() {
		super();
		/*
		 * if (preCondition()) { assert target.getSize() == 0 : "size = 0"; } if
		 * (postCondition()) { assert target.getSize() == DEFAULT_CAPACITY :
		 * " size = MIN_CAPACITY"; }
		 */
	}

	@Override
	public void push(E element) {
		if (preCondition()) {
			long startTime = System.nanoTime();

			assert target.getSize() >= 0 : "size >= 0";
			
			long endTime = System.nanoTime();
			double x = (double) (endTime - startTime) / 1000000000.0;
			System.out.println("\n\nPush PreCondition total execution time is: " + x + " seconds.\n");
		}

		if (postCondition()) {
			long startTime = System.nanoTime();
			
			assert target.getSize() == old(target.getSize()) + 1 : " balance set";
			
			long endTime = System.nanoTime();
			double x = (double) (endTime - startTime) / 1000000000.0;
			System.out.println("\n\nPost PostCondition total execution time is: " + x + " seconds.\n");
		}
	}

	@Override
	public E pop() {
		if (preCondition()) {
			long startTime = System.nanoTime();
			
			assert target.getSize() >= 1 : "size >= 1";
			
			long endTime = System.nanoTime();
			double x = (double) (endTime - startTime) / 1000000000.0;
			System.out.println("\n\nPop PreCondition total execution time is: " + x + " seconds.\n");
		}

		if (postCondition()) {
			long startTime = System.nanoTime();
			
			assert target.getSize() == old(target.getSize()) - 1 : " balance set";
			E e = result();
			assert e == old(target.getElements()[target.getSize() - 1]) : "result == old (elements[size-1])";
			
			long endTime = System.nanoTime();
			double x = (double) (endTime - startTime) / 1000000000.0;
			System.out.println("\n\nPop PostCondition total execution time is: " + x + " seconds.\n");
		}

		return ignored();
	}

	@Override
	public int getSize() {
		return ignored();
	}

	@Override
	public int getPreviousSize() {
		return ignored();
	}
}
