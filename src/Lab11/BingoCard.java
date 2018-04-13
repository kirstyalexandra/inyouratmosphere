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
        this.card = new HashMap<>();
        int num = 0; // used to offset numbers
        TreeSet<Integer> tree = new TreeSet<>();
        Random rand = new Random();
        for (int i = 0; i < BINGO_KEYS.length(); i++)
        {
            while (tree.size() <= NUMBERS_PER_LETTER)
            {
                tree.add((rand.nextInt(MAX_VALUES_PER_LETTER) + (num * MAX_VALUES_PER_LETTER)));
                this.card.put(BINGO_KEYS.charAt(i), tree);
            }
            new TreeSet<>();
        }
    }

    public boolean hasNumber(BingoChip chip)
    {
        // TODO Project 2.2 - not sure about this method
        boolean result = false;
        if (this.card.values().contains(chip.getNumber()))
        {
            result = true;
//            this.card.put(chip.getLetter(), 0);
        }
        else
            result = true;
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
        boolean same = false;
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
            BingoCard other = (BingoCard) o;
            if (this.card.equals(other.card))
            {
                same = true;
            }
        }

        return same;
    }
}