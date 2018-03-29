package Lab09;

import java.util.*;

/**
 * MagicTrick is a program that will guess a number that user is thinking of.
 *
 * @author Kirsty Alexandra Nguegang
 * @author atb
 * @version 3/27/2018
 */
public class MagicTrick
{
    public final int NUM_OF_SEQUENCES = 5;
    public final int NUMBERS_PER_SEQUENCE = 16;
    private ArrayList<Integer>[] sequences;

    public MagicTrick()
    {
        // TODO Project 5
        this.sequences = new ArrayList[NUM_OF_SEQUENCES];

        for (int i = 0; i <= this.sequences.length; i++)
        {
            this.sequences[i] = new ArrayList<Integer>();
        }

        // create this.sequences object
        // using a for loop create ArrayList object for each slot and fill it with appropriate values
    }

    public void displaySequences()
    {
        // TODO Project 5
        for (int i = 0; i <= NUM_OF_SEQUENCES; i++)
        {
            System.out.println("Sequence " + (i + 1) + ": " + this.sequences[i].toString());
        }
    }

    public void guessNumber(String[] answer)
    {
        // TODO Project 5
    }

    public static void main(String[] args)
    {
        MagicTrick magic = new MagicTrick();
        System.out.println("Think of a number between 1 and 31\n");
        magic.displaySequences();

        System.out.println("\nList all the sequences that your number is in (ie. 1 3)");
        Scanner scan = new Scanner(System.in);
        magic.guessNumber(scan.nextLine().split(" "));
    }
}