package proj2.ui;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


class HandPanel extends JPanel {

  // TODO: missing type arguments for generic class JList<E>
  // TODO: serializable class HandPanel has no definition of serialVersionUID
  public HandPanel(String name, JList hand, JButton stack, JButton deck, JButton lay, JButton layOnStack) {
    // model = hand.createSelectionModel();

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    // add(Box.createGlue());
    JLabel label = new JLabel(name);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    add(label);
    stack.setAlignmentX(Component.CENTER_ALIGNMENT);
    // add(Box.createGlue());
    add(stack);
    deck.setAlignmentX(Component.CENTER_ALIGNMENT);
    // add(Box.createGlue());
    add(deck);
    lay.setAlignmentX(Component.CENTER_ALIGNMENT);
    add(lay);
    layOnStack.setAlignmentX(Component.CENTER_ALIGNMENT);
    add(layOnStack);
    add(Box.createGlue());
    add(hand);
    add(Box.createGlue());
  }

}
