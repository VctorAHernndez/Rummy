package proj2.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import proj2.core.Card;
import proj2.interfaces.HandInterface;


/**
 * Represents the basic functionality of a hand of cards.
 * Extensions of this class will provide the
 * definition of what constitutes a hand for that game and how hands are compared
 * to one another by overriding the <code>compareTo</code> method.
 */
public class Hand implements HandInterface, Comparable<Hand> {


  // Instance attributes
  // NOTE: NOT IN INTERFACE
  protected List<Card> hand = new ArrayList<Card>();


  /**
  * Adds a card to this hand.
  * @param card card to be added to the current hand.
  */
  public void addCard(Card card) {
    hand.add(card);
  }


  /**
  * Obtains the Card stored at the specified location in the hand.
  * Does not remove the Card from the hand.
  * @param index position of Card to be accessed.
  * @return the Card of interest, or null if not found.
  */
  public Card getCard(int index) {
    return hand.get(index);
  }


  /**
  * Removes the specified card from the current hand.
  * @param card the card to be removed.
  * @return the card removed from the hand, or null if not found.
  */
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
  public Card removeCard(int index) {
    return hand.remove(index);
  }


  /**
  * The number of cards held in the hand.
  * @return number of cards currently held in the hand.
  */
  public int getNumberOfCards() {
    return hand.size();
  }


  /**
  * Sorts the card in the hand.
  * Sort is performed according to the order specified in the {@link Card} class.
  */
  // TODO: T extends Comparable<? super T> declared in method <T>sort(List<T>)
  public void sort() {
    Collections.sort(hand);
  }


  /**
  * Checks to see if the hand is empty.
  * @return <code>true</code> is the hand is empty.
  */
  public boolean isEmpty() {
    return hand.isEmpty();
  }


  /**
  * Determines whether or not the hand contains the specified card.
  * @param card the card being searched for in the hand.
  * @return <code>true</code> if the card is present in the hand.
  */
  public boolean containsCard(Card card) {
    return false;
  }


  /**
  * Searches for the first instance of the specified card in the hand.
  * @param card card being searched for.
  * @return position index of card if found, or <code>-1</code> if not found.
  */
  public int findCard(Card card) {
    return hand.indexOf(card);
  }


  /**
  * Searches for the first instance of a set (3 or 4 Cards of the same rank) in the hand.
  * @return  returns Card [] of Cards found in deck or <code>null</code> if not found.
  */
  // TODO: implement
  public Card[] findSet() {
    return null;
  }


  /**
  * Evaluates a hand according to the rules of the card game.
  * Each card is worth its displayed pip value (ace = 1, two = 2, etc.)
  * in points with face cards worth ten points. The value of a hand
  * is equal to the summation of the points of all the cards held in the hand.
  * @return an integer corresponding to the rating of the hand.
  */
  // TODO: not sure we have to do this.....because we are just laying down the cards.....
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
  * @return a list of cards held in the hand.
  */
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
  public int compareTo(Hand otherHand) {
    return evaluateHand() - otherHand.evaluateHand();
  }


  /**
  * Replaces the specified card with another card. Only the first
  * instance of the targeted card is replaced. No action occurs if
  * the targeted card is not present in the hand.
  * @return <code>true</code> if the replacement occurs.
  */
  // NOTE: NOT IN INTERFACE
  public boolean replaceCard(Card oldCard, Card replacementCard) {
    int location = findCard(oldCard);

    if (location < 0) {
      return false;
    }

    hand.set(location, replacementCard);
    return true;
  }



  /**
  * Removes all the cards from the hand, leaving an empty hand.
  */
  // NOTE: NOT IN INTERFACE
  public void discardHand() {
    hand.clear();
  }


}
