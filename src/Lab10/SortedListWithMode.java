package Lab10;

/**
 * A class that implements the ADT sorted list by using a chain of linked nodes.
 * Duplicate entries are allowed.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 *
 * @author Kirsty Alexandra Nguegang
 * @version 4/3/2018
 */
public class SortedListWithMode <T>
{
    private SortedLinkedList<Integer> myList;

    public SortedListWithMode()
    {
        this.myList = new SortedLinkedList<>();
    }

    public void add (Integer element)
    {
        this.myList.add(element);
    }

    public String toString()
    {
        String content = "has " + this.myList.getLength() + " element(s): ";
        for (int i = 1; i <= this.myList.getLength(); i++)
        {
            content += this.myList.getEntry(i) + " ";

        }
        return content;
    }

    // Part c: Using only the public methods of SortedLinkedList,
    // find the mode. The mode is the most frequent value.
    // NOTE - this list is 1 based
    public Integer getMode()
    {
        // TODO Project 2c
        Integer mode = null;
        int modeCount = 0;
        int maybeModeCount = 0;
        Integer max = null;

        if (mode != null && this.myList.getLength() > 2)
        {
            for (int i = 1; i < this.myList.getLength(); i++)
            {
                if (this.myList.getEntry(i + 1).equals(this.myList.getEntry(i)))
                {
                    modeCount++;
                    mode = this.myList.getEntry(i + 1);
                }
                else
                {
                    
                }
            }
        }
//
//        System.out.println("IMPLEMENT Part c: Using only the public methods of SortedLinkedList,"
//                + "find the mode. The mode is the most frequent value.");
//        System.out.println("NOTE - the list is 1 based!");

        System.out.println("---> mode is " + mode + "; mode count is " + modeCount );
        return mode;
    } // end getMode

    public static void main(String args[])
    {
        SortedListWithMode<Integer> data = new SortedListWithMode<>();
        System.out.println("The mode of the empty list should be null, got: " + data.getMode());

        // test list of 1 element
        data.add(9);
        System.out.println("\nThe data " + data);
        System.out.println("The mode should be 9, got: " + data.getMode());

        // test list of 2 elements
        data.add(13);
        System.out.println("\nThe data " + data);
        System.out.println("The mode should be 9, got: " + data.getMode());

        // test list of 3 elements
        data.add(13);
        System.out.println("\nThe data " + data);
        System.out.println("The mode should be 13, got: " + data.getMode());

        // test list of 3 elements
        data = new SortedListWithMode<>();
        data.add(9);
        data.add(9);
        data.add(13);
        System.out.println("\nThe data " + data);
        System.out.println("The mode should be 9, got: " + data.getMode());

        data = new SortedListWithMode<>();
        for (int i = 0; i < 10; i++)
            data.add(i);
        System.out.println("\nThe data " + data);
        System.out.println("The mode should be 0, got: " + data.getMode());

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < i; j++)
                data.add(i);
        System.out.println("\nThe data " + data);
        System.out.println("The mode should be 9, got: " + data.getMode());

        for (int i = 0; i < 21; i++)
            for (int j = 8; j < i; j++)
                data.add(i);
        System.out.println("\nThe data " + data);
        System.out.println("The mode should be 20, got: " + data.getMode());

        for (int i = 0; i < 14; i++)
            data.add(6);
        System.out.println("\nThe data " + data);
        System.out.println("The mode should be 6, got: " + data.getMode());



        System.out.println("\n*** Done ***");
    } // end main
}
