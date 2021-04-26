package proj2.util;

import javax.swing.DefaultListModel;

import proj2.core.Card;


/**
 * Bubble sort implemented because Collections.sort() does not work with DefaulListModels :(
 */
public class BubbleSort {
  public static void sort(DefaultListModel<Card> array) {
    boolean sorted = false;
    Card temp;
    while(!sorted) {
      sorted = true;
      for (int i = 0; i < array.size() - 1; i++) {
        if (array.get(i).compareTo(array.get(i + 1)) > 0) {
          temp = array.get(i);
          array.set(i, array.get(i+1));
          array.set(i+1, temp);
          sorted = false;
        }
      }
    }
  }
}
