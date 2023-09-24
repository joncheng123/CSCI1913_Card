/*
 * CSCI 1913
 * Project 2: The Curious Card Conundrum
 * Code by Jonathan Cheng
 */

 /*
  * This class UnoWarMatch has two core function
  * One plays a single game and reporting who won
  * Play many times and track how many times WON as a double 
  */

public class UnoWarMatch
{
	private AI ai1;
	private AI ai2;
	
	/**
	 * This constructor takes in 2 AIs and compare
	 * @param ai1 First AI
	 * @param ai2 Second AI
	 */
  	public UnoWarMatch(AI ai1, AI ai2)
	{
		this.ai1 = ai1;
		this.ai2 = ai2;
	}

	/**
	 * This method play one round of the game
	 * @param isAI1Turn
	 * @param ai1Hand
	 * @param ai2Hand
	 * @param deck
	 * @return boolean
	 */
	public boolean playRound(boolean isAI1Turn, Hand ai1Hand, Hand ai2Hand, Deck deck) {
		
		AI currentPlayer;
		Card cardToPlay;
		boolean roundover = false;
		Card topCard = deck.draw();
		CardPile pile = new CardPile(topCard);
		
		// Determine which AI is the current player
		if (isAI1Turn) {
			while (!roundover) {
				currentPlayer = ai1;
				cardToPlay = currentPlayer.getPlay(ai1Hand, pile);
				if (ai1Hand.remove(cardToPlay) == false || cardToPlay == null) {
					roundover = true;
					return false; // ai2 won
				}
				pile.play(cardToPlay); // play to pile 
				
				// Switch turns
				currentPlayer = ai2;
				cardToPlay = currentPlayer.getPlay(ai2Hand, pile);
				if (ai2Hand.remove(cardToPlay) == false || cardToPlay == null) {
					roundover = true;
					return true; // ai1 won
				}
				pile.play(cardToPlay);
			}
		} 
		else {
			while (!roundover) {
				currentPlayer = ai2;
				cardToPlay = currentPlayer.getPlay(ai2Hand, pile);
				if (ai2Hand.remove(cardToPlay) == false || cardToPlay == null) {
					roundover = true;
					return true; // ai1 won
				}
				pile.play(cardToPlay);
				
				// Switch turns
				currentPlayer = ai1;
				cardToPlay = currentPlayer.getPlay(ai1Hand, pile);
				if (ai1Hand.remove(cardToPlay) == false || cardToPlay == null) {
					roundover = true;
					return false; // ai2 won
				}
				pile.play(cardToPlay);
			}
		}
		return isAI1Turn;
	}
	
	/**
	 * This plays a single game of Uno War between 2 AIs and reports the winner
	 * @return true if AI 1 wins, false if AI 2 wins
	 */
	public boolean playGame() {
		// Create new deck and shuffle it
		Deck deck = new Deck();
		deck.shuffle();
		
		int ai1Wins = 0;
		int ai2Wins = 0;
		
		boolean winner;
		
		// Create hand objects and deal 5 cards to each hand
		Hand ai1Hand = new Hand(deck, 5);
		Hand ai2Hand = new Hand(deck, 5);
		
		// AI 1 plays first in the first round (for the first game)
		boolean isAI1Turn = true;
		while ((ai1Wins < 10) && (ai2Wins < 10)) {
			// Play one round
			winner = playRound(isAI1Turn, ai1Hand, ai2Hand, deck);
			if (winner) {
				ai1Wins++; // AI 1 wins
				isAI1Turn = true;
			} 
			else {
				ai2Wins++; // AI 2 wins
				isAI1Turn = false;
			}
			if (ai1Wins == 10 || ai2Wins == 10) {
				return ai1Wins == 10;
			}
		}
		// return the winner (boolean)
		return ai1Wins == 10;
	}

	/**
	 * This method have the AIs play against each other nTrials times
	 * 
	 * @param nTrials
	 * @return percentage of time AI 1 beat AI2 as a double
	 */
	public double winRate(int nTrials) {
		
		int ai1GameWins = 0;
		
		// Play nTrials games
		for (int i = 0; i < nTrials; i++) {
			boolean ai1GameWon = playGame(); // determine the outcome of each game and update the number of wins
			if (ai1GameWon){
				ai1GameWins++;
			}
		}
		double winRate = (double) ai1GameWins / (double) nTrials;
		return winRate;
	}
}