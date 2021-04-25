package proj2.ui;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import proj2.core.Card;


@SuppressWarnings("serial")
class PlayerControlPanel extends JPanel {

  public PlayerControlPanel(String name, JList<Card> hand, JButton drawFromStack, JButton drawFromDeck, JButton layOnTableButton, JButton discardButton) {

    // model = hand.createSelectionModel();
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    // add(Box.createGlue());

    JLabel label = new JLabel(name);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(label);

    drawFromStack.setAlignmentX(Component.CENTER_ALIGNMENT);
    // add(Box.createGlue());
    this.add(drawFromStack);

    drawFromDeck.setAlignmentX(Component.CENTER_ALIGNMENT);
    // add(Box.createGlue());
    this.add(drawFromDeck);

    layOnTableButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(layOnTableButton);

    discardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(discardButton);
    this.add(Box.createGlue());

    this.add(hand);
    this.add(Box.createGlue());

  }

}
