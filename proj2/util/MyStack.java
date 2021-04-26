package proj2.util;

import java.util.ArrayList;
import java.util.List;


/**
 * Basic Stack ADT implemented from scratch.
 * Contains the typical stack methods: <code>pop()</code>, <code>push()</code>, <code>top()</code>, <code>isEmpty()</code> and <code>size()</code>.
 */
public class MyStack<T> {


  // Instance attributes
  final private List<T> stack;
  final private int capacity;


  /**
  * Creates an empty stack with capacity given by the parameter <code>size</code>.
  * @param size the capacity of the stack about to be created.
  */
  public MyStack(int size) {
    stack = new ArrayList<T>(size);
    capacity = size;
  }


  /**
  * Returns <code>true</code> if the stack is empty, <code>false</code> otherwise.
  * @return boolean representing if stack is empty.
  */
  public boolean isEmpty() {
    return stack.isEmpty();
  }


  /**
  * Returns <code>true</code> if the stack is full, <code>false</code> otherwise.
  * @return boolean representing if stack is full.
  */
  public boolean isFull() {
    return stack.size() == capacity;
  }


  /**
  * Inserts an element into the top of the stack.
  * @param c the element that will be inserted.
  */
  public void push(T c) {
    if (isFull()) {
      System.out.println("Stack already full. Aborted.");
      return;
    }

    stack.add(c);
  }


  /**
  * Removes the element at the top of the stack, if any.
  * @return the element at the top of the stack, or null if stack is empty.
  */
  public T pop() {
    if (isEmpty()) {
      System.out.println("Stack already empty. Aborted.");
      return null;
    }

    int size = stack.size();
    T topElement = stack.get(size - 1);
    stack.remove(size - 1);
    return topElement;
  }


  /**
  * Returns the element at the top of the stack without removing it, if any.
  * @return the element at the top of the stack, or null if stack is empty.
  */
  public T peek() {
    if (isEmpty()) {
      return null;
    }

    int size = stack.size();
    return stack.get(size - 1);
  }


}
