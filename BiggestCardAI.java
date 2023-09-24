/*
 * CSCI 1913
 * Project 2: The Curious Card Conundrum
 * Code by Jonathan Cheng
 */

 /*
  * This class BiggestCard AI is a child class of AI
  */
public class BiggestCardAI extends AI
{
    /**
     * This method takes two parameter. Play the BIGGEST card from hand
     * @param hand
     * @param cardPile
     * @return card
     */
    public Card getPlay(Hand hand, CardPile cardPile)
    {
        Card BiggestCard = null;
        for (int i = 0; i < hand.getSize(); i++)
        {
            Card card = hand.get(i); //pick the card from the hand 
            if (cardPile.canPlay(card)) // checks if its valid card
            {
                if (BiggestCard == null || (card.getRankNum() > BiggestCard.getRankNum()))
                {
                    BiggestCard = card;
                }
            }
        }
        return BiggestCard;
    }

    /**
     * This method returns string AI name
     */
    public String toString()
    {
        return "Biggest Card AI";   
    }
}
