/*
 * CSCI 1913
 * Project 2: The Curious Card Conundrum
 * Code by Jonathan Cheng
 */

/*
 * This hand class represents a hand full of cards
 * Draw cards from deck as card is removed from the hand
 */
public class Hand 
{
    private Card[] cards;
    private int size;
    private Deck deck; // store deck as an instance variable to access it

    /**
     * This constructor creates an array to store a card of given size 
     * Draw to supply the deck
     * @param deck
     * @param size
     */
    public Hand(Deck deck, int size)
    {
        cards = new Card[size];
        this.deck = deck;
        this.size = size;
        for (int i = 0; i < size; i++)
        {
            cards[i] = deck.draw(); // draw the cards to make a full deck
        }
    }

    /**
     * This method gets size of the hand
     * @return size
     */
    public int getSize()
    {
        return size;
    }

    /**
     * This method get card at given index in this hand
     * @param i
     * @return card at the index 
     */
    public Card get(int i)
    {
        if (i < 0 || i >= cards.length) // out of bound checker
        {
            System.out.println("Invalid hand index!");
            return cards[0];
        }
        return cards[i];
    }
    /**
     * This method removes a card at a given hand, replacement card should be drawn from the card
     * @param card
     * @return true and card will be replaced with the deck card
     */
    public boolean remove(Card card)
    {
        if (card == null) 
        {
            return false;
        }
        for (int i = 0; i < cards.length; i++) // runs through the entire hand of cards
        {
            if (card.equals(cards[i]))
            {
                cards[i] = deck.draw(); // if is same card, replace the card with the one drawn from the deck
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks for empty hand
     * @return boolean value
     */
    public boolean isEmpty() {
        return false;
    }
}