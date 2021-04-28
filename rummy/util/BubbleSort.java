package rummy.util;

import javax.swing.DefaultListModel;

import rummy.core.Card;

/**
 * Bubble sort implemented because Collections.sort() does not work with
 * DefaulListModels :(
 */
public class BubbleSort {
  public static void sortByRank(DefaultListModel<Card> array) {
    boolean sorted = false;
    Card temp;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < array.size() - 1; i++) {
        if (array.get(i).compareTo(array.get(i + 1)) > 0) {
          temp = array.get(i);
          array.set(i, array.get(i + 1));
          array.set(i + 1, temp);
          sorted = false;
        }
      }
    }
  }

  public static void sortBySuit(DefaultListModel<Card> array) {
    boolean sorted = false;
    Card temp;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < array.size() - 1; i++) {
        char firstSuit = array.get(i).getSuit();
        char secondSuit = array.get(i + 1).getSuit();
        if (Card.getSuitIndex(firstSuit) > Card.getSuitIndex(secondSuit)) {
          temp = array.get(i);
          array.set(i, array.get(i + 1));
          array.set(i + 1, temp);
          sorted = false;
        }
      }
    }
  }
}
