package blackjack;

/***
 * Card Class, which stores the rank and suit of the card.
 * @author Aaran Rana
 *
 */
public class Card {
	
	// Store rank and suit (doesn't change.)
	private final Rank rank;
	private final Suit suit;
	
	/***
	 * Construct the Card object.
	 * 
	 **/
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/***
	 * Get this card's rank.
	 * @return The card's rank.
	 */
	public Rank getRank() {
		return rank;
	}
	
	/***
	 * Get this card's suit.
	 * @return The card's suit.
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/***
	 * Get this card's value.
	 * @return The card's value.
	 */
	public int getValue() {
		return rank.getValue();
	}
	
	/***
	 * Return a string of this card.
	 * @return String object, detailing what card it is.
	 */
	@Override
	public String toString() {
		return rank.getName() + " of " + suit.getName();
	}
}