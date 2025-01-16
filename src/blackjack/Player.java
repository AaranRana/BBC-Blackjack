package blackjack;

import java.util.ArrayList;
import java.util.List;

/***
 * A class to simulate the player.
 * @author Aaran Rana
 *
 */
public class Player {
	
	// List of cards that are in the player's hand.
	private final List<Card> hand;
	
	/***
	 * Constructor for the player object, initialise the hand object as an arraylist.
	 */
	public Player() {
		hand = new ArrayList<>();
	}
	
	/***
	 * Add a card to the hand arraylist.
	 * @param Card - Object of the Card that will be added.
	 */
	public void receiveCard(Card card) {
		hand.add(card);
	}
	
	/***
	 * Calculate the current score in the hand, and account for any aces.
	 * @return Int - Current score, as an integer.
	 */
	public int calculateScore() {
		int score = 0;
		int aceCount = 0;
		
		// For each card in the hand, get the value and add it to the score.
		for(Card card: hand) {
			score += card.getValue();
			//If ace, increase the ace count.
			if(card.getRank() == Rank.ACE) {
				aceCount++;
			}
		}
		
		//If the score is above 21 and we have aces, take away 10 from the score, and remove 1 off the ace count.
		while(score>21 && aceCount > 0) {
			score -= 10;
			aceCount--;
		}
		
		return score;
	}
	
	/***
	 * Get the hand object
	 * @return List<Card> - ArrayList of the cards in the hand.
	 */
	public List<Card> getHand(){
		return hand;
	}
	
	/***
	 * Check if the player is bust, by calculating the score and checking if they are over 21.
	 * @return Boolean - False if we are bust, True if we are not bust.
	 */
	public boolean isBust() {
		return calculateScore() > 21;
	}
	
	public boolean fiveCardWin() {
		return hand.size() >= 5;
	}
	
	/***
	 * Empty the hand, and remove any cards inside the Arraylist.
	 */
	public void emptyHand() {
		hand.clear();
	}
	
	/***
	 * Print the cards inside the ArrayList, and calculate the score.
	 */
	@Override
	public String toString() {
		return getHand() + " \nScore - " + calculateScore();
	}
}