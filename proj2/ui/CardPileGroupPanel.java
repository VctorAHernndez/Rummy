package proj2.ui;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import proj2.core.Card;


/**
 * Creates the images and labels of the Deck and stack.
 */
@SuppressWarnings("serial")
class CardPileGroupPanel extends JPanel {


  // Class attributes
  final private static String STACK_LABEL_TEXT = "Stack";
  final private static String DECK_LABEL_TEXT = "Deck";
  final private static String BLANK_IMAGE_FILENAME = "blank.gif";
  final private static String CARDBACK_IMAGE_FILENAME = "cardback.png";


  /**
  * Creates the images and labels of the Deck and stack.
  */
  public CardPileGroupPanel(JLabel stackGraphic, JLabel deckGraphic) {

    super();

    // Create container where the Deck and the Stack sit in the table
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.add(Box.createGlue());


    // Create a graphic UI component representing the stack
    JPanel stackGroup = new JPanel();
    stackGroup.setAlignmentY(Component.CENTER_ALIGNMENT);

    JLabel stackLabel = new JLabel(STACK_LABEL_TEXT);
    stackLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
    stackGroup.add(stackLabel);

    stackGraphic.setIcon(new ImageIcon(Card.IMAGE_DIR + BLANK_IMAGE_FILENAME));
    stackGraphic.setAlignmentY(Component.CENTER_ALIGNMENT);
    stackGroup.add(stackGraphic);

    this.add(stackGroup);
    this.add(Box.createGlue());


    // Create a graphic UI component representing the deck
    JPanel deckGroup = new JPanel();
    deckGroup.setAlignmentY(Component.CENTER_ALIGNMENT);

    JLabel deckLabel = new JLabel(DECK_LABEL_TEXT);
    deckLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
    deckGroup.add(deckLabel);

    deckGraphic.setIcon(new ImageIcon(Card.IMAGE_DIR + CARDBACK_IMAGE_FILENAME));
    deckGraphic.setAlignmentY(Component.CENTER_ALIGNMENT);
    deckGroup.add(deckGraphic);


    // Add both the Deck and the Stack to the container
    this.add(deckGroup);
    this.add(Box.createGlue());

  }


}
