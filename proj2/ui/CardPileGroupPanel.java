package proj2.ui;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import proj2.core.Card;


@SuppressWarnings("serial")
class CardPileGroupPanel extends JPanel {

  public CardPileGroupPanel(JLabel stackGraphic, JLabel deckGraphic) {
    super();

    // Create container where the Deck and the Stack sit in the table
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.add(Box.createGlue());


    // Create a graphic UI component representing the stack
    JPanel stackGroup = new JPanel();
    stackGroup.setAlignmentY(Component.CENTER_ALIGNMENT);

    JLabel stackLabel = new JLabel("Stack");
    stackLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
    stackGroup.add(stackLabel);

    stackGraphic.setIcon(new ImageIcon(Card.directory + "blank.gif"));
    stackGraphic.setAlignmentY(Component.CENTER_ALIGNMENT);
    stackGroup.add(stackGraphic);

    this.add(stackGroup);
    this.add(Box.createGlue());


    // Create a graphic UI component representing the deck
    JPanel deckGroup = new JPanel();
    deckGroup.setAlignmentY(Component.CENTER_ALIGNMENT);

    JLabel deckLabel = new JLabel("Deck");
    deckLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
    deckGroup.add(deckLabel);

    deckGraphic.setIcon(new ImageIcon(Card.directory + "b.gif"));
    deckGraphic.setAlignmentY(Component.CENTER_ALIGNMENT);
    deckGroup.add(deckGraphic);


    // Add both the Deck and the Stack to the container
    this.add(deckGroup);
    this.add(Box.createGlue());


  }

}