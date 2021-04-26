package proj2.interfaces;

import proj2.core.Card;

public interface SetInterface {

  public void addCard(Card card);

  public boolean isFull();

  public int getRankIndex();

  public char getRank();

}
