package proj2.ui;

// import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import proj2.core.Card;
import proj2.core.Set;

/**
 * Graphic representation of Sets layed on the table.
 */
@SuppressWarnings("serial")
class SetPanel extends JPanel {

  // Class attributes
  // final private static String BLANK_IMAGE_FILENAME = "blank.gif";

  // Instance attributes
  final private Set data;
  final public JButton[] array = new JButton[Set.CAPACITY];

  /**
   * Graphic representation of Sets layed on the table.
   */
  public SetPanel(int index) {
    super();
    data = new Set(Card.RANKS[index]);

    for (int i = 0; i < array.length; i++) {
      array[i] = new JButton(" ");
      // array[i].setEnabled(false);
      // array[i].setIcon(new ImageIcon(Card.BLANK_IMAGE_FILEPATH));
      this.add(array[i]);
    }
  }

}
