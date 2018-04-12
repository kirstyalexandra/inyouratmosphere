package Lab11;

/**
 * @author Kirsty Alexandra Nguegang
 * @version 4/10/2018
 */

public class BingoChip
{
    private char letter;
    private int number;

    public BingoChip(int number)
    {
        setNumber(number);
        setLetter();
    }

    private void setNumber(int number)
    {
       // TODO Project 2.1
        this.number = number;
    }

    private void setLetter()
    {
        // TODO Project 2.1 - have to come up with a formula to calculate the letter
        if (this.number >= 1 && this.number <= 15)
        {
            this.letter = 'B';
        }
        else if (this.number >= 16 && this.number <= 30)
        {
            this.letter = 'I';
        }
        else if (this.number >= 31 && this.number <= 45)
        {
            this.letter = 'N';
        }
        else if (this.number >= 46 && this.number <= 60)
        {
            this.letter = 'G';
        }
        else
        {
            this.letter= 'O';
        }
    }

    public int getNumber()
    {
        // TODO Project 2.1
        return this.number;
    }

    public char getLetter()
    {
        // TODO Project 2.1
        return this.letter;
    }

    public String toString()
    {
        // TODO Project 2.1 - not sure what this prints out
        return "um";
    }
}