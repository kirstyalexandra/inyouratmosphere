package Lab11;

/**
 * @author Kirsty Alexandra Nguegang
 * @version 4/10/2018
 */

import java.util.*;

public class BingoCard
{
    private HashMap<Character, TreeSet<Integer>> card;
    public final static String BINGO_KEYS = "BINGO";
    public final static int MAX_VALUES_PER_LETTER = 15;
    public final static int NUMBERS_PER_LETTER = 5;

    public BingoCard()
    {
        // TODO Project 2.2
        this.card = new HashMap<Character, TreeSet<Integer>>();
    }

    public boolean hasNumber(BingoChip chip)
    {
        // TODO Project 2.2
        boolean result = false;
        if (this.card.containsKey(chip.getNumber()))
        {
            result = true;
            //this.card.put(chip.getLetter(), 0);
        }
        return result;
    }
    public String toString()
    {
        // TODO Project 2.2 - gonna come back here

        // utilize StringBuffer and String.format
        // utilize forEach lambda construct to process a row
        return "???";
    }

    public boolean equals(Object o)
    {
        // TODO Project 2.2
        boolean same = true;
        if (this == o)
        {
            same = true;
        }
        else if (o == null || o.getClass() != getClass())
        {
            same = false;
        }
        else
        {
            // cast o to BingoCard
            // check size
            // check if letter && number are the same
            // if they are, same = true;
            // else, same = false;
        }

        return same;
    }
}