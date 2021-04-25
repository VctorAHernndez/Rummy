package proj2.ui;

// import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import proj2.core.Card;
import proj2.core.Set;


@SuppressWarnings("serial")
class SetPanel extends JPanel {

  private Set data;
  JButton [] array = new JButton[4];

  public SetPanel(int index) {
    super();
    data = new Set(Card.rank[index]);

    for (int i = 0; i < array.length; i++) {
      array[i] = new JButton("   ");
      // icons[i].setIcon(new ImageIcon(Card.directory + "blank.gif"));
      this.add(array[i]);
    }
  }

}
