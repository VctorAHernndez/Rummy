package proj2.interfaces;

import proj2.core.Card;

public interface HandInterface {

  public void addCard(Card card);

  public Card getCard(int index);

  public Card removeCard(Card card);

  public Card removeCard(int index);

  public int getNumberOfCards();

  public void sort();

  public boolean isEmpty();

  public boolean containsCard(Card card);

  public int findCard(Card card);

  public Card[] findSet();

  public int evaluateHand();

  public String toString();

}
