import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BlackjackObjects.Card;
import BlackjackObjects.Player;
import BlackjackObjects.House;


public class Game {
	private static List<Card> deck = new ArrayList<>();
	
	private static void sleep(int ms) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
	}

	private static void generateDeck() {
		String[] suits = {"DIAMONDS", "CLUBS", "HEARTS", "SPADES"};
		String[] ranks = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};
		for(String suit: suits) {
			for(String rank: ranks) {
				Card c = new Card(suit, rank);
				deck.add(c);
			}
		}
	}
	
	public static void main(String[] args) {
		generateDeck();
		ArrayList<Player> winners = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("WELCOME TO BLACKJACK!!!\n");
		sleep(1000);
		System.out.println("This game will have 3 players and one dealer. You will be one of the players.");
		sleep(1000);
		System.out.print("Name player 1: ");
		String playerOne = in.nextLine();
		System.out.print("Name player 2: ");
		String playerTwo = in.nextLine();
		System.out.print("Name your player: ");
		String myPlayer = in.nextLine();
		
		House house = new House(deck);
		Player player1 = new Player(playerOne, house.dealCard(), house.dealCard());
		Player player2 = new Player(playerTwo, house.dealCard(), house.dealCard());
		Player me = new Player(myPlayer, house.dealCard(), house.dealCard());
		
		System.out.println("OK! Let's start\n");
		sleep(1000);
		
		while(player1.getSum() < 17) {
			int playerSum = player1.hit(house.dealCard());
			if(playerSum == 21) {
				winners.add(player1);
				System.out.println(playerOne + " has a BLACKJACK!!");
			}
			if(playerSum > 21) {
				System.out.println(playerOne + " has a BUST!!");
			}
		}
		if(player1.getSum() >=17 && player1.getSum() < 21) player1.stand();
		sleep(1000);
		
		
		
		
		while(player2.getSum() < 17) {
			int playerSum = player2.hit(house.dealCard());
			if(playerSum == 21) {
				winners.add(player2);
				System.out.println(playerTwo + " has a BLACKJACK!!");
			}
			if(playerSum > 21) {
				System.out.println(playerTwo + " has a BUST!!");
			}
		}
		if(player2.getSum() >=17 && player2.getSum() < 21) player2.stand();
		sleep(1000);
		
		
		
		while(me.getSum() < 21) {
			System.out.println("Do you want to hit or stand?");
			if(in.nextLine().toLowerCase().equals("hit")) {
				me.hit(house.dealCard());
			}else {
				me.stand();
				break;
			}
		}
		if (me.getSum() == 21) {
			winners.add(me);
			System.out.println("You have a BLACKJACK!!");
		}
		if (me.getSum() > 21) {
			System.out.println("You have a BUST!!");
		}
		sleep(1000);
		
		
		
		if (player1.getSum() > 21 && player2.getSum() > 21 && me.getSum() > 21) {
			System.out.println("The dealer has won!");
		}
		else {
			while(house.getSum() < 17) {
				int playerSum = house.hit();
				if(playerSum == 21) {
					System.out.println("House has a BLACKJACK!!\n\n GAME OVER");
					return;
				}
				if(playerSum > 21) {
					System.out.println("House has a BUST!!");
					System.out.println("The following players are WINNERS: ");
					for(Player p: winners) {
						System.out.println(p.getName());
					}
					return;
				}
			}
			if (player1.getSum() == 21 || player2.getSum() == 21 || me.getSum() == 21) {
				System.out.println("The house has lost!");
			} else {
				System.out.println("There is a tie between some of the players and the house.");
			}
		}
		
		in.close();
	}

}
