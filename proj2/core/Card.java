package proj2.core;

import javax.swing.ImageIcon;

import proj2.interfaces.CardInterface;


/**
 * Representation of a single playing card. A card consists of a suit value
 * (e.g. hearts, spades, diamonds, clubs), a rank value (e.g. ace, 7, king), and an image of
 * the front of the card. A card object is immutable; once instantiated, the
 * values cannot change.
 */
public class Card implements CardInterface, Comparable<Card> {


  // Class attributes
  final public static char[] suit = {'c','d','h','s'};
  final public static char [] rank = {'a','2','3','4','5','6','7','8','9','t','j','q','k'};
  final public static String directory = "cards/";


  // Instance variables
  // NOTE: NOT IN INTERFACE
  private char suitValue;
  private char rankValue;
  private ImageIcon cardImage;


  /**
  * Creates a new playing card.
  * @param suit the suit value of this card.
  * @param rank the rank value of this card.
  * @param cardFace the face image of this card.
  */
  // NOTE: NOT IN INTERFACE
  public Card(char suit, char rank, ImageIcon cardFace) {
    suitValue = suit;
    rankValue = rank;
    cardImage = cardFace;
  }


  /**
  * Creates a new playing card.
  * @param suit the suit value of this card.
  * @param rank the rank value of this card
  */
  // NOTE: NOT IN INTERFACE
  // TODO: find out if this is used or not
  public Card(char suit,char rank) {
    suitValue = suit;
    rankValue = rank;
    cardImage = new ImageIcon(getImageFile());
  }


  /**
  * Returns the Index of the Suit in the defined static array <code>suit</code>.
  * @param suit the suit value of this card.
  */
  // NOTE: NOT IN INTERFACE
  public static int getSuitIndex(char suit) {
    switch(suit) {
      case 'c':
        return 0;
      case 'd':
        return 1;
      case 'h':
        return 2;
      case 's':
        return 3;
      default:
        return -1;
    }
  }

  /**
  * Returns the Index of the rank in the defined static array <code>rank</code>.
  * @param rank the rank value of this card.
  */
  // NOTE: NOT IN INTERFACE
  public static int getRankIndex(char rank) {
    switch (rank) {
      case 'a':
        return 0;
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
        return rank - '1';
      case 't':
        return 9;
      case 'j':
        return 10;
      case 'q':
        return 11;
      case 'k':
        return 12;
      default:
        return -1;
    }
  }


  /**
  * Returns the path to the card's image.
  * @return a String representing a file path.
  */
  public String getImageFile() {
    return directory + toString() + ".gif";
  }


  /**
  * Returns the suit of the card.
  * @return a char representing the suit value of the card.
  */
  public char getSuit() {
    return suitValue;
  }


  /**
  * Returns the rank of the card.
  * @return a char representing the rank value of the card.
  */
  public char getRank() {
    return rankValue;
  }


  /**
  * Returns the graphic image of the card.
  * @return an icon containing the graphic image of the card.
  */
  public ImageIcon getCardImage() {
    return cardImage;
  }


  /**
  * Returns a two character String with rank being represented by one of the following chars - a,1,2,3,4,5,6,7,8,9,t,j,q,k
  * and suit being represented by one of the following chars - c,d,h,s
  * Useful for getting the card's image.
  * @return the name of the card.
  */
  public String toString() {
    return "" + getRank() + getSuit();
  }


  /**
  * Compares two cards for the purposes of sorting.
  * Cards should be ordered by their rank index as defined in the char static array named rank.
  * @param otherCard the other card
  * @return a negative integer, zero, or a positive integer if this card is
  * less than, equal to, or greater than the referenced card.
  */
  // NOTE: NOT IN INTERFACE
  public int compareTo(Card otherCard) {
    int rankDiff = getRankIndex(suitValue) - getRankIndex(otherCard.suitValue);
    return rankDiff;
  }


}
