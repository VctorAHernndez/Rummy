package proj2.interfaces;

import proj2.core.Card;
import proj2.interfaces.HandInterface;


public interface SetInterface extends HandInterface {

  public boolean isFull();

  public int getRankIndex();

  public char getRank();

  /**
  * Ranks the cards in a set according to their suit
  */
  // TODO: wtf is this comment doing

}
