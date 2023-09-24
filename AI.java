/*
 * CSCI 1913
 * Project 2: The Curious Card Conundrum
 * Code by Jonathan Cheng
 */

/**
 * A parent class for other two AIs
 */
public class AI 
{
    /**
     * This method takes two parameter. Play the card from hand and check if its valid
     * @param hand
     * @param cardPile
     * @return card
     */
    public Card getPlay(Hand hand, CardPile cardPile)
    {
        for (int i = 0; i < hand.getSize(); i++)
        {
            
            Card card = hand.get(i); //pick the card from the hand 
            if (cardPile.canPlay(card)) // checks if its valid card
            {
                return card;
            }
        }
        return null; // if can't be played
    }

    /**
     * This method returns string
     */
    public String toString()
    {
        return "Random Card AI";
    }
}
