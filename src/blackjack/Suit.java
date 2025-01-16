package blackjack;

/***
 * Enumeration for the different suits that exist.
 * @author Aaran Rana
 *
 */
public enum Suit {
	/***
	 * Hearts (eg. Ace of Hearts)
	 */
	HEARTS("Hearts"),
	/***
	 * Diamonds (eg. Ace of Diamonds)
	 */
	DIAMONDS("Diamonds"),
	/***
	 * Clubs (eg. Ace of Clubs)
	 */
	CLUBS("Clubs"),
	/***
	 * Spades (eg. Ace of Spades)
	 */
	SPADES("Spades");
	
	//The name of this suit.
	private final String name;
	
	/***
	 * Constructor for the Suit object.
	 * @param name - Suit's name, as a string.
	 */
	Suit(String name) {
		this.name = name;
	}
	
	/***
	 * Get the suit's name.
	 * @return String - the name of the suit.
	 */
	public String getName() {
		return name;
	}
	
	/***
	 * Return the suit as a string, from getName.
	 * @return String - the name of the suit.
	 */
	@Override
	public String toString() {
		return getName();
	}
}