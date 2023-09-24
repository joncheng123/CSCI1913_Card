/*
 * CSCI 1913
 * Project 2: The Curious Card Conundrum
 * Code by Jonathan Cheng
 */

import java.util.Random;

/*
 * This class Deck represent a deck of cards
 * Use an array of type cards (52 cards)
 */
public class Deck 
{
    private int index;
    private Card[] cards;
    
    /**
     * This constructor creates a new deck containing 52 different cards
     */
    public Deck()
    {
        this.cards = new Card[52];
        this.index = 51;
        int cardposition = 0;

        for (int suit = 1; suit <= 4 ; suit++) // iterate suit from 0 to 3 (4 times)
        {
            for (int rank = 1; rank <= 13; rank++) // iterate rank from 1 to 13 (13 times)
            {
                
                cards[cardposition] = new Card(rank, suit); // loop into array
                cardposition++;
            }
        }
        // calling shuffle method // all decks are shuffled by default
        shuffle();
    }
    
    /**
     * This method shuffles by using Durstenfeld-Fisher-Yates1 algorithm
     * Pseudocode is to choose a random number between index i and length - 1
     * Next then swap the array element between index i and j
     */
    public void shuffle()
    {
        Random random = new Random(); // creating a random object
        for (int i = (cards.length - 1); i > 0; i--)
        {
            int j = random.nextInt(i);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
    
    /**
     * This method take the top card of the array and remove it from the deck
     * @return topcard
     */
    public Card draw()
    {
        if (index < 0) // empty deck
        {
            shuffle();
            index = 51;
        }
        Card topcard = cards[index]; // get the top card from the deck
        index--; // remove the card from deck by updating tracker
        return topcard;
    }

    /**
     * This method returns the number of cards remaining before the next reshuffle
     * @return index (start from 0 till 52)
     */
    public int cardsRemaining()
    {
        return (index + 1);
    }
    
    /**
     * This method returns an empty if card remaining is 0
     * @return cardsremaining
     */
    public boolean isEmpty()
    {
        return cardsRemaining() == 0;
    }
}
