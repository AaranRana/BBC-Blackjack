package blackjack;

/***
 * Enumeration for the different ranks that exist.
 * @author Aaran Rana
 * 
 */
public enum Rank{
	
	/***
	 * Two. (Eg. Two of diamonds.)
	 */
	TWO("2",2),
	/***
	 * Three. (Eg. Three of Clubs.)
	 */
	THREE("3",3),
	/***
	 * Four. (Eg. Four of Hearts.)
	 */
	FOUR("4",4),
	/***
	 * Five. (Eg. Five of Hearts.)
	 */
	FIVE("5",5),
	/***
	 * Six. (Eg. Six of Hearts.)
	 */
	SIX("6",6),
	/***
	 * Seven. (Eg. Seven of Diamonds.)
	 */
	SEVEN("7",7),
	/***
	 * Eight. (Eg. Eight of Hearts.)
	 */
	EIGHT("8",8),
	/***
	 * Nine. (Eg. Nine of Clubs.)
	 */
	NINE("9",9),
	/***
	 * Ten. (Eg. Ten of Diamonds.)
	 */
	TEN("10",10),
	/***
	 * Jack (Eg. Jack of Hearts), this has a value of 10 in Blackjack.
	 */
	JACK("Jack",10),
	/***
	 * Queen (Eg. Queen of Diamonds), this has a value of 10 in Blackjack.
	 */
	QUEEN("Queen",10),
	/***
	 * King (Eg. King of Clubs), this has a value of 10 in Blackjack.
	 */
	KING("King",10),
	/***
	 * Ace (Eg. Ace of Spades), this has a value of 11 (or 1, if the hand's value is over 21) in Blackjack.
	 */
	ACE("Ace",11);
	
	// Store the name and value of this rank.
	private final String name;
	private final int value;
	
	/***
	 * Rank Constructor, which holds the name and value.
	 * @param name - Name of the rank (Eg. Queen.)
	 * @param value - Value of the rank (Queen = 10.)
	 */
	Rank(String name, int value){
		this.name = name;
		this.value = value;
	}
	
	/***
	 * Get the value of this rank.
	 * @return Value as Int.
	 */
	public int getValue() {
		return value;
	}
	
	/***
	 * Get the name of this rank.
	 * @return Name as String.
	 */
	public String getName() {
		return name;
	}
	
	/***
	 * Return the rank as a string, from getName().
	 * @return String of the name of the rank.
	 */
	@Override
	public String toString() {
		return getName();
	}
}
