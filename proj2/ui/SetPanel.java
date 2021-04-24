package proj2.ui;

import javax.swing.JButton;
import javax.swing.JPanel;

import proj2.core.Card;
import proj2.core.Set;


class SetPanel extends JPanel {
	private Set data;
	JButton [] array = new JButton[4];

	// TODO: serializable class SetPanel has no definition of serialVersionUID
	public SetPanel(int index) {
		super();
		data = new Set(Card.rank[index]);

		for (int i = 0; i < array.length; i++) {
			array[i] = new JButton("   ");
			add(array[i]);
		}
	}

}
