package proj2.core;

import java.util.Collections;
import java.util.LinkedList;

import proj2.core.Card;
import proj2.interfaces.DeckInterface;


// TODO: javadoc for this class
public class Deck implements DeckInterface {


  // Instance attributes
  // NOTE: NOT IN INTERFACE
  final private LinkedList<Card> deck;


  /**
  * Creates an empty deck of cards.
  */
  // NOTE: NOT IN INTERFACE
  public Deck() {
    deck = new LinkedList<Card>();
  }


  /**
  * Returns next Card in the deck (which is facing down).
  * @return a Card representing the next card in the deck.
  */
  public Card peek() {
    return isEmpty() ? null : deck.getLast();
  }


  /**
  * Adds a Card to the deck.
  * @param card Card to be added.
  */
  public void addCard(Card card) {
    deck.add(card);
  }


  /**
  * Returns the number of Cards on the deck.
  * @return int representing the number of cards on the deck.
  */
  // NOTE: Unused because only used for comparing against 0
  //       but the specifications dictate we need it.
  public int getSizeOfDeck() {
    return deck.size();
  }


  /**
  * Returns the next card in the deck and removes it.
  * @return a Card representing the next card in the deck.
  */
  public Card dealCard() {
    // TODO: shouldn't it be removeLast()?
    return isEmpty() ? null : deck.removeFirst();
  }


  /**
  * Returns the last card in the deck and removes it.
  * @return a Card representing the last card in the deck.
  */
  public Card removeCard() {
    // TODO: checkin with dealCard()
    return isEmpty() ? null : deck.removeLast();
  }


  /**
  * Shuffles the cards in the deck.
  */
  public void shuffle() {
    Collections.shuffle(deck);
  }


  /**
  * Returns true if deck is empty; false otherwise.
  * @return boolean which indicates whether deck is empty or not.
  */
  public boolean isEmpty() {
    return deck.isEmpty();
  }


  /**
  * Restores the deck to "full deck" state (i.e. empty and ready to receive cards).
  */
  public void restoreDeck() {
    deck.removeAll(deck); // TODO: not sure if kosher
  }


}
