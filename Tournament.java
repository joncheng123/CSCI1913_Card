/*
 * CSCI 1913
 * Project 2: The Curious Card Conundrum
 * Code by Jonathan Cheng
 */

/*
 * This class is tournament
 * It executes the win percentage rate of every pair of AI
 */

public class Tournament 
{
    public static void main(String[] args)
    {
        AI[] ais = new AI[3]; // create an array of size 3
        ais[0] = new AI();
        ais[1] = new SmallestCardAI();
        ais[2] = new BiggestCardAI();

        for (int i = 0; i < ais.length; i++)
        {
            for (int j = 0; j < ais.length; j++)
            {
                UnoWarMatch match = new UnoWarMatch(ais[i], ais[j]);
                double winRate = match.winRate(1000);
                String ai1Name = ais[i].toString();
                String ai2Name = ais[j].toString();
                System.out.println(ai1Name + " vs. " + ai2Name + " winRate: " + winRate);   
            }
        }
    }
}
