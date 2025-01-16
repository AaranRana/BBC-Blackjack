package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * A class to create an object to simulate a deck of cards.
 * @author Aaran Rana
 *
 */
public class Deck {
	
	// List object which contains all the cards.
	private final List<Card> cards;
	
	// List object which contains the Dealer's hand.
	private final List<Card> hand;
	
	/***
	 * Constructor for the deck object.
	 * When the object is initialised, add each card into the deck, then shuffle.
	 */
	public Deck() {
		cards = new ArrayList<>();
		hand = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
		shuffle();
	}
	
	/***
	 * Shuffle the deck of cards.
	 * Using the Collections.shuffle() function gives us as much randomness as possible.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/***
	 * Print out the next card, then remove it from the deck and return it.
	 * @return Card - Card object (3 of Clubs, for example.)
	 */
	public Card dealCard() {
		System.out.println("Card Dealt - " + cards.get(cards.size() - 1));
		return cards.remove(cards.size() - 1);
	}
	
	/***
	 * Get the List object of the cards.
	 * @return List<Card> - All the cards that haven't been removed.
	 */
	public List<Card> getCards(){
		return cards;
	}
	
	/***
	 * Reset the deck, and add all the removed cards back into the deck, and then shuffling.
	 */
	public void resetDeck() {
		cards.clear();
		hand.clear();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
		shuffle();
	}
	
	/***
	 * Check if the dealer is bust. True if they aren't bust. False if they are bust.
	 * @return Boolean - True if not bust, False if bust.
	 */
	public boolean isBust() {
		return calculateScore() > 21;
	}
	
	/***
	 * Return the Dealer's current score in their hand.
	 * @return Integer - Dealer's score as an integer.
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
	 * Print out the dealer's hand, as a string, in the same format as the player.
	 * @return String - Dealer's hand as a string.
	 */
	public String handToString() {
		return hand + " \nScore - " + calculateScore();
	}
	
	/***
	 * Simulate a dealer dealing cards to themselves, to try and beat the player. The dealer must attempt to be above the player's score
	 * without going bust (over 21.) Traditionally, dealers must reach 17 and stop dealing afterwards, but I decided against that.
	 * 
	 * @param playerScore - Integer - The player's score.
	 * @return Boolean - True = Dealer has won. False = Dealer has lost/bust.
	 */
	public Boolean simulateDealer(int playerScore) {
		//This could've been done by using the extends keyword on the player class, and creating a new class, however I decided it'd be better
		//if I could just put it in here, for now.
		
		//Deal two cards to the Dealer, and show the player.
		hand.add(dealCard());
		hand.add(dealCard());
		System.out.println("Dealer's Starting Hand - " + handToString() + "\n");
		
		//While the score is less than 21 AND less than the player score, deal another card.
		//The dealer must attempt to beat the player's score, rather than stopping at 17.
		while(calculateScore()<=21 && calculateScore()<=playerScore) {
			hand.add(dealCard());
			System.out.println("Dealer's Current Hand - " + handToString() + "\n");
		}
		
		//If the dealer is not bust, that means the dealer wins, and we return true.
		if(isBust()) {
			return true;
		//If the dealer is bust, that means the player wins.
		}else {
			return false;
		}
	}
}