package Lab11;
/**
 * @author Kirsty Alexandra Nguegang
 * @version 4/10/2018
 */
import java.util.TreeSet;

public class Player
{
    private TreeSet<Character> bingoChars;
    private BingoCard bingoCard;

    public Player()
    {
        // TODO 2.3
        this.bingoCard = new BingoCard();
        System.out.println(this.bingoCard.toString());
        this.bingoChars = new TreeSet<>();
    }

    public boolean isWinner()
    {
    	// TODO 2.3

        return this.bingoChars.size() == BingoCard.BINGO_KEYS.length();
    }

    public void checkCard(BingoChip chip)
    {
        // TODO 2.3 - not sure about if statement
        if (this.bingoCard.equals(chip.getNumber()))
        {
            this.bingoChars.add(chip.getLetter());
        }
    }

    public void printCard()
    {
        // TODO 2.3
        System.out.println(this.bingoChars.toString());

    }

}
