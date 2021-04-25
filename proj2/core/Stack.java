package proj2.core;

import proj2.core.Card;

import proj2.util.MyStack;


/**
 * Represents the basic functionality of a stack of cards,
 * including adding and removing cards. The stack is empty at first.
 */
public class Stack extends MyStack<Card> {


  // Class attributes
  final public static int CAPACITY = 52;


  /**
  * Constructs an empty stack with a capacity of 52 cards
  */
  public Stack() {
    super(CAPACITY);
  }


  /**
  * Adds a Card to the top of stack.
  * @param card the Card to be added to the top of the stack.
  */
  public void addCard(Card card) {
    this.push(card);
  }


  /**
  * Returns the card at the top of stack and removes it.
  * @return a Card representing the card at the top of the stack.
  */
  public Card removeCard() {
    return this.pop();
  }


}
