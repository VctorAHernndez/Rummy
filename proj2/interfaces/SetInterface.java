package proj2.interfaces;

import proj2.core.Card;
import proj2.interfaces.HandInterface;


public interface SetInterface {

  public void addCard(Card card);

  public boolean isFull();

  public int getRankIndex();

  public char getRank();

}
