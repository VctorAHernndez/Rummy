package rummy.core;

import java.util.ArrayList;
import java.util.List;

import rummy.interfaces.SetInterface;

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
    this.rankIndex = Card.getRankIndex(rank);
    this.rank = rank;
  }

  /**
   * Creates a set with the given List<Card>
   * 
   * @param cards list of cards to be used
   */
  public Set(List<Card> cards) {
    super();
    Card firstCard = cards.get(0);
    this.rankIndex = Card.getRankIndex(firstCard.getRank());
    this.rank = firstCard.getRank();

    for (int i = 0; i < cards.size(); i++) {
      addCard(cards.get(i));
    }
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

    Card firstCard = list.get(0);
    Set set = new Set(firstCard.getRank());

    for (int i = 0; i < list.size(); i++) {
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
    boolean above = hand.size() <= CAPACITY;
    boolean below = hand.size() >= MIN_NUM_NECESSARY_TO_FORM_SET;
    return above && below;
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
  public char getRank() {
    return rank;
  }

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
