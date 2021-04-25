# Rummy Card Game

> Víctor A. Hernández Castro (801-15-3500)
> CCOM4029 - High Level Languages

This project is an interactive version of the Rummy card game. Provided some basic UI code and some random files, the student should construct the game from scratch and structure it using his/her knowledge on Design Patterns and Java programming.

## Usage

1. Clone this repository
2. `cd` into this repository
3. Compile the source files with `javac proj2/Proj2.java`
4. Run the program and log the output with `java proj2.Proj2`

## Rules of the game

1. Each player is dealt 9 cards from the stock pile (i.e. Deck)
2. The next card from the Deck is turned face-up and placed in the discard pile (i.e. Stack).
3. In each turn, a player:
	1. Draws from the Deck or Stack
	2. Does some optional options:
		* Lay a Set on the table
		* Lay a Run on the table
		* Lay cards that fit in sets or runs already on the table
	3. Discards to the Stack (~~If a player is able to lay all remaining cards on the table at the end of a turn, the discard is optional????~~)
4. The game is over when either:
	* One player is out of cards, or...
	* the cards from the stock pile are exhausted
		* If the cards from the Deck are exhausted, all players count the points remaining in their hands and the lowest value hand wins (ties are possible!)

### Points Scheme

* Aces are worth 1 point
* Face cards are worth 10 points
* All other cards are worth their face value (i.e. Seven of Spades is worth 7 points)

## Project Specifications

* Write a stack class, named `MyStack`? ~`Stack`~?, which:
	* has a `push()` method
	* has a `pop()` method
	* has a ~`top()`~ `peek()` method
	* has an `isEmpty()` method
	* should be implemented from scratch
	* should use generics
	* can't have a superclass that isn't a primitive type
	* ~can't have any data elements that aren't of primitive type~
* Write the `Hand` class, which:
	* implements the `HandInterface` provided
	* may derive from other Java classes, like those in the `Collection` framework
	* should maintain the cards in sorted order
	* ~should provide a `play()` function to implement a Computer Opponent~
* Write the `Deck` class, which:
	* implements the `DeckInterface` provided
	* may derive from other Java classes, like those in the `Collection` framework
	* should provide a constructor which creates a 52-card deck of shuffled cards
* Write the ~`Pile`~ `Set`? class, which:
	* implements the ~`PileInterface`~ `SetInterface`? ~provided~ not provided
	* ~`Pile`~ `Set`? should derive from your `MyStack` class
* You may not change the provided interfaces (but you can add methods to the classes themselves)
* The Computer Opponent AI can make random choices (like decide whether to draw from the stock pile or the discard pile), but it must at the very least look for Sets in the hand...
	* if you implement it so that it can look for Runs as well, you will receive EXTRA CREDIT
	* if you implement it so that it makes smarter play routines, you will receive EXTRA CREDIT
* You will be provided with some code for the UI, interactive game control and the `Card` class, along with its `CardInterface`
* The program takes two kinds of command line arguments ~(which is already processed in the provided code)~:
	* the `-h` flag enables logging of actions (the default is no logging)
	* ~the `-0`, `-1`, and `-2` flags indicate the number of interactive players in the game (the default is `-0`, indicating both players are automated)~
* By default, the provided code can be run directly the `Table.java` file, whose `main` method should be extracted into a separate file called `Proj2.java`
* You should wrap the whole project in a package named `proj2`
* The last line should be either `Player 1 Wins!`, `Player 2 Wins!` or `It's a tie!`

### Notes and Hints

* The project is in Java 13 SE
* To create the file containing your logs, use the command `java proj2.Proj2 > p2-output.txt` (after compiling, of course)

### Deadlines and Disclaimers

* By the intermediate deadline, you should turn in a description of the classes you intend to create, along with the specification of their attributes and methods. You may change these choices later, but you must submit the initial design regardless.
* This project is an OPEN assignment (i.e. write your own code, and you're allowed to help others as long as you complete it by yourself)
* You can't copy anyone else's code, have someone else write your code for you nor submit someone else's code as your own
* Any help you receive must be documented, including discussion with other people, books, papers, and web resources (all documented in the `README.md` file):
	* if you received no help, say so
	* if you helped someone else, say so
* ~Each one of the points in the specifications are worth 10 points for a total of 90 points; the final 10 points are for collaboration and adhering to coding standards, based on the comments of your team members and a rubric from the department~

### More Extra Credit

* The card display in the UI is minimalist. There are card images available in the folder `lscards`; use them to spruce up the appearance of your game (+ 5pts)
* Modify the `Table` so that the game begins with the first card being on the Stack (+ 5pts)
* The base project only requires Sets to be discovered and laid on the table. Extend the program to include Runs using an interface named `RunInterface.java` and its class `Run.java` (+ 5pts)
* If you created the `RunInterface`, make it `SetInterface`'s super interface ~to deal with both the sets and the runs~ (+ 5pts)
* ~Add some heuristics to improve performance in automated play (discussing each rule you add and why you expect it to improve performance in your `README.md` file) (+ 2pts per rule added, for a max of 4 rules)~
* The implement an additional flag when running the program indicating the number of interactive players in the game (i.e. `-0`, `-1` or `-2`), where the default is 2 interactive players (+ 10pts)
* Write a two-page paper briefly summarizing the research challenges of intelligent game play and discussing how AI research might be used to iprove your Rummy program. Your paper should be gramatically correct, include appropriate bibliographic references, and be submitted in `pdf` format (+ 10pts)

### Deliverables

* `*.java` files (including Proj2.java and Card.java)
* `p2-output.txt`
* `README.md` (including instructions for how to run and interact your GUI)
* Any items required for extra credit options
