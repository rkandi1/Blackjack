package BlackjackObjects;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import BlackjackObjects.Card;

public class House extends Player{
	private List<Card> deck;
	private int cardsInDeck = 52;
	private static final String dealer = "Dealer";
	private Random rand = new Random();
	
	// These variables are re-initialized to reduce back and forth between classes.
	private ArrayList<Card> cardsDealt = new ArrayList<>();
	private int playerSum = 0;
	
	public House(List<Card> deck) {
		super(dealer);
		this.deck = deck;
		
		Card c1 = this.dealCard();
		Card c2 = this.dealCard();
//		System.out.println(c1.getSuit());
		cardsDealt.add(c1);
		cardsDealt.add(c2);
		
		playerSum += super.translateRankToInt(c1.getRank());
		playerSum += super.translateRankToInt(c2.getRank());
		
		System.out.println("House has a " + c1.getRank() + " of " + c1.getSuit() + " and " + c2.getRank() + " of " + c2.getSuit());
	}
	
	public int getSum() {
		return playerSum;
	}
	
	public Card dealCard() {
		int index = rand.nextInt(cardsInDeck);
		cardsInDeck--;
		Card c = deck.remove(index);
		return c;
	}
	
	public int hit() {
		Card c = this.dealCard();
		cardsDealt.add(c);
		System.out.println("House got a " + c.getRank() + " of " + c.getSuit());
		playerSum += translateRankToInt(c.getRank());
		return playerSum;
	}
}