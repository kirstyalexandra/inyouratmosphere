package Lab11;

/**
 * @author Kirsty Alexandra Nguegang
 * @version 4/10/2018
 */

import java.util.*;

public class BingoGame
{
    public final static int NUMBER_OF_CHIPS = 75;
    private int numberOfPlayers;
    private ArrayList<BingoChip> bingoDrum;
    private Player[] players;

    public BingoGame(int numOfPlayers)
    {
        // TODO Project 2.4
        setNumOfPlayers(numOfPlayers);
        createBingoDrum();
        setNumOfPlayers(numOfPlayers);
    }

    private void createBingoDrum()
    {
        // TODO Project 2.4
        this.bingoDrum = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CHIPS; i++)
        {
            this.bingoDrum.set(i, new BingoChip(i));
        }
    }

    private void createPlayers()
    {
        // TODO Project 2.4
        for (int i = 0; i < this.players.length; i++)
        {
            this.players[i] = new Player();
        }
    }

    private void setNumOfPlayers(int numOfPlayers)
    {
        // TODO Project 2.4
        this.numberOfPlayers = numOfPlayers;
        createPlayers();
    }

    public int getNumberOfPulledChips()
    {
        // TODO Project 2.4
        return NUMBER_OF_CHIPS - this.bingoDrum.size(); // This is a stub
    }

    public BingoChip pullChip()
    {
        // TODO Project 2.4
        Random rand = new Random();
        int randInt = rand.nextInt(this.bingoDrum.size());
        BingoChip bc = this.bingoDrum.remove(randInt);
        return bc; // This is a stub
    }

    public void play() {
        // TODO Project 2.4
        // while there is no winner && the bingo drum isn't empty
        //{

                BingoChip bc = pullChip();
                System.out.println(" ---> Calling: " + bc.toString());
                for (int i = 0; i < this.players.length; i++)
                {
                    this.players[i].checkCard(bc);
                    this.players[i].printCard();
                    if (this.players[i].isWinner())
                        System.out.println("!!! Player " + i + " has called BINGO !!!");
                    //somehow break out of play
                }

                System.out.println(getNumberOfPulledChips() + " chips were called.");
    }
}