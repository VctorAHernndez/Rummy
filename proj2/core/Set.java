package proj2.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import proj2.core.Card;
import proj2.interfaces.SetInterface;


// TODO: inherit from MyStack for some reason
// TODO: javadoc
public class Set implements SetInterface, Comparable<Set> {


  // Class attributes
  final public static int CAPACITY = 4;


  // Instance attributes
  // NOTE: NOT IN INTERFACE
  final private char rank;
  final private int rankIndex;
  protected List<Card> hand = new ArrayList<Card>();


  /**
  * Creates a set with a given rank.
  * @param rank the rank of the set.
  */
  // NOTE: NOT IN INTERFACE
  public Set(char rank) {
    super(); // TODO: Héctor le pone size 52
    rankIndex = Card.getRankIndex(rank);
    this.rank = rank;
  }


  /**
  * Determines whether Set contains all four cards.
  * @return true if Set is full; false otherwise.
  */
  public boolean isFull() {
    return hand.size() == CAPACITY;
  }


  /**
  * Returns the rankIndex of the set.
  * @return int corresponding to rank as defined in CardInterface.
  */
  public int getRankIndex() {
    return rankIndex;
  }


  /**
  * Returns the rank of the set.
  * @return char returns char of rank as defined in CardInterface.
  */
  public char getRank() {
    return rank;
  }


  /**
  * Adds a card to the Set (if the card is of the same rank as the rest of the set).
  * @param card the Card to be added.
  */
  // TODO: if set is full then no more Card may be added to the set
  public void addCard(Card card) {
    if (rankIndex == Card.getRankIndex(card.getRank()) && !isFull()) {
      hand.add(card);
    }
  }


  /**
  * Obtains the card stored at the specified location in the hand. 
  * Does not remove the card from the hand.
  * @param index position of card to be accessed.
  * @return the card of interest, or null if not found.
  */
  // TODO: Not used?
  public Card getCard(int index) {
    return hand.get(index);
  }


  /**
  * Removes the specified card from the current hand.
  * @param card the card to be removed.
  * @return the card removed from the hand, or null not found.
  */
  // TODO: Not used?
  public Card removeCard(Card card) {
    int index = hand.indexOf(card);

    if (index < 0) {
      return null;
    }

    return hand.remove(index);
  }


  /**
  * Removes the card at the specified index from the hand.
  * @param index position of the card to be removed.
  * @return the card removed from the hand, or null if not found.
  */
  // TODO: Not used?
  public Card removeCard(int index) {
    return hand.remove(index);
  }


  /**
  * The number of cards held in the hand.
  * @return number of cards currently held in the hand.
  */
  // TODO: Not used?
  public int getNumberOfCards() {
    return hand.size();
  }


  /**
  * Sorts the card in the hand.
  * Sort is performed according to the order specified in the {@link Card} class.
  */
  // TODO: Not used?
  public void sort() {
    Collections.sort(hand);
  }


  /**
  * Checks to see if the hand is empty.
  * @return <code>true</code> is the hand is empty.
  */
  // TODO: Not used?
  public boolean isEmpty() {
    return hand.isEmpty();
  }


  /**
  * Determines whether or not the hand contains the specified card.
  * @param card the card being searched for in the hand.
  * @return <code>true</code> if the card is present in the hand.
  */
  // TODO: Not used?
  public boolean containsCard(Card card) {
    // TODO: implement this
    return false;
  }


  /**
  * Searches for the first instance of the specified card in the hand.
  * @param card card being searched for.
  * @return position index of card if found, or <code>-1</code> if not found.
  */
  // TODO: Not used?
  public int findCard(Card card) {
    return hand.indexOf(card);
  }


  // TODO: implement this
  // TODO: Not used?
  public Card[] findSet() {
    return null;
  }


  /**
  * Evaluates a hand according to the rules of the card game.
  * Each card is worth its displayed rank value (ace = 1, two = 2, etc.)
  * in points with face cards worth ten points.  The value of a hand
  * is equal to the summation of the points of all the cards held in
  * the hand.
  */
  // TODO: is this done right?
  // TODO: Not used?
  public int evaluateHand() {
    int value = 0;

    int cardValue = rankIndex - Card.getRankIndex('a') + 1;

    if (cardValue > 10) {
      cardValue = 10;
    }

    value = getNumberOfCards() * cardValue;

    return value;
  }


  /**
  * Returns a description of the hand.
  * @return a list of cards held in the hand.
  */
  // TODO: Not used?
  public String toString() {
    return hand.toString();
  }


  /**
  *  Compares two hands.
  *  @param otherHand the hand being compared.
  *  @return < 0 if this hand is less than the other hand, 0 if the two hands are
  *  the same, or > 0 if this hand is greater then the other hand.
  */
  // NOTE: NOT IN INTERFACE
  // TODO: Not used?
  public int compareTo(Set otherSet) {
    return this.rankIndex - otherSet.rankIndex;
  }


}
