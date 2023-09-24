/*
 * CSCI 1913
 * Project 2: The Curious Card Conundrum
 * Code by Jonathan Cheng
 */

/*
 * This class Card represents a single playing card
 * Represent with rankname and suitname corresponding to the ranknum and suitnum
 */
public class Card 
{
    private int ranknum;
    private int suitnum;
    private String rankname;
    private String suitname;
    
    /**
     * This constructor sets the card name according to its rank and suit
     * @param rank
     * @param suit
     */
    public Card(int rank, int suit)
    {
        String[] ranknameArray = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suitnameArray = {"Spades", "Hearts", "Clubs", "Diamonds"};

        if (((rank < 1) || (rank > 13)) || ((suit < 1) || (suit > 4)))
        {
            System.out.println("Invalid Card");
            ranknum = 1; // set as ace of spades
            suitnum = 1;
        }
        else
        {
            ranknum = rank;
            suitnum = suit;
        }
        rankname = ranknameArray[ranknum - 1]; // index - 1 is because ace = 0
        suitname = suitnameArray[suitnum - 1];
    }
    
    /**
     * This method return number of representation of the cards rank
     * @return number rank
     */
    public int getRankNum()
    {
        return ranknum;
    }
    
    /**
     * This method returns number of representation of the suit num
     * @return number suit
     */
    public int getSuitNum()
    {
        return suitnum;
    }
    
    /**
     * This method return name of the rank number
     * @return string name
     */
    public String getRankName()
    {
        if (rankname == null)
        {
            return null;
        }
        String rankname1 = rankname.substring(0,1).toUpperCase(); // first letter
        String rankname2 = rankname.substring(1); // rest of the word
        String rankname = rankname1 + rankname2; // combine first letter with the rest of the word
        return rankname;
    }
    
    /**
     * This method return name of the Suit name
     * @return suit name
     */
    public String getSuitName()
    {
        if (rankname == null)
        {
            return null;
        }
        String suitname1 = suitname.substring(0,1).toUpperCase(); // first letter
        String suitname2 = suitname.substring(1); // rest of the word
        String suitname = suitname1 + suitname2; // combine first letter with the rest of the word
        return suitname;
    }
    
    @Override
    
    /**
     * This method overides the default toString method
     * @return description of the card
     */
    public String toString()
    {
        return (rankname + " of " + suitname);
    }
    
    @Override
    
    /**
     * This method overides the default equals method
     * Checks if the ranknum and the suitnum are the same
     * @return boolean true if it matches
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        else if (obj == null)
        {
            return false;
        }
        else if (obj instanceof Card)
        {
            Card lr = (Card) obj; // making the code recognize it as a obj
            return this.suitnum == lr.suitnum && this.ranknum == lr.ranknum;
            //return this.from == lr.from && this.to == lr.to // check if object is equal variable by variable
        }
        else
        {
            return false;
        }
    }
}
