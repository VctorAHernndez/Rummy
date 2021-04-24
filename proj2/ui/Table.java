package proj2.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import proj2.core.Card;
import proj2.core.Deck;
import proj2.ui.HandPanel;
import proj2.ui.SetPanel;


/**
* This GUI assumes that you are using a 52 card deck and that you have 13 sets in the deck.
* The GUI is simulating a playing table
* @author Patti Ordonez
*/
public class Table extends JFrame implements ActionListener {


	// Class attributes
	final static int numDealtCards = 9;


	// Instance attributes
	JPanel player1;
	JPanel player2;
	JPanel deckPiles;
	JLabel deck;
	JLabel stack;
	JList p1HandPile;
	JList p2HandPile;
	Deck cardDeck;
	Deck stackDeck;

	SetPanel [] setPanels = new SetPanel[13];
	JLabel topOfStack;
	JLabel deckPile;
	JButton p1Stack;
	JButton p2Stack;

	JButton p1Deck;
	JButton p2Deck;

	JButton p1Lay;
	JButton p2Lay;

	JButton p1LayOnStack;
	JButton p2LayOnStack;

	DefaultListModel p1Hand;
	DefaultListModel p2Hand;


	public Table() {
		super("The Card Game of the Century");

		setLayout(new BorderLayout());
		setSize(1200,700);


		cardDeck = new Deck();

		for (int i = 0; i < Card.suit.length; i++) {
			for (int j = 0; j < Card.rank.length; j++) {
				Card card = new Card(Card.suit[i],Card.rank[j]);
				cardDeck.addCard(card);
			}
		}

		cardDeck.shuffle();
		stackDeck = new Deck();

		JPanel top = new JPanel();

		for (int i = 0; i < Card.rank.length;i++) {
			setPanels[i] = new SetPanel(Card.getRankIndex(Card.rank[i]));
		}


		top.add(setPanels[0]);
		top.add(setPanels[1]);
		top.add(setPanels[2]);
		top.add(setPanels[3]);

		player1 = new JPanel();

		player1.add(top);




		add(player1, BorderLayout.NORTH);
		JPanel bottom = new JPanel();


		bottom.add(setPanels[4]);
		bottom.add(setPanels[5]);
		bottom.add(setPanels[6]);
		bottom.add(setPanels[7]);
		bottom.add(setPanels[8]);

		player2 = new JPanel();




		player2.add(bottom);
		add(player2, BorderLayout.SOUTH);


		JPanel middle = new JPanel(new GridLayout(1,3));

		p1Stack = new JButton("Stack");
		p1Stack.addActionListener(this);
		p1Deck = new JButton("Deck ");
		p1Deck.addActionListener(this);
		p1Lay = new JButton("Lay  ");
		p1Lay.addActionListener(this);
		p1LayOnStack = new JButton("LayOnStack");
		p1LayOnStack.addActionListener(this);


		Card [] cardsPlayer1 = new Card[numDealtCards];
		deal(cardsPlayer1);
		p1Hand = new DefaultListModel();
		for (int i = 0; i < cardsPlayer1.length; i++) {
			p1Hand.addElement(cardsPlayer1[i]);
		}
		p1HandPile = new JList(p1Hand);


		middle.add(new HandPanel("Player 1", p1HandPile, p1Stack, p1Deck, p1Lay, p1LayOnStack));

		deckPiles = new JPanel();
		deckPiles.setLayout(new BoxLayout(deckPiles, BoxLayout.Y_AXIS));
		deckPiles.add(Box.createGlue());
		JPanel left = new JPanel();
		left.setAlignmentY(Component.CENTER_ALIGNMENT);


		stack = new JLabel("Stack");
		stack.setAlignmentY(Component.CENTER_ALIGNMENT);

		left.add(stack);
		topOfStack = new JLabel();
		topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
		topOfStack.setAlignmentY(Component.CENTER_ALIGNMENT);
		left.add(topOfStack);
		deckPiles.add(left);
		deckPiles.add(Box.createGlue());

		JPanel right = new JPanel();
		right.setAlignmentY(Component.CENTER_ALIGNMENT);

		deck = new JLabel("Deck");

		deck.setAlignmentY(Component.CENTER_ALIGNMENT);
		right.add(deck);
		deckPile = new JLabel();
		deckPile.setIcon(new ImageIcon(Card.directory + "b.gif"));
		deckPile.setAlignmentY(Component.CENTER_ALIGNMENT);
		right.add(deckPile);
		deckPiles.add(right);
		deckPiles.add(Box.createGlue());
		middle.add(deckPiles);


		p2Stack = new JButton("Stack");
		p2Stack.addActionListener(this);
		p2Deck = new JButton("Deck ");
		p2Deck.addActionListener(this);
		p2Lay = new JButton("Lay  ");
		p2Lay.addActionListener(this);
		p2LayOnStack = new JButton("LayOnStack");
		p2LayOnStack.addActionListener(this);

		Card [] cardsPlayer2 = new Card[numDealtCards];
		deal(cardsPlayer2);
		p2Hand = new DefaultListModel();

		for (int i = 0; i < cardsPlayer2.length; i++) {
			p2Hand.addElement(cardsPlayer2[i]);
		}

		p2HandPile = new JList(p2Hand);

		middle.add(new HandPanel("Player 2", p2HandPile, p2Stack, p2Deck, p2Lay, p2LayOnStack));

		add(middle, BorderLayout.CENTER);

		JPanel leftBorder = new JPanel(new GridLayout(2,1));


		setPanels[9].setLayout(new BoxLayout(setPanels[9], BoxLayout.Y_AXIS));
		setPanels[10].setLayout(new BoxLayout(setPanels[10], BoxLayout.Y_AXIS));
		leftBorder.add(setPanels[9]);
		leftBorder.add(setPanels[10]);
		add(leftBorder, BorderLayout.WEST);

		JPanel rightBorder = new JPanel(new GridLayout(2,1));

		setPanels[11].setLayout(new BoxLayout(setPanels[11], BoxLayout.Y_AXIS));
		setPanels[12].setLayout(new BoxLayout(setPanels[12], BoxLayout.Y_AXIS));
		rightBorder.add(setPanels[11]);
		rightBorder.add(setPanels[12]);
		add(rightBorder, BorderLayout.EAST);

	}



	private void deal(Card [] cards) {
		for(int i = 0; i < cards.length; i ++)
			cards[i] = (Card)cardDeck.dealCard();
	}


	private void layCard(Card card) {
		char rank = card.getRank();
		char suit = card.getSuit();
		int suitIndex = Card.getSuitIndex(suit);
		int rankIndex = Card.getRankIndex(rank);
		// setPanels[rankIndex].array[suitIndex].setText(card.toString());
		System.out.println("laying " + card);
		setPanels[rankIndex].array[suitIndex].setIcon(card.getCardImage());
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();


		if (p1Deck == src|| p2Deck == src) {

			Card card = cardDeck.dealCard();

			if (card != null) {
				if (src == p1Deck) {
					p1Hand.addElement(card);
				} else {
					p2Hand.addElement(card);
				}
			}

			if (cardDeck.getSizeOfDeck() == 0) {
				deckPile.setIcon(new ImageIcon(Card.directory + "blank.gif"));
			}

		}

		if (p1Stack == src || p2Stack == src) {

			Card card = stackDeck.removeCard();

			if (card != null) {
				Card topCard = stackDeck.peek();

				if (topCard != null) {
					topOfStack.setIcon(topCard.getCardImage());
				} else {
					topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
				}

				if (p1Stack == src) {
					p1Hand.addElement(card);
				} else {
					p2Hand.addElement(card);
				}

			}

		}

		if (p1Lay == src) {
			Object [] cards = p1HandPile.getSelectedValues();
			if (cards != null) {
				for (int i = 0; i < cards.length; i++) {
					Card card = (Card)cards[i];
					layCard(card);
					p1Hand.removeElement(card);
				}
			}
		}


		if (p2Lay == src) {
			Object [] cards = p2HandPile.getSelectedValues();
			if (cards != null) {
				for(int i = 0; i < cards.length; i++) {
					Card card = (Card)cards[i];
					layCard(card);
					p2Hand.removeElement(card);
				}
			}
		}


		if (p1LayOnStack == src) {
			int [] num  = p1HandPile.getSelectedIndices();

			if (num.length == 1) {
				Object obj = p1HandPile.getSelectedValue();
				if (obj != null) {
					p1Hand.removeElement(obj);
					Card card = (Card) obj;
					stackDeck.addCard(card);
					topOfStack.setIcon(card.getCardImage());
				}
			}
		}


		if (p2LayOnStack == src) {
			int [] num  = p2HandPile.getSelectedIndices();

			if (num.length == 1) {
				Object obj = p2HandPile.getSelectedValue();
				if (obj != null) {
					p2Hand.removeElement(obj);
					Card card = (Card)obj;
					stackDeck.addCard(card);
					topOfStack.setIcon(card.getCardImage());
				}
			}
		}

	}

}
