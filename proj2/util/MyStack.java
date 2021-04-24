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
  MyStack(int size) {
    stack = new ArrayList<>(size);
    capacity = size;
  }


  /**
   * Returns the size of the stack (amount of elements in it).
   * @return int of the number of elements in the stack
   */
  public int size() {
    return stack.size();
  }


  /**
   * Returns <code>true</code> if the stack is empty, <code>false</code> otherwise.
   * @return boolean representing if stack is empty.
   */
  public boolean isEmpty() {
    return stack.size() == 0;
  }


  /**
   *
   *
   */
  public boolean isFull() {
    return stack.size() == capacity;
  }


  /**
   * Inserts an element into the top of the stack.
   * @param c the element that will be inserted.
   */
  public void push(T c) {
    if (this.isFull()) {
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
    if (this.isEmpty()) {
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
  public T top() {
    if (this.isEmpty()) {
      System.out.println("Stack is empty. Returning null.");
      return null;
    }

    int size = stack.size();
    return stack.get(size - 1);
  }


}
