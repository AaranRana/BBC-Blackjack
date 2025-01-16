package blackjack;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Deck deckOfCards = new Deck();
		Player player = new Player();
		
		// Give player 2 cards, and show them in the console.
		player.receiveCard(deckOfCards.dealCard());
		player.receiveCard(deckOfCards.dealCard());
		System.out.println("Starting Hand - " + player);
					
		// Create scanner object for user input.
		Scanner scanner = new Scanner(System.in);
		
		// While loop will only be broken if the user wishes to stop playing.
		while(true) {
			
			// If false, game continues. If True, end the game and exit the while loop.
			boolean endGame = false;
			
			// Give command options, and ask for user input.
			System.out.println("\nPlease select a command.");
			System.out.println("1 - Hit (Take a card.)");
			System.out.println("2 - Stand (Don't take any more cards.)");
			System.out.println("3 - Look at Cards.");
			
			String userInput = scanner.nextLine();
			
			// Check user input, and execute appropriate code (or default if incorrect input.)
			switch(userInput){
			
			// Hit Case.
			case"1":
				System.out.println("\nYou have taken a card.");
				player.receiveCard(deckOfCards.dealCard());
				System.out.println("Current Hand - " + player);
				
				if(player.isBust()) {
					System.out.println("You have gone bust!");
					endGame = true;
				}
				
				if(player.fiveCardWin()) {
					System.out.println("You have five cards!");
					endGame = true;
				}
				break;
				
			// Stand Case.
			case"2":
				System.out.println("\nYou have stood.");
				endGame = true;
				break;
			
			// Look at Cards case
			case"3":
				//The user can just scroll up, but i'm just replicating what can be done in real life.
				System.out.println("\nYou are looking at your cards.");
				System.out.println("Current Hand - " + player);
				break;
			default:
				System.out.println("Incorrect Input, please select one of the options above.\n");
			}
			
			// Does user want to play again?
			if(endGame) {
				
				// If the player is not bust, simulate a dealer placing cards to beat the player.
				if(!player.isBust()) {
					if(player.fiveCardWin()) {
						System.out.println("You won, due to having 5 cards!");
					}else {
						if(deckOfCards.simulateDealer(player.calculateScore())) {
							System.out.println("You Won!");
						}else {
							System.out.println("You Lost...");
						}
					}
				}else {
					System.out.println("You Lost...");
				}
				System.out.println("\nDo you wish to play again?");
				System.out.println("1 - Yes");
				System.out.println("2 - No");
				
				userInput = scanner.nextLine();
				if(userInput.equals("1")) {
					player.emptyHand();
					deckOfCards.resetDeck();
					System.out.println("Starting another game...\n");
					player.receiveCard(deckOfCards.dealCard());
					player.receiveCard(deckOfCards.dealCard());
					System.out.println("Starting Hand - " + player);
				}else if(userInput.equals("2")) {
					break;
				}else {
					System.out.println("Incorrect Input. Stopping Game.");
					break;
				}
			}
		}
		scanner.close();
	}
}