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
        return false;
    }

    public void checkCard(BingoChip chip)
    {
        // TODO 2.3
        // if bingo card has same number as bingo chip
        // add bingo letter to bingoChars
    }

    public void printCard()
    {
        // TODO 2.3
        System.out.println(this.bingoChars.toString());

    }

}
