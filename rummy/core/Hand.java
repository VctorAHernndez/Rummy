package rummy.core;

import javax.swing.DefaultListModel;

import rummy.interfaces.HandInterface;

import rummy.util.BubbleSort;

/**
 * Represents the basic functionality of a hand of cards. Extensions of this
 * class will provide the definition of what constitutes a hand for that game
 * and how hands are compared to one another by overriding the
 * <code>compareTo</code> method.
 */
public class Hand implements HandInterface, Comparable<Hand> {

  // Instance attributes
  // NOTE: NOT IN INTERFACE
  final private DefaultListModel<Card> hand;

  /**
   * Creates an empty hand of cards.
   */
  // NOTE: NOT IN INTERFACE
  public Hand() {
    hand = new DefaultListModel<Card>();
  }

  /**
   * Adds a card to this hand.
   * 
   * @param card card to be added to the current hand.
   */
  public void addCard(Card card) {
    hand.addElement(card);
    this.sort();
  }

  /**
   * Obtains the Card stored at the specified location in the hand. Does not
   * remove the Card from the hand.
   * 
   * @param index position of Card to be accessed.
   * @return the Card of interest, or null if not found.
   */
  public Card getCard(int index) {
    if (index < 0 || index >= getNumberOfCards()) {
      return null;
    }
    return hand.get(index);
  }

  /**
   * Removes the specified card from the current hand.
   * 
   * @param card the card to be removed.
   * @return the card removed from the hand, or null if not found.
   */
  public Card removeCard(Card card) {
    boolean removed = hand.removeElement(card);
    this.sort();
    return removed ? card : null;
  }

  /**
   * Removes the card at the specified index from the hand.
   * 
   * @param index position of the card to be removed.
   * @return the card removed from the hand, or null if not found.
   */
  // NOTE: Unused but the specifications dictate we need it.
  public Card removeCard(int index) {
    if (index < 0 || index >= getNumberOfCards()) {
      return null;
    }
    Card card = hand.remove(index);
    this.sort();
    return card;
  }

  /**
   * The number of cards held in the hand.
   * 
   * @return number of cards currently held in the hand.
   */
  public int getNumberOfCards() {
    return hand.size();
  }

  /**
   * Sorts the card in the hand. Sort is performed first by rank and then by suit.
   */
  // TODO: IMPROVEMENT, TRY USING COLLECTIONS.SORT INSTEAD OF CUSTOM CLASS
  public void sort() {

    // First, sort by Rank
    BubbleSort.sortByRank(hand);

    // Then, sort each Rank group by Suit
    DefaultListModel<Card> newHand = new DefaultListModel<Card>();

    for (int i = 0; i < hand.size(); i++) {

      Card groupLeader = hand.get(i);
      char groupRank = groupLeader.getRank();

      int j = i;
      DefaultListModel<Card> subhandOfSameRank = new DefaultListModel<Card>();

      while (j < hand.size() && hand.get(j).getRank() == groupRank) {
        subhandOfSameRank.addElement(hand.get(j));
        j += 1;
      }

      // Sort subhand by suit
      BubbleSort.sortBySuit(subhandOfSameRank);

      // Append subhand to newHand
      for (int k = 0; k < subhandOfSameRank.size(); k++) {
        newHand.addElement(subhandOfSameRank.get(k));
      }

      // Advance index to the next rank group
      i = j - 1;

    }

    // Set old hand equal to the sorted one
    hand.clear();
    for (int i = 0; i < newHand.size(); i++) {
      hand.addElement(newHand.get(i));
    }

  }

  /**
   * Checks to see if the hand is empty.
   * 
   * @return <code>true</code> is the hand is empty.
   */
  public boolean isEmpty() {
    return hand.isEmpty();
  }

  /**
   * Determines whether or not the hand contains the specified card.
   * 
   * @param card the card being searched for in the hand.
   * @return <code>true</code> if the card is present in the hand.
   */
  // NOTE: Unused but the specifications dictate we need it.
  public boolean containsCard(Card card) {
    return hand.contains(card);
  }

  /**
   * Searches for the first instance of the specified card in the hand.
   * 
   * @param card card being searched for.
   * @return position index of card if found, or <code>-1</code> if not found.
   */
  public int findCard(Card card) {
    return hand.indexOf(card);
  }

  /**
   * Searches for the first instance of a set (3 or 4 Cards of the same rank) in
   * the hand.
   * 
   * @return returns Card[] of Cards found in deck or <code>null</code> if not
   *         found.
   */
  // TODO: IMPROVEMENT, COULD SEARCH THE SET THAT WILL GRANT MORE POINTS
  public Card[] findSet() {

    if (hand.size() < Set.MIN_NUM_NECESSARY_TO_FORM_SET) {
      return null;
    }

    // Sort, just in case
    this.sort();

    // This assumes hand is sorted by rank (i.e. four consecutive aces, three
    // consecutives 2s, etc.)
    // TODO: IMPROVEMENT, can be micro-optimized a bit by manually setting i
    for (int i = 0; i < hand.size(); i++) {

      // Not enough cards to form a Set
      if (i + 2 >= hand.size()) {
        return null;
      }

      // NOTE: The add() method only adds cards of the same rank
      char rank = hand.get(i).getRank();
      Set set = new Set(rank);
      set.addCard(hand.get(i));
      set.addCard(hand.get(i + 1));
      set.addCard(hand.get(i + 2));

      if (i + 3 < hand.size()) {
        set.addCard(hand.get(i + 3));
      }

      if (set.isValid()) {
        return set.getCards();
      }

    }

    return null;

  }

  /**
   * Evaluates a hand according to the rules of the card game. Each card is worth
   * its displayed pip value (ace = 1, two = 2, etc.) in points with face cards
   * worth ten points. The value of a hand is equal to the summation of the points
   * of all the cards held in the hand.
   * 
   * @return an integer corresponding to the rating of the hand.
   */
  public int evaluateHand() {
    int value = 0;

    for (int i = 0; i < getNumberOfCards(); i++) {
      Card c = getCard(i);
      int cardValue = Card.getRankIndex(c.getRank()) - Card.getRankIndex('a') + 1;

      if (cardValue > 10) {
        cardValue = 10;
      }

      value += cardValue;
    }

    return value;
  }

  /**
   * Returns a description of the hand.
   * 
   * @return a list of cards held in the hand.
   */
  public String toString() {
    String handString = "";
    for (int i = 0; i < hand.size(); i++) {
      String cardString = hand.get(i).toString().toUpperCase();

      if (i != hand.size() - 1) {
        cardString = cardString.concat(", ");
      }

      handString = handString.concat(cardString);
    }
    return handString;
  }

  /**
   * Compares two hands.
   * 
   * @param otherHand the hand being compared.
   * @return < 0 if this hand is less than the other hand, 0 if the two hands are
   *         the same, or > 0 if this hand is greater then the other hand.
   */
  public int compareTo(Hand otherHand) {
    return this.evaluateHand() - otherHand.evaluateHand();
  }

  /**
   * Returns a reference to the internal Cards list.
   * 
   * @return reference to the list of cards in the hand.
   */
  // NOTE: NOT IN INTERFACE
  public DefaultListModel<Card> getHand() {
    return this.hand;
  }

  /**
   * Replaces the specified card with another card. Only the first instance of the
   * targeted card is replaced. No action occurs if the targeted card is not
   * present in the hand.
   * 
   * @return <code>true</code> if the replacement occurs.
   */
  // NOTE: NOT IN INTERFACE
  // TODO: Not used?
  // public boolean replaceCard(Card oldCard, Card replacementCard) {
  // int location = findCard(oldCard);

  // if (location < 0) {
  // return false;
  // }

  // hand.set(location, replacementCard);
  // return true;
  // }

  /**
   * Removes all the cards from the hand, leaving an empty hand.
   */
  // NOTE: NOT IN INTERFACE
  // TODO: Not used?
  // public void discardHand() {
  // hand.clear();
  // }

}
