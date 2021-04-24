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
import proj2.core.Hand;
import proj2.ui.HandPanel;
import proj2.ui.SetPanel;


/**
* This GUI assumes that you are using a 52 card deck and that you have 13 sets in the deck.
* The GUI is simulating a playing table
* @author Víctor A. Hernández Castro
*/
public class Table extends JFrame implements ActionListener {


	// Class attributes
	final private static int NUM_DEALT_CARDS = 9;
	final private static int NUM_SETS = 13;


	// GUI Components
	JPanel player1;
	JPanel player2;
	JPanel deckPiles;
	JLabel deck;
	JLabel stack;
	JList p1HandPile;
	JList p2HandPile;

	SetPanel [] setPanels = new SetPanel[NUM_SETS];
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


	// Data Models
	Deck cardDeck;
	Deck stackDeck;

	// TODO: CHANGE TO HAND LIKE HECTOR DID?
	Hand p1Hand;
	Hand p2Hand;

	// TODO: figure what this is for hector
	// int playerturn = 0;
	// int playerlayStack = 0;
	// int playerlay = 0;


	public Table() {


		// Setup Table Layout
		super("The Card Game of the Century");
		setLayout(new BorderLayout());
		setSize(1200,700);


		// Create Deck with its 52 cards and shuffle it
		cardDeck = new Deck();
		for (int i = 0; i < Card.suit.length; i++) {
			for (int j = 0; j < Card.rank.length; j++) {
				Card card = new Card(Card.suit[i], Card.rank[j]);
				cardDeck.addCard(card);
			}
		}

		cardDeck.shuffle();


		// Create Stack Deck for later
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


		Card[] cardsPlayer1 = new Card[NUM_DEALT_CARDS];
		deal(cardsPlayer1);
		p1Hand = new Hand();
		for (int i = 0; i < cardsPlayer1.length; i++) {
			p1Hand.addCard(cardsPlayer1[i]);
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

		Card [] cardsPlayer2 = new Card[NUM_DEALT_CARDS];
		deal(cardsPlayer2);
		p2Hand = new Hand();

		for (int i = 0; i < cardsPlayer2.length; i++) {
			p2Hand.addCard(cardsPlayer2[i]);
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



	private void deal(Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = cardDeck.dealCard();
		}
	}


	private void layCardOnTable(Card card) {
		char rank = card.getRank();
		char suit = card.getSuit();
		int suitIndex = Card.getSuitIndex(suit);
		int rankIndex = Card.getRankIndex(rank);
		System.out.println("Laying " + card);
		// setPanels[rankIndex].array[suitIndex].setText(card.toString());
		setPanels[rankIndex].array[suitIndex].setIcon(card.getCardImage());
	}


	private void announceWinner() {
		int p1MinusP2 = p1Hand.compareTo(p2Hand);

		if (p1MinusP2 > 0) {
			System.out.println("Player 1 Wins!!!");
		} else if (p1MinusP2 == 0) {
			System.out.println("Tie!");
		} else {
			System.out.println("Player 2 Wins!!!");
		}
	}


	private void handleP1ClickedOnDeck() {

		// TODO: pass turn
		Card card = cardDeck.dealCard();

		// TODO: sort after adding card
		// TODO: only add card for relevant player
		if (card != null) {
			p1Hand.addCard(card);
		}

		
		// Game Over
		if (cardDeck.isEmpty()) {
			deckPile.setIcon(new ImageIcon(Card.directory + "blank.gif"));
			announceWinner();
		}
	}


	private void handleP1ClickedOnStack() {

 		// TODO: debería quitar carta en el top del stack?
		Card card = stackDeck.removeCard();

		if (card != null) {

			// TODO: pass turn

			Card topCard = stackDeck.peek();

			// First change the image in the stack
			if (topCard != null) {
				topOfStack.setIcon(topCard.getCardImage());
			} else {
				topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
			}

			// Then add the removed card to the player's hand
			// TODO: sort after adding
			// TODO: only add card for relevant player	
			p1Hand.addCard(card);

		}
	}


	// TODO: THIS LAYS SETS!!!!
	private void handleP1ClickedOnLay() {
		
 		// TODO: findSet instead?
 		// TODO: only do it for relevant player
		Object [] cards = p1HandPile.getSelectedValues();

		if (cards != null) {
			for (int i = 0; i < cards.length; i++) {
				Card card = (Card) cards[i];
				layCardOnTable(card);
				// TODO: only do it for relevant player
				p1Hand.removeCard(card);
			}
		}


		// Check if player's hand is empty
		// TODO: only do it for relevant player
		if (p1Hand.isEmpty()) {
			// TODO: check if we need to change an image or text when player's hand is empty
			announceWinner();
		}


		// TODO: figure out if this is actually necessary
		// if (cardDeck.isEmpty()) {
			// announceWinner();
		// }
	}


	private void handleP1ClickedOnLayOnStack() {

		// TODO: advance some sort of flag that lets you know user can do this move?

		
		// TODO: only do it for relevant player
		int[] num  = p1HandPile.getSelectedIndices();

		// Only permit laying a single card at a time?
		if (num.length == 1) {

			// Move card from hand to the top of the stack
			// TODO: only do it for relevant player
			Card card = p1HandPile.getSelectedValue();
			if (card != null) {
				// TODO: only do it for relevant player
				p1Hand.removeCard(card);
				stackDeck.addCard(card);
				topOfStack.setIcon(card.getCardImage());
			}

			// TODO: only do it for relevant player
			if (p1Hand.isEmpty()) {
				// TODO: check if we need to change an image or text when player's hand is empty
				announceWinner();
			}


			// OTHER PLAYER'S TURN??????????
			// TODO: pass turn
			// TODO: advance otherflag
			
			// handleP2ClickedOnDeck();
			// handleP2ClickedOnLay();
			// TODO: MAKE CPU DISCARD A RANDOM CARD TO END TURN
		}
	}


	public void actionPerformed(ActionEvent e) {

		// Get event source
		Object src = e.getSource();


		// TODO: check that it was P1's turn
		// TODO: duplicate logic for P2's case
		if (p1Deck == src || p2Deck == src) {
			handleP1ClickedOnDeck();
		}


		// TODO: check that it was P1's turn
		// TODO: duplicate logic for P2's case
		if (p1Stack == src || p2Stack == src) {
			handleP1ClickedOnStack();
		}


		// TODO: check that it was P1's turn
		// TODO: duplicate logic for P2's case
		if (p1Lay == src) {
			handleP1ClickedOnLay();
		}


		// TODO: check that it was P1's turn
		// TODO: duplicate logic for P2's case
		if (p1LayOnStack == src) {
			handleP1ClickedOnLayOnStack();
		}

	}

}
