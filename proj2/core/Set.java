package proj2.core;

import java.util.ArrayList;
import java.util.List;

import proj2.interfaces.SetInterface;

/**
 * Represents the basic functionality of a set of cards. Has a capacity of 4
 * (since there are only 4 ranks). Includes standard getters and the
 * functionality to add cards.
 */
public class Set implements SetInterface, Comparable<Set> {

  // Class attributes
  final public static int CAPACITY = 4;
  final public static int MIN_NUM_NECESSARY_TO_FORM_SET = 3;

  // Instance attributes
  // NOTE: NOT IN INTERFACE
  final private char rank;
  final private int rankIndex;
  protected List<Card> hand = new ArrayList<Card>();

  /**
   * Creates a set with a given rank.
   * 
   * @param rank the rank of the set.
   */
  // NOTE: NOT IN INTERFACE
  public Set(char rank) {
    super();
    rankIndex = Card.getRankIndex(rank);
    this.rank = rank;
  }

  /**
   * Checks if the list of cards given forms a set.
   * 
   * @param list the list of Cards that will be checked.
   * @return boolean representing wheter the given list is a set.
   */
  // NOTE: NOT IN INTERFACE
  public static boolean isSet(List<Card> list) {
    if (list.size() < MIN_NUM_NECESSARY_TO_FORM_SET || list.size() > CAPACITY) {
      return false;
    }

    Set set = new Set(list.get(0).getRank());
    for (int i = 1; i < list.size(); i++) {
      set.addCard(list.get(i));
    }

    return set.isValid();
  }

  /**
   * Returns if the set is valid or not (i.e. contains at least 3 cards and no
   * more than 4 cards).
   * 
   * @return boolean indicating whether set is valid or not.
   */
  // NOTE: NOT IN INTERFACE
  public boolean isValid() {
    boolean a = hand.size() < CAPACITY;
    boolean b = hand.size() >= MIN_NUM_NECESSARY_TO_FORM_SET;
    return a && b;
  }

  /**
   * Returns if the set is valid or not (i.e. contains at least 3 cards and no
   * more than 4 cards).
   * 
   * @return boolean indicating whether set is valid or not.
   */
  // NOTE: NOT IN INTERFACE
  public Card[] getCards() {
    Card[] arr = new Card[hand.size()];
    for (int i = 0; i < hand.size(); i++) {
      arr[i] = hand.get(i);
    }
    return arr;
  }

  /**
   * Adds a card to the Set (if the card is of the same rank as the rest of the
   * set).
   * 
   * @param card the Card to be added.
   */
  public void addCard(Card card) {
    if (rankIndex == Card.getRankIndex(card.getRank()) && !isFull()) {
      hand.add(card);
    }
  }

  /**
   * Determines whether Set contains all four cards.
   * 
   * @return true if Set is full; false otherwise.
   */
  public boolean isFull() {
    return hand.size() == CAPACITY;
  }

  /**
   * Returns the rankIndex of the set.
   * 
   * @return int corresponding to rank as defined in CardInterface.
   */
  // NOTE: Unused but the specifications dictate we need it.
  public int getRankIndex() {
    return rankIndex;
  }

  /**
   * Returns the rank of the set.
   * 
   * @return char returns char of rank as defined in CardInterface.
   */
  // NOTE: Unused but the specifications dictate we need it.
  public char getRank() {
    return rank;
  }

  /**
   * Obtains the card stored at the specified location in the hand. Does not
   * remove the card from the hand.
   * 
   * @param index position of card to be accessed.
   * @return the card of interest, or null if not found.
   */
  // TODO: Not used?
  // public Card getCard(int index) {
  // return hand.get(index);
  // }

  /**
   * Removes the specified card from the current hand.
   * 
   * @param card the card to be removed.
   * @return the card removed from the hand, or null not found.
   */
  // TODO: Not used?
  // public Card removeCard(Card card) {
  // int index = hand.indexOf(card);

  // if (index < 0) {
  // return null;
  // }

  // return hand.remove(index);
  // }

  /**
   * Removes the card at the specified index from the hand.
   * 
   * @param index position of the card to be removed.
   * @return the card removed from the hand, or null if not found.
   */
  // TODO: Not used?
  // public Card removeCard(int index) {
  // return hand.remove(index);
  // }

  /**
   * The number of cards held in the hand.
   * 
   * @return number of cards currently held in the hand.
   */
  // TODO: Not used?
  // public int getNumberOfCards() {
  // return hand.size();
  // }

  /**
   * Sorts the card in the hand. Sort is performed according to the order
   * specified in the {@link Card} class.
   */
  // TODO: Not used?
  // public void sort() {
  // Collections.sort(hand);
  // }

  /**
   * Checks to see if the hand is empty.
   * 
   * @return <code>true</code> is the hand is empty.
   */
  // TODO: Not used?
  // public boolean isEmpty() {
  // return hand.isEmpty();
  // }

  /**
   * Determines whether or not the hand contains the specified card.
   * 
   * @param card the card being searched for in the hand.
   * @return <code>true</code> if the card is present in the hand.
   */
  // TODO: Not used? should implement it if needed!
  // public boolean containsCard(Card card) {
  // return false;
  // }

  /**
   * Searches for the first instance of the specified card in the hand.
   * 
   * @param card card being searched for.
   * @return position index of card if found, or <code>-1</code> if not found.
   */
  // TODO: Not used?
  // public int findCard(Card card) {
  // return hand.indexOf(card);
  // }

  // TODO: Not used? should implement it if needed!
  // public Card[] findSet() {
  // return null;
  // }

  /**
   * Evaluates a hand according to the rules of the card game. Each card is worth
   * its displayed rank value (ace = 1, two = 2, etc.) in points with face cards
   * worth ten points. The value of a hand is equal to the summation of the points
   * of all the cards held in the hand.
   */
  // TODO: Not used? should validate if needed!
  // public int evaluateHand() {
  // int value = 0;

  // int cardValue = rankIndex - Card.getRankIndex('a') + 1;

  // if (cardValue > 10) {
  // cardValue = 10;
  // }

  // value = getNumberOfCards() * cardValue;

  // return value;
  // }

  /**
   * Returns a description of the hand.
   * 
   * @return a list of cards held in the hand.
   */
  // TODO: Not used?
  // public String toString() {
  // return hand.toString();
  // }

  /**
   * Compares two hands.
   * 
   * @param otherHand the hand being compared.
   * @return < 0 if this hand is less than the other hand, 0 if the two hands are
   *         the same, or > 0 if this hand is greater then the other hand.
   */
  // NOTE: Unused but the specifications dictate we need it.
  public int compareTo(Set otherSet) {
    return this.rankIndex - otherSet.rankIndex;
  }

}
