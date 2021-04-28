package rummy.ui;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import rummy.core.Card;

/**
 * Creates a player's controls, including Draw, Discard and Lay buttons.
 */
@SuppressWarnings("serial")
class PlayerControlPanel extends JPanel {

  /**
   * Creates a player's controls, including Draw, Discard and Lay buttons.
   */
  public PlayerControlPanel(String name, JList<Card> hand, JButton drawFromStack, JButton drawFromDeck,
      JButton layOnTableButton, JButton discardButton) {

    // model = hand.createSelectionModel();
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    // add(Box.createGlue());

    JLabel label = new JLabel(name);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(label);

    drawFromDeck.setAlignmentX(Component.CENTER_ALIGNMENT);
    // add(Box.createGlue());
    this.add(drawFromDeck);

    drawFromStack.setAlignmentX(Component.CENTER_ALIGNMENT);
    // add(Box.createGlue());
    this.add(drawFromStack);

    layOnTableButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(layOnTableButton);

    discardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(discardButton);
    this.add(Box.createGlue());

    this.add(hand);
    this.add(Box.createGlue());

  }

}
