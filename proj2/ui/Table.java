package proj2.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

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
import proj2.core.Stack;

import proj2.ui.CardPileGroupPanel;
import proj2.ui.PlayerControlPanel;
import proj2.ui.SetPanel;


/**
* This GUI assumes that you are using a 52 card deck and that you have 13 sets in the deck.
* The GUI is simulating a playing table
* @author Víctor A. Hernández Castro
*/
@SuppressWarnings("serial")
public class Table extends JFrame implements ActionListener {


	// Class attributes
	final private static int TABLE_WIDTH = 1200;
	final private static int TABLE_HEIGHT = 700;
	final private static int NUM_CARDS_IN_DECK = 52;
	final private static int NUM_SETS = 13;
	final private static int NUM_DEALT_CARDS = 9;
	final private static String WINDOW_TITLE_TEXT = "The Card Game of the Century";
	final private static String DRAW_FROM_STACK_BUTTON_TEXT = "Draw from Stack";
	final private static String DRAW_FROM_DECK_BUTTON_TEXT = "Draw from Deck";
	final private static String LAY_ON_TABLE_BUTTON_TEXT = "Lay on Table";
	final private static String DISCARD_BUTTON_TEXT = "Discard";
	final private static String BLANK_IMAGE_FILENAME = "blank.gif";


	// Data Models
	final private Deck cardDeck = new Deck(); // creates a shuffled deck of 52 cards
	final private Stack stackDeck = new Stack(); // creates an empty stack

	final private Hand p1Hand = new Hand();
	final private Hand p2Hand = new Hand();


	// Game flags
	private boolean p1Turn = true;
	private boolean currentPlayerHasDrawn = false;
	private boolean p2IsCPU = true;


	// GUI Component References
	final private SetPanel[] setPanels = new SetPanel[NUM_SETS];

	final public JLabel stackGraphic = new JLabel();
	final public JLabel deckGraphic = new JLabel();

	final public JButton p1DrawFromStackButton = new JButton(DRAW_FROM_STACK_BUTTON_TEXT);
	final public JButton p2DrawFromStackButton = new JButton(DRAW_FROM_STACK_BUTTON_TEXT);

	final public JButton p1DrawFromDeckButton = new JButton(DRAW_FROM_DECK_BUTTON_TEXT);
	final public JButton p2DrawFromDeckButton = new JButton(DRAW_FROM_DECK_BUTTON_TEXT);

	final public JButton p1LayOnTableButton = new JButton(LAY_ON_TABLE_BUTTON_TEXT);
	final public JButton p2LayOnTableButton = new JButton(LAY_ON_TABLE_BUTTON_TEXT);

	final public JButton p1DiscardButton = new JButton(DISCARD_BUTTON_TEXT);
	final public JButton p2DiscardButton = new JButton(DISCARD_BUTTON_TEXT);

	public JList<Card> p1HandPile = new JList<Card>(p1Hand.getHand());
	public JList<Card> p2HandPile = new JList<Card>(p2Hand.getHand());


	/**
	* Constructs the table where the Rummy game will take place.
	* Takes care of the UI and the logic as well.
	*/
	public Table() {


		// Setup Table Layout
		super(WINDOW_TITLE_TEXT);
		setLayout(new BorderLayout());
		setSize(TABLE_WIDTH, TABLE_HEIGHT);


		// Create all the Set UI components in the table
		this.createSetPanelsInTable();


		// Initialize all the interactive components for both players
		this.preparePlayerControls();


		// Prepare each players' hands
		this.dealCardsToPlayers();


		// Initialize the center section of the table
		JPanel centerSection = new JPanel(new GridLayout(1, 3));


		// Add Player 1's controls to the leftmost part of the table's middle section
		centerSection.add(new PlayerControlPanel("Player 1", p1HandPile, p1DrawFromStackButton, p1DrawFromDeckButton, p1LayOnTableButton, p1DiscardButton));


		// Add the Deck and Stack images to the center of the middle section
		centerSection.add(new CardPileGroupPanel(stackGraphic, deckGraphic));


		// Add Player 2's controls to the rightmost part of the table's middle section
		centerSection.add(new PlayerControlPanel("Player 2", p2HandPile, p2DrawFromStackButton, p2DrawFromDeckButton, p2LayOnTableButton, p2DiscardButton));


		// Add middle section to the actual global center
		this.add(centerSection, BorderLayout.CENTER);


		// TODO: after dealing to both players, the next card should be turned face-up to initiate the discard pile (Stack)
		// TODO IMPROVEMENT: terminate program after hitting closing window


	}


	/**
	* Creates slots in the Table where the players can lay their sets.
	*/
	public void createSetPanelsInTable() {

		// Instantiate the 13 set piles in the UI
		for (int i = 0; i < Card.rank.length; i++) {
			setPanels[i] = new SetPanel(Card.getRankIndex(Card.rank[i]));
		}


		// Add 4 set piles in the UI at the top
		JPanel topPanels = new JPanel();
		topPanels.add(setPanels[0]);
		topPanels.add(setPanels[1]);
		topPanels.add(setPanels[2]);
		topPanels.add(setPanels[3]);

		JPanel northSection = new JPanel();
		northSection.add(topPanels);
		this.add(northSection, BorderLayout.NORTH);


		// Add 5 set piles in the UI at the bottom
		JPanel bottomPanels = new JPanel();
		bottomPanels.add(setPanels[4]);
		bottomPanels.add(setPanels[5]);
		bottomPanels.add(setPanels[6]);
		bottomPanels.add(setPanels[7]);
		bottomPanels.add(setPanels[8]);

		JPanel southSection = new JPanel();
		southSection.add(bottomPanels);
		this.add(southSection, BorderLayout.SOUTH);


		// Add 2 set piles in the UI at the left
		JPanel westSection = new JPanel(new GridLayout(2, 1));
		setPanels[9].setLayout(new BoxLayout(setPanels[9], BoxLayout.Y_AXIS));
		setPanels[10].setLayout(new BoxLayout(setPanels[10], BoxLayout.Y_AXIS));
		westSection.add(setPanels[9]);
		westSection.add(setPanels[10]);
		this.add(westSection, BorderLayout.WEST);


		// Add 2 set piles in the UI at the right
		JPanel eastSection = new JPanel(new GridLayout(2, 1));
		setPanels[11].setLayout(new BoxLayout(setPanels[11], BoxLayout.Y_AXIS));
		setPanels[12].setLayout(new BoxLayout(setPanels[12], BoxLayout.Y_AXIS));
		eastSection.add(setPanels[11]);
		eastSection.add(setPanels[12]);
		this.add(eastSection, BorderLayout.EAST);

	}


	/**
	* Registers the buttons in the UI to enable user interaction.
	*/
	public void preparePlayerControls() {

		// Create Player 1's interactive buttons
		p1DrawFromDeckButton.addActionListener(this);
		p1DrawFromStackButton.addActionListener(this);
		p1DrawFromStackButton.setEnabled(false); // stack is initially empty
		p1LayOnTableButton.addActionListener(this);
		p1LayOnTableButton.setEnabled(false);
		p1DiscardButton.addActionListener(this);
		p1DiscardButton.setEnabled(false);


		// Create Player 2's interactive buttons
		p2DrawFromDeckButton.addActionListener(this);
		p2DrawFromDeckButton.setEnabled(false);
		p2DrawFromStackButton.addActionListener(this);
		p2DrawFromStackButton.setEnabled(false);
		p2LayOnTableButton.addActionListener(this);
		p2LayOnTableButton.setEnabled(false);
		p2DiscardButton.addActionListener(this);
		p2DiscardButton.setEnabled(false);

	}


	/**
	* Deals 9 cards to each player.
	*/
	private void dealCardsToPlayers() {

		// Create Player 1's hand of 9 cards
		for (int i = 0; i < NUM_DEALT_CARDS; i++) {
			Card c = cardDeck.dealCard();
			p1Hand.addCard(c);
		}

		// Create Player 2's hand of 9 cards
		for (int i = 0; i < NUM_DEALT_CARDS; i++) {
			Card c = cardDeck.dealCard();
			p2Hand.addCard(c);
		}

	}


	/**
	* Handles logic to lay a single card on the table.
	* @param card the Card that will be laid on the table.
	*/
	private void layCardOnTable(Card card) {
		char rank = card.getRank();
		char suit = card.getSuit();
		int suitIndex = Card.getSuitIndex(suit);
		int rankIndex = Card.getRankIndex(rank);
		System.out.println("Laying " + card);
		// setPanels[rankIndex].array[suitIndex].setText(card.toString());
		setPanels[rankIndex].array[suitIndex].setIcon(card.getCardImage());
	}


	/**
	* Announces through standard output who the winner is.
	*/
	private void announceWinner() {
		int p1MinusP2 = p1Hand.compareTo(p2Hand);

		if (p1MinusP2 > 0) {
			System.out.println("Player 1 Wins!");
		} else if (p1MinusP2 == 0) {
			System.out.println("It's a tie!");
		} else {
			System.out.println("Player 2 Wins!");
		}
	}


	/**
	* Handles user clicking on "Draw from Deck" button.
	* @param playersHand the Hand of the player who clicked on the button.
	*/
	private void handleDrawFromDeck(Hand playersHand) {

		Card card = cardDeck.dealCard();

		// Add card to hand
		if (card != null) {
			playersHand.addCard(card);
		}
		
		// Game Over
		if (cardDeck.isEmpty()) {
			deckGraphic.setIcon(new ImageIcon(Card.directory + BLANK_IMAGE_FILENAME));
			announceWinner();
		}

	}


	/**
	* Handles user clicking on "Draw from Stack" button.
	* @param playersHand the Hand of the player who clicked on the button.
	*/
	private void handleDrawFromStack(Hand playersHand) {

		Card card = stackDeck.removeCard();

		if (card != null) {

			Card topCard = stackDeck.peek();

			// First change the image in the stack
			if (topCard != null) {
				stackGraphic.setIcon(topCard.getCardImage());
			} else {
				stackGraphic.setIcon(new ImageIcon(Card.directory + BLANK_IMAGE_FILENAME));
			}

			// Then add the removed card to the player's hand
			playersHand.addCard(card);

		}
	}


	/**
	* Handles user clicking on "Lay on Table" button.
	* @param playersHand the Hand of the player who clicked on the button.
	* @param playersHandPile the UI representation of the player's hand.
	*/
	// TODO CRITICAL: THIS SHOULD LAY SETS IN THE TABLE
	// TODO IMPROVEMENT: THIS SHOULD LAY RUNS IN THE TABLE
	// TODO IMPROVEMENT: THIS SHOULD LAY CARDS THAT FIT IN SETS OR RUNS ALREADY ON THE TABLE
	private void handleLayOnTable(Hand playersHand, JList<Card> playersHandPile) {
		
 		// TODO CRITICAL: findSet instead?
		List<Card> selectedCards = playersHandPile.getSelectedValuesList();

		if (selectedCards != null) {
			for (int i = 0; i < selectedCards.size(); i++) {
				Card card = selectedCards.get(i);
				layCardOnTable(card);
				playersHand.removeCard(card);
			}
		}


		// Check if player's hand is empty
		if (playersHand.isEmpty()) {
			announceWinner();
		}

	}


	/**
	* Handles user clicking on "Discard" button.
	* @param playersHand the Hand of the player who clicked on the button.
	* @param playersHandPile the UI representation of the player's hand.
	*/
	private void handleDiscard(Hand playersHand, JList<Card> playersHandPile) {

		// Move card from hand to the top of the stack
		// TODO: how do we check if it's only a single card selected?
		Card selectedCard = playersHandPile.getSelectedValue();

		if (selectedCard != null) {
			playersHand.removeCard(selectedCard);
			stackDeck.addCard(selectedCard);
			stackGraphic.setIcon(selectedCard.getCardImage());
		}

		if (playersHand.isEmpty()) {
			announceWinner();
		}

	}


	/**
	* Generic function that mimics a player's move (drawing from deck/stack, laying sets/runs and finally discarding).
	* @param playersHand the Hand of the player who clicked on the button.
	* @param playersHandPile the UI representation of the player's hand.
	*/
	private void makeMove(Hand playersHand, JList<Card> playersHandPile) {

		// Draw from Deck or Stack
		if (stackDeck.isEmpty()) {
			handleDrawFromDeck(playersHand);
		} else {

			// Choose whether to draw from Deck or from Stack
			int oneOrTwo = ThreadLocalRandom.current().nextInt(1, 3);
			if (oneOrTwo == 1) {
				handleDrawFromDeck(playersHand);
			} else {
				handleDrawFromStack(playersHand);
			}

		}


		// Lay on table (if possible)
		// TODO CRITICAL: SELECT A RANDOM SET FROM THE HAND TO LAY (otherwise, it'll never lay)
		handleLayOnTable(playersHand, playersHandPile);


		// Discard to Stack
		// TODO CRITICAL: SELECT A RANDOM CARD FROM THE HAND TO DISCARD (otherwise, it'll never discard)
		handleDiscard(playersHand, playersHandPile);

	}


	/**
	* Enable and disable the players' buttons depending on their turn and if they've drawn or not.
	*/
	private void setButtonStates() {

		if (p1Turn) {

			if (currentPlayerHasDrawn) {
				p1DrawFromDeckButton.setEnabled(false);
				p1DrawFromStackButton.setEnabled(false);
				p1LayOnTableButton.setEnabled(true);
				p1DiscardButton.setEnabled(true);
			} else {
				p1DrawFromDeckButton.setEnabled(true);
				p1DrawFromStackButton.setEnabled(!stackDeck.isEmpty());
				p1LayOnTableButton.setEnabled(false);
				p1DiscardButton.setEnabled(false);
			}

		} else {

			if (currentPlayerHasDrawn) {
				p2DrawFromDeckButton.setEnabled(false);
				p2DrawFromStackButton.setEnabled(false);
				p2LayOnTableButton.setEnabled(true);
				p2DiscardButton.setEnabled(true);
			} else {
				p2DrawFromDeckButton.setEnabled(true);
				p2DrawFromStackButton.setEnabled(!stackDeck.isEmpty());
				p2LayOnTableButton.setEnabled(false);
				p2DiscardButton.setEnabled(false);
			}

		}

	}


	/**
	* Handles a user's action triggered by any of the registered buttons.
	* @param e the ActionEvent represnting the user's action.
	*/
	public void actionPerformed(ActionEvent e) {

		// Get event source
		Object src = e.getSource();


		if (p1Turn) {


			// Draw from Deck
			if (p1DrawFromDeckButton == src && !currentPlayerHasDrawn) {
				handleDrawFromDeck(p1Hand);
				currentPlayerHasDrawn = true;
			}


			// Draw from Stack (if there's at least one card in it)
			if (p1DrawFromStackButton == src && !currentPlayerHasDrawn && !stackDeck.isEmpty()) {
				handleDrawFromStack(p1Hand);
				currentPlayerHasDrawn = true;
			}


			// Lay set on table
			if (p1LayOnTableButton == src && currentPlayerHasDrawn) {
				handleLayOnTable(p1Hand, p1HandPile);
			}


			// Discard to Stack
			if (p1DiscardButton == src && currentPlayerHasDrawn) {

				// Only permit discarding of one card at a time (instead of multiple)
				int[] num = p1HandPile.getSelectedIndices();
				if (num.length != 1) return;

				handleDiscard(p1Hand, p1HandPile);
				p1Turn = false;
				currentPlayerHasDrawn = false;

				// AI makes a move
				if (p2IsCPU) {
					makeMove(p2Hand, p2HandPile);
					p1Turn = true;
				}

			}


		} else if (!p2IsCPU) { // it's Player 2's turn and he's not a CPU


			// Draw from Deck
			if (p2DrawFromDeckButton == src && !currentPlayerHasDrawn) {
				handleDrawFromDeck(p2Hand);
				currentPlayerHasDrawn = true;
			}


			// Draw from Stack (if there's at least one card in it)
			if (p2DrawFromStackButton == src && !currentPlayerHasDrawn && !stackDeck.isEmpty()) {
				handleDrawFromStack(p2Hand);
				currentPlayerHasDrawn = true;
			}


			// Lay set on table
			if (p2LayOnTableButton == src && currentPlayerHasDrawn) {
				handleLayOnTable(p2Hand, p2HandPile);
			}


			// Discard to Stack
			if (p2DiscardButton == src && currentPlayerHasDrawn) {

				// Only permit discarding of one card at a time (instead of multiple)
				int[] num = p2HandPile.getSelectedIndices();
				if (num.length != 1) return;

				handleDiscard(p2Hand, p2HandPile);
				p1Turn = true;
				currentPlayerHasDrawn = false;

			}


		}


		// After action has been processed, change button states accordingly
		setButtonStates();


	}

}
