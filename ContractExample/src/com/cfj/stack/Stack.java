package com.cfj.stack;

import java.util.Arrays;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant("size >= 0")
public class Stack<E> {

	private int size = 0;
	private static final int DEFAULT_CAPACITY = 1000000;
	private Object elements[];

	public Stack() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	/**
	 * Returns the topmost element of this stack without removing it.
	 */
	@SuppressWarnings("unchecked")
	@Requires("size >= 1")
	public E peek() {
		E e = (E) elements[size-1];
		return e;
	}

	/**
	 * Pushes an element onto the stack.
	 */
	@Ensures({ "size == old (size) + 1", "elements[size-1] == old (e)" })
	public void push(E e) {
		/*if (size == elements.length) {
			ensureCapacity();
		}*/
		elements[size] = e;
		size++;
	}

	/**
	 * Pops the topmost element off this stack.
	 */
	@SuppressWarnings("unchecked")
	@Requires("size >= 1")
	@Ensures({"size == old (size) - 1", "result == old (elements[size-1])"})
	public E pop() {
		size--;
		E e = (E) elements[size];
		elements[size] = null;
		
		return e;
	}

	@Requires("size >= 0")
	@Ensures({"size == old (size)"})
	public void displayStack(){
		
		int stackMarginLength = determineMaximumWidth(elements) + 4;//(elements[0] != null)? 4 + elements[0].toString().length(): 8;
		String stackMargin = new String(new char[stackMarginLength]).replace("\0", "-");
		
		System.out.println("Current stack\n");
		System.out.println(stackMargin);
		
		for (int i = elements.length - 1; i >= 0; i--){
			if (elements[i] == null)
				continue;
			String elementMargin = new String(new char[(stackMarginLength - 2)/2]).replace("\0", " ");
			System.out.println("-" + elementMargin + elements[i] + elementMargin + "-");
		}
		
		System.out.println(stackMargin + "\n");
	}
	
	/**
	 * Copies the current array containing the current elements 
	 * into a new array with +1 the previous size.
	 */
	private void ensureCapacity() {
		int newSize = elements.length + 1;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	private int determineMaximumWidth(Object[] stack){
		
		int stackMarginLength = (elements[0] != null)? elements[0].toString().length(): 4;
		
		for (int i = 0; i < stack.length; i++){
			
			if (stack[i] == null )
				continue;
			if (stack[i].toString().length() > stackMarginLength)
				stackMarginLength = stack[i].toString().length();
		}
		
		return stackMarginLength;
	}
}
