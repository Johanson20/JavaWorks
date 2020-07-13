package joe1;
//creates a class Card to return the face and type of a card

public class Card
{
	private final String face;
	private final String suit;
	
	public Card (String cf, String cs)
	{
		this.face = cf;
		this.suit = cs;
	}
	
	public String toString()
	{
		return face + " of " + suit;
	}
}