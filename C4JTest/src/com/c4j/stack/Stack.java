package com.c4j.stack;

import java.util.Arrays;

import de.vksi.c4j.ContractReference;
import de.vksi.c4j.Pure;

/**
 * 
 * @author leoky
 *
 * @param <E>
 */
@ContractReference(StackContract.class)
public class Stack<E> {

	private int size = 0;
	private int previousSize = 0;
	private Object elements[];

	public static final int DEFAULT_CAPACITY = 1000000;
	public static final int MAX_CAPACITY = Integer.MAX_VALUE;
	
	/**
	 * 
	 */
	public Stack() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	/**
	 * Returns the topmost element of this stack without removing it.
	 */
	@SuppressWarnings("unchecked")
	public E peek() {
		E e = (E) elements[size-1];
		return e;
	}

	/**
	 * Pushes an element onto the stack.
	 */
	public void push(E e) {
		/*if (size == elements.length) {
			ensureCapacity();
		}*/
		elements[size] = e;
		previousSize = size;
		size++;
	}

	/**
	 * Pops the topmost element off this stack.
	 */
	@SuppressWarnings("unchecked")
	public E pop() {
		previousSize = size;
		size--;
		E e = (E) elements[size];
		elements[size] = null;
		
		return e;
	}

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
	
	//-------------------------------------------------------
	@Pure
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	@Pure
	public int getPreviousSize() {
		return previousSize;
	}

	@Pure
	public Object[] getElements() {
		return elements;
	}

	public void setElements(Object[] elements) {
		this.elements = elements;
	}
}