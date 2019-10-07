# Blackjack
This is specifically for the Kleiner Perkins Fellowship Application.

## Running the game
### Prerequisites
Make sure you have downloaded Java Development Kit, as this application runs on Java, which can be downloaded from Oracle: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html.

Next, we need to run the application on the console. Here are the steps:
- Download or pull the repository onto your computer.
- Change directory into the src folder.
- Run the following command: "Javac Game.java"
- Then run: "java Game"


## Rules for the game
This is a simplified version of the game of blackjack where there are three players playing against the house (also a player). The players can only take the following actions:
- Hit
- Stand

After entering the names of all the players, we start the game. The other 2 players and the house play their hands automatically. However, when your turn comes in the end, you have to decide to either hit or stand.  If you decide to hit (by specifically writing hit), the card will be laid out for you. If you write anything else, the program assumes you are choosing to stand. If all the players bust, then the house automatically wins. If one player has a BlackJack, then house plays until it either has a blackjack or busts. If one of the players does not bust, and the house does not bust either, then the game is considered a tie (even though, technically, the player with the closest count to 21 wins).
