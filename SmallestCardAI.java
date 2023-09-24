/*
 * CSCI 1913
 * Project 2: The Curious Card Conundrum
 * Code by Jonathan Cheng
 */

/*
 * This class SmallestCard AI is a child class of AI
 */
public class SmallestCardAI extends AI
{
    /**
     * This method takes two parameter. Play the SMALLEST card from hand
     * @param hand
     * @param cardPile
     * @return card
     */
    public Card getPlay(Hand hand, CardPile cardPile)
    {
        Card smallestCard = null;
        for (int i = 0; i < hand.getSize(); i++)
        {
            Card card = hand.get(i); //pick the card from the hand 
            if (cardPile.canPlay(card)) // checks if its valid card
            {
                if (smallestCard == null||(card.getRankNum() < smallestCard.getRankNum()))
                {
                    smallestCard = card;
                }
            }
        }
        return smallestCard;
    }

    /**
     * This method returns the string AI name 
     */
    public String toString()
    {
        return "Smallest Card AI";
    }
}
