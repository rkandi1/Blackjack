package BlackjackObjects;

import java.util.ArrayList;
import BlackjackObjects.Card;

public class Player {
	private final String name;
	private ArrayList<Card> cardsDealt = new ArrayList<>();
	private int playerSum;
	
	public Player(String name) {
		this.name = name;
	}
	
	public Player(String name, Card c1, Card c2) {
		this.name = name;
		cardsDealt.add(c1);
		cardsDealt.add(c2);
		playerSum += translateRankToInt(c1.getRank());
		playerSum += translateRankToInt(c2.getRank());
		
		System.out.println(this.name + " has a " + c1.getRank() + " of " + c1.getSuit() + " and " + c2.getRank() + " of " + c2.getSuit());
	}
	
	public String getName() {
		return name;
	}
	
	public int getSum() {
		return playerSum;
	}
	
	public int hit(Card dealt) {
		cardsDealt.add(dealt);
		System.out.println(this.name + " got a " + dealt.getRank() + " of " + dealt.getSuit());
		int cardNum = translateRankToInt(dealt.getRank());
		playerSum += cardNum;
		return playerSum;
	}
	
	public void stand() {
		System.out.print(name + " chooses to stand \n");
	}
	
	
	protected int translateRankToInt(String rank) {
		if (rank.equals("JACK") || rank.equals("QUEEN") || rank.equals("KING")) {
			return 10;
		}
		if (rank.equals("ACE")) {
			if (playerSum > 10) {
				return 1;
			} else {
				return 11;
			}
		}
		return Integer.parseInt(rank);
	}
}
