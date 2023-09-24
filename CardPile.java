/*
 * CSCI 1913
 * Project 2: The Curious Card Conundrum
 * Code by Jonathan Cheng
 */

 /*
  * This class CardPile represents pile of cards that players play onto
  */
public class CardPile 
{
    private Card topCard;
    private int numcards;
    
    /**
     * This constructor represents the pile of cards that players play onto
     * @param topCard
     */
    public CardPile(Card topCard)
    {
        this.numcards = 1;
        this.topCard = topCard; // takes in card object as an argument and assign to an instance variable
    }

    /**
     * This method check if the input value is legal to play on the current stack
     * Legal if higher or same rank than top card
     * Or the same suit as the top card 
     * @param card
     * @return true if its legal
     */
    public boolean canPlay(Card card) 
    {
        if (card == null) // checks if card was put down to the pile
        {
            return false;
        }

        int topRank = topCard.getRankNum(); // top card
        int topSuit = topCard.getSuitNum();
        int cardRank = card.getRankNum(); // current card from the hand
        int cardSuit = card.getSuitNum();
        
        if (cardRank >= topRank) //check for ace and King comparison as well
        {
            return true;
        } 
        else if (cardSuit == topSuit) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    /**
     * This method adds another card to the pile making it new top card
     * If not legal to play, print error message
     * @param card
     */
    public void play(Card card)
    {
        if (canPlay(card)) 
        {
            topCard = card;
            numcards++; //track card pile
        }
        else{
            System.out.println("Illegal move detected!");
        }
    }

    /**
     * This method get the number of cards in the card pile
     * @return int number
     */
    public int getNumCards()
    {
        return numcards;
    }

    /**
     * This method gets the current top card
     * @return card
     */
    public Card getTopCard()
    {
        return topCard;
    }
}
