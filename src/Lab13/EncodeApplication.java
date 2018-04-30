package Lab13;

import java.io.File;
import java.util.*;


/**
 * A class that implements text encoding using Huffman compression algorithm
 *
 * @author Kirsty Alexandra Nguegang
 * @version 4/24/2018
 */
public class EncodeApplication
{
    //  contains all the lines included in the given text file
    private Message myMessage;
    //  contains the myMessage encoded with Huffman code
    private Code myCode;
    //  contains Huffman trees for each unique character in myMessage
    private HuffmanTree[] myTrees;
    //  initialized to the number of unique characters in the message
    private int numberOfTrees;
    //   allowing ASCII character set
    private final int MAX_NUMBER_OF_CHARS = 128;

    /**
     * Constructor for objects of class EncodeApplication
     */
    public EncodeApplication()
    {
        this.myMessage = new Message();
        this.myCode = new Code();
        this.myTrees = null;
        this.numberOfTrees = 0;
    }


    /**
     * count the number of times each character appears in the message.
     *
     * @return an array with the count for the number of times each character occurs.
     */
    public int[] getCounts()
    {
        // TODO Project 5
        String [] string = this.myMessage.toString().split("\n"); // splitting string to retrieve text
        String message = string[1];
        int[] result = new int[MAX_NUMBER_OF_CHARS + 1];
        for (int i = 0; i < message.length(); i++)
        {
            result[(int)message.charAt(i)]++;
        }
        for (int i = 0; i < result.length; i++)
        {
            if (result[i] != 0)
            {
                System.out.println("---> Count of character " + (char)i + " is " + result[i]);
            }
        }
        //System.out.println("getCounts - IMPLEMENT ME");
        return result;
    }

    /**
     * create the initial forrest of trees.
     *
     * @param count the frequency of each character
     *              to be encoded - essentially the array returned by getCounts method.
     * @return the forest of trees for each single letter
     */
    public HuffmanTree[] createInitialTrees(int[] count)
    {
        // TODO Project 5
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < count.length; index++)
        {
            if (count[index] != 0)
                queue.offer(count[index]);
        }
        this.numberOfTrees = queue.size();
        System.out.println("Creating " + this.numberOfTrees + " initial trees");
        HuffmanTree[] result = new HuffmanTree[this.numberOfTrees];
        String[] string = this.myMessage.toString().split("\n");
        String message = string[1];

        for (int i = 0, j = 0; i < count.length && j < result.length; i++)
        {
            if (count[i] != 0)
            {
                List<Character> charList = new ArrayList<>();
                charList.add((char)i);
                result[j] = new HuffmanTree(new HuffmanCode(charList, count[i]));
                j++;
            }
        }
        return result;
    }

    /**
     * Creates final Huffman Tree by combining two "smallest trees" at a time.
     * The smallest tree is the tree with the smallest frequency but you should
     * call compareTo method
     * Operates on the forest of trees contained in the variable myTrees.
     */
    public void createHuffmanTree()
    {
        // TODO Project 5
        int smallestIndex = 0;
        int secondSmallestIndex = 1;
        //System.out.println("createHuffmanTree - IMPLEMENT ME");
        while (this.numberOfTrees > 1)
        {
            // swap smallest to the end

            System.out.println("--->Smallest tree moved to the position " + (this.numberOfTrees - 1));
            smallestIndex = findSmallest(this.numberOfTrees);
            swap(this.numberOfTrees - 1, smallestIndex);
            smallestIndex = this.numberOfTrees - 1;

            // swap second smallest to the end

            System.out.println("--->Second smallest tree moved to the position " + (this.numberOfTrees - 2));
            secondSmallestIndex = smallestIndex - 1;
            int indexToSwapWith = 0;
            boolean found = false;
            for (int i = 0; i < secondSmallestIndex && !found; i++)
            {
                HuffmanTree secSmallest = this.myTrees[secondSmallestIndex];
                if (this.myTrees[i].getRootData().compareTo(secSmallest.getRootData()) <= 0)
                {
                    indexToSwapWith = i;
                    found = true;
                }
            }
            if (!found)
                indexToSwapWith = smallestIndex;
            swap(indexToSwapWith, secondSmallestIndex);
            secondSmallestIndex = smallestIndex - 1;

            // Construct a new combined tree and put in place of the second last tree
            List<Character> combinedCharList = new ArrayList<>();
            HuffmanCode combined;
            HuffmanCode data1 = this.myTrees[smallestIndex].getRootData();
            HuffmanCode data2 = this.myTrees[secondSmallestIndex].getRootData();
            int combinedFrequency = data1.getFrequency() + data2.getFrequency();
            List<Character> data1Symbols = data1.getSymbols();
            List<Character> data2Symbols = data2.getSymbols();
            Iterator<Character> itr1 = data1Symbols.iterator();
            Iterator<Character> itr2 = data2Symbols.iterator();
            if (data1.getFrequency() > data2.getFrequency() || data1.getFrequency() == data2.getFrequency())
            {
                while (itr2.hasNext())
                {
                    combinedCharList.add(itr2.next());
                }
                while (itr1.hasNext())
                {
                    combinedCharList.add(itr1.next());
                }
            }
            else if (data1.getFrequency() < data2.getFrequency())
            {
                while (itr1.hasNext())
                {
                    combinedCharList.add(itr1.next());
                }
                while (itr2.hasNext())
                {
                    combinedCharList.add(itr2.next());
                }
            }
            combined = new HuffmanCode(combinedCharList, combinedFrequency);
            this.myTrees[secondSmallestIndex] = new HuffmanTree(combined, this.myTrees[secondSmallestIndex], this.myTrees[smallestIndex]);
            System.out.println("--->Combined tree created: " + combined.toString());
            System.out.println("--->Combined tree added at position " + (this.numberOfTrees - 2));
            this.numberOfTrees--;
            //secondSmallestIndex--;
        }
    }

    /**
     * swaps two elements in myTrees
     *
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2)
    {
        HuffmanTree temp = this.myTrees[index1];
        this.myTrees[index1] = this.myTrees[index2];
        this.myTrees[index2] = temp;
    }

    /**
     * finds the Huffman tree with the smallest frequency
     *
     * @param last - the index of the last tree to check
     * @return - the index of the "smallest" tree in the given range
     */
    private int findSmallest(int last)
    {
        int smallestAt = 0;
        for (int i = 1; i < last; i++)
        {
            if ((this.myTrees[smallestAt].getRootData()).compareTo(this.myTrees[i].getRootData()) > 0)
            {
                smallestAt = i;
            }
        }
        return smallestAt;
    }

    /**
     * encode a single symbol using a Huffman tree and append
     * the Huffman code to myCode  object
     *
     * @param c the symbol to be encoded.
     */
    public void encodeCharacter(Character c)
    {
        // TODO Project 5
        System.out.println("encodeCharacter - IMPLEMENT ME");
        // make sure that we point to the root
        // at this point we only have one tree
        this.myTrees[0].reset();
        while(!this.myTrees[0].isSingleSymbol())//<-- only look at the trees where the symbol list contains one element
        {

        }

    }

    /**
     * encodes myMessage using the generated Huffman Code by calling
     * the encodeCharacter method for each character in myMessage.
     */
    private void encodeMessage()
    {
        this.myMessage.reset();
        while (this.myMessage.hasNext())
        {
            //fill myCode with the code message
            encodeCharacter(this.myMessage.next());
        }
    }

    /**
     * load the words into the Message
     *
     * @param theFileName the name of the file holding the message
     */
    public boolean loadMessage(String theFileName)
    {
        Scanner input;
        boolean loaded = false;
        try
        {
            input = new Scanner(new File(theFileName));

            while (input.hasNextLine())  // read until  end of file
            {
                this.myMessage.addLine(input.nextLine());
            }
            System.out.println(this.myMessage);
            loaded = true;
        } catch (Exception e)
        {
            System.out.println("There was an error in reading or opening the file: " + theFileName);
            System.out.println(e.getMessage());
        }
        return loaded;
    }

    public void run()
    {
        if (loadMessage("C:\\Users\\Bertrand\\inyouratmosphere\\src\\Lab13\\message4.txt"))
        {
            this.myTrees = createInitialTrees(getCounts());
            this.numberOfTrees = this.myTrees.length;

            System.out.println("Building Huffman Tree");
            createHuffmanTree();

            //the tree is created so let's display it using preOrder
            System.out.println("\nHuffman Tree:");
            this.myTrees[0].preOrderTraverse();
            System.out.println();
            //we can encode now
            encodeMessage();
            System.out.println(this.myCode);
        }
    }


    public static void main(String[] args)
    {
        EncodeApplication encodeApp = new EncodeApplication();
        encodeApp.run();
    }
}