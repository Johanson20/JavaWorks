package joe1;
import java.security.SecureRandom;
//Uses class Card to initialize various card properties

public class DeckOfCards
{
	private Card[] deck;
	private int cc;
	private static final int noc = 52;
	private static final SecureRandom guess = new SecureRandom();
	
	public DeckOfCards()
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven",
				"Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		deck = new Card[noc];
		cc = 0;
		
		for (int count = 0; count < deck.length; count++)
			deck[count] = new Card(faces[count%13], suits[count/13]);
	}
	
	public void shuffle()
	{
		cc = 0;
		
		for (int first = 0; first < deck.length; first++)
		{
			int second = guess.nextInt(noc);
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	
	public Card dealCard()
	{
		if (cc < deck.length)
			return deck[cc++];
		else
			return null;
	}
}