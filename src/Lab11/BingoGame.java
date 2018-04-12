package Lab11;

/**
 * @author YOUR NAME
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
        return 0; // This is a stub
    }

    public BingoChip pullChip()
    {
        // TODO Project 2.4
        Random rand = new Random();
        int randInt = rand.nextInt(NUMBER_OF_CHIPS);
        BingoChip bc = this.bingoDrum.get(randInt);
        return bc; // This is a stub
    }

    public void play()
    {
        // TODO Project 2.4
        // while isWinner is false
            // call pullChip
            //
    }
}