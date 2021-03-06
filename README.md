# Rummy Card Game

> Víctor A. Hernández Castro (801-15-3500)
> CCOM4029 - High Level Languages

This project is an interactive version of the Rummy card game. Provided some basic UI code and some random files, the student should construct the game from scratch and structure it using his/her knowledge on Design Patterns and Java programming.

See repository [here](https://github.com/VctorAHernndez/Rummy).

### Acknowledgements

The only references used to construct this project were:

1. [Official Java Tutorials & Documentation](https://docs.oracle.com)
2. [Stack Overflow](https://stackoverflow.com)

I didn't receive any help from other people nor third parties.

I didn't help anyone else in the group, as of the time of writing.

## Usage

1. Clone this repository
2. `cd` into this repository
3. Compile the source files with `javac rummy/Main.java` and `javac rummy/core/Game.java`
4. To run:
   1. if you want to play against the computer, use `java rummy.Main`
   2. if you want the computer to play against itself, use `java rummy.core.Game`

### Interacting with the GUI

As a player, the only interactions allowed are to click on any of the four provided buttons or to select cards in the hand (displayed as a sorted list):

- **Draw from Deck** - draws from the Deck (if it's not empty)
- **Draw from Stack** - draws from the Stack (if it's not empty)
- **Lay on Table** - lays the selected cards on the table (if they form a Set) or lays the selected card (if it fits on a Set already on the table)
- **Discard** - puts away the selected card in the Stack and terminates the player's turn

### Modifications to the original UI

- Changing the text on all the buttons to more reasonable call-to-action text
- Changing the image displayed in the Deck (the cards' back)
- Disabling the other player's buttons when it's not their turn
- Disabling the **"Draw from Deck"** button when the Deck is empty
- Disabling the **"Draw from Stack"** button when the Stack is empty
- Disabling the **"Draw from Deck"** button when player has already drawn a card
- Disabling the **"Draw from Stack"** button when player has already drawn a card
- Disabling the **"Lay on Table"** button when player still hasn't drawn a card
- Disabling the **"Discard"** button when player still hasn't drawn a card
- Automatically closing the window when the game is over
- Terminating the program when closing the `JFrame`'s window

## Rules of the game

1. Each player is dealt 9 cards from the stock pile (i.e. Deck)
2. The next card from the Deck is turned face-up and placed in the discard pile (i.e. Stack).
3. In each turn, a player:
   1. Draws from the Deck or Stack
   2. Does some optional actions:
      - Lay a Set on the table
      - Lay a Run on the table
      - Lay cards that fit in Sets or Runs already on the table
   3. Discards to the Stack
      - (~~Though, if a player is able to lay all remaining cards on the table at the end of a turn, the discard is optional~~)?
4. The game is over when either:
   - One player is out of cards
     - In which case, said player is crowned winner
   - The cards from the stock pile are exhausted
     - If the cards from the Deck are exhausted, all players count the points remaining in their hands, and the lowest value hand wins (ties are possible!)

### Points Scheme

- Aces are worth 1 point
- Face cards are worth 10 points
- All other cards are worth their face value (i.e. Seven of Spades is worth 7 points)

## Project Specifications

- [x] Write a stack class, named `MyStack`, which:
  - [x] has a `push()` method
  - [x] has a `pop()` method
  - [x] has a ~`top()`~ `peek()` method
  - [x] has an `isEmpty()` method
  - [x] should be implemented from scratch
  - [x] should use generics
  - [x] can't have a superclass that isn't a primitive type
  - [ ] ~can't have any data elements that aren't of primitive type~
- [x] Write the `Hand` class, which:
  - [x] implements the `HandInterface` provided
  - [ ] may derive from other Java classes, like those in the `Collection` framework
  - [x] should maintain the cards in sorted order
  - [ ] ~should provide a `play()` function to implement a Computer Opponent~
- [x] Write the `Deck` class, which:
  - [x] implements the `DeckInterface` provided
  - [ ] may derive from other Java classes, like those in the `Collection` framework
  - [x] should provide a constructor which creates a 52-card deck of shuffled cards
- [x] Write the ~`Pile`~ `Stack`? class, which:
  - [x] implements the ~`PileInterface`~ `StackInterface`? ~provided~
  - [x] ~`Pile`~ `Stack`? should derive from your `MyStack` class
- [ ] ~You may **NOT** change the provided interfaces (but you can add methods to the classes themselves)~
- [x] By default, the provided code can be run directly from the `Table.java` file, whose `main` method should be extracted into a separate file called ~`Proj2.java`~ `Main.java`
- [x] You should wrap the whole project in a package named ~`proj2`~ `rummy`
- [x] The last line should be either `Player 1 Wins!`, `Player 2 Wins!` or `It's a tie!`
- [x] The Computer Opponent AI can make random choices (like decide whether to draw from the stock pile or the discard pile), but it must at the very least ~look for Sets in the hand~ draw and discard each turn...
  - [x] if you implement it so that it can look for Sets, you will receive EXTRA CREDIT
  - [ ] if you implement it so that it can look for Runs, you will receive EXTRA CREDIT
  - [x] if you implement it so that it makes other smarter play routines, you will receive EXTRA CREDIT

### Notes and Hints

- The project is in ~Java 13 SE~ [Java 16 SE](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html)
- To create the file containing your logs, use the command `java rummy.Main > output.txt` (after compiling, of course)
- You will be provided with some code for the UI, the interactive game controls and the `Card` class, along with its `CardInterface`
- The program ~takes two kinds of command line arguments (which is already processed in the provided code)~:
  - ~the `-h` flag enables logging of actions (the default is no logging)~
  - ~the `-0`, `-1`, and `-2` flags indicate the number of interactive players in the game (the default is `-0`, indicating both players are automated)~
- ~Each one of the points in the specifications are worth 10 points for a total of 90 points; the final 10 points are for collaboration and adhering to coding standards, based on the comments of your team members and a rubric from the department~

### Deadlines and Disclaimers

- [x] By the intermediate deadline, you should turn in a description of the classes you intend to create, along with the specification of their attributes and methods. You may change these choices later, but you must submit the initial design regardless.
- [x] This project is an **OPEN** assignment (i.e. write your own code, and you're allowed to help others as long as you complete it by yourself)
- [x] You can't copy anyone else's code, have someone else write your code for you nor submit someone else's code as your own
- [x] Any help you receive must be documented, including discussion with other people, books, papers, and web resources (all documented in the `README.md` file):
  - [x] if you received no help, say so
  - [x] if you helped someone else, say so

### Extra Credit

- [x] The card display in the UI is minimalist. There are card images available in the folder ~`lscards`~ `cards`; use them to spruce up the appearance of your game _(+5pts)_
- [x] Modify the `Table` so that the game begins with the first card being on the Stack _(+5pts)_
- [ ] The base project only requires Sets to be discovered and laid on the table. Extend the program to include Runs using an interface named `RunInterface.java` and its class `Run.java` _(+5pts)_
- [ ] ~If you created the `RunInterface`, make it `SetInterface`'s super interface to deal with both the sets and the runs _(+5pts)_~
- [x] ~Add some heuristics to improve performance in automated play (discussing each rule you add and why you expect it to improve performance in your `README.md` file) _(+2pts per rule added, for a max of 4 rules)_~
- [ ] The implement an additional flag when running the program indicating the number of interactive players in the game (i.e. `-0`, `-1` or `-2`), where the default is 2 interactive players _(+10pts)_
- [ ] Write a two-page paper briefly summarizing the research challenges of intelligent game play and discussing how AI research might be used to iprove your Rummy program. Your paper should be gramatically correct, include appropriate bibliographic references, and be submitted in `pdf` format _(+10pts)_

### Deliverables

- `*.java` files (including ~`Proj2.java`~ `Main.java` and `Card.java`)
- `output.txt`
- `README.md` (including instructions for how to run and interact your GUI)
- Any items required for extra credit options
