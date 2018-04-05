package Lab10;
/**************************************************************
 * RECURSIVE TRINARY SEARCH
 *        ARRAY MUST BE SORTED
 *
 * The recursive trinarySearch method returns true or false depending if the element was found or not.
 * The trinarySearch method works in a similar manner to a binary search except it uses two mid values
 * that “divide” the array into three portions. So, it needs to consider three recursive scenarios:
 * i.	desired item is smaller than the element at index mid1
 * ii.	desired item is greater than the element at index mid2
 * iii.	desired item is smaller than the element at index mid2 but is greater than the element at index mid1
 *
 * Use the following formulas to calculate mid indexes:
 *
 *     int mid1 = left + (right - left)/3;
 *     int mid2 = right - (right - left)/3;
 *
 *
 * Utilize compareTo method, save the value(s) and use them in comparisons
 **************************************************************
 *
 * @author  Kirsty Alexandra Nguegang
 * @version 4/3/2018
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TrinarySearch
{
    /** Task: Searches for a value in an array.
     * @param a an array of Comparable objects
     * @param desiredItem an item to search for   
     * @param n an integer > 0 
     */
    public static <T extends Comparable<? super T>>
    boolean trinarySearch(T[] a, T desiredItem, int n)
    {
        // it is assumed that the data is already sorted
        return trinarySearch(a, 0, n-1, desiredItem);
    } // end trinarySearch

    /** Task: recursive trinarySearch search through an array of objects.
     * @param a an array of Comparable objects
     * @param desiredItem an item to search for   
     * @param left an integer >= 0
     * @param right an integer > left and < a.length
     */

    public static <T extends Comparable<? super T>>
    boolean trinarySearch(T[] a, int left, int right, T desiredItem )
    {
        // TODO Project 1
        boolean found = false;
        int mid1 = left + (right - left)/3;
        int mid2 = right - (right - left)/3;

        if (left > right)
        {
            return false;
        }
        else
        {
            int comparison1 = desiredItem.compareTo(a[mid1]);
            int comparison2 = desiredItem.compareTo(a[mid2]);
            if (comparison1 == 0 || comparison2 == 0)
            {
                return true;
            }
            else if (comparison1 < 0)
            {
                return trinarySearch(a, left, mid1 - 1, desiredItem);
            }
            else if (comparison2 > 0)
            {
                return trinarySearch(a, mid2 + 1, right, desiredItem);
            }
            else
            {
                return trinarySearch(a, mid1 + 1, mid2 - 1, desiredItem);
            }
        }
    } // end trinarySearch

    public static void main( String [ ] args )
    {
        ArrayList<Integer> accounts = new ArrayList<>( );

        try
        {
            Scanner file = new Scanner( new File ("accounts.txt") );

            while ( file.hasNext( ) ) // test for the end of the file
            {
                // read a line
                try
                {
                    accounts.add( file.nextInt() );
                }
                catch ( NumberFormatException nfe )
                {
                    System.out.println( "Error in input file ignoring" );
                }
            }

            // release resources associated with flights.txt
            file.close( );

            // print the accounts read
            System.out.println("Accounts are:");
            for ( int index = 0; index < accounts.size(); index++ )
            {
                System.out.println( "[" + index + "] " + accounts.get(index) );
            }

            Integer[] accountsU = accounts.toArray(new Integer[accounts.size()]);
            Integer[] accountsS = Arrays.copyOf(accountsU, accountsU.length);
            Arrays.sort(accountsS);

            System.out.println("Sorted accounts are:");
            for ( int index = 0; index < accountsS.length; index++ )
            {
                System.out.println( "[" + index + "] " + accountsS[index] );
            }
            boolean foundT = trinarySearch(accountsS, 7881200, accountsS.length);
            int foundB = Arrays.binarySearch(accountsS, 7881200);
            System.out.println("\ntrinarySearch: element 7881200 is found " + foundT);
            if (foundT && foundB >= 0 || !foundT && foundB < 0)
                System.out.println("   PASS");
            else
                System.out.println("   FAIL");

            foundT = trinarySearch(accountsS, 7881199, accountsS.length);
            foundB = Arrays.binarySearch(accountsS, 7881199);
            System.out.println("\ntrinarySearch: element 7881199 is found " + foundT);
            if (foundT && foundB >= 0 || !foundT && foundB < 0)
                System.out.println("   PASS");
            else
                System.out.println("   FAIL");

            foundT = trinarySearch(accountsS, 7881201, accountsS.length);
            foundB = Arrays.binarySearch(accountsS, 7881201);
            System.out.println("\ntrinarySearch: element 7881201 is found " + foundT);
            if (foundT && foundB >= 0 || !foundT && foundB < 0)
                System.out.println("   PASS");
            else
                System.out.println("   FAIL");

            foundT = trinarySearch(accountsS, 2222222, accountsS.length);
            foundB = Arrays.binarySearch(accountsS, 2222222);
            System.out.println("\ntrinarySearch: element 2222222 is found " + foundT);
            if (foundT && foundB >= 0 || !foundT && foundB < 0)
                System.out.println("   PASS");
            else
                System.out.println("   FAIL");

            foundT = trinarySearch(accountsS, 9999999, accountsS.length);
            foundB = Arrays.binarySearch(accountsS, 9999999);
            System.out.println("\ntrinarySearch: element 9999999 is found " + foundT);
            if (foundT && foundB >= 0 || !foundT && foundB < 0)
                System.out.println("   PASS");
            else
                System.out.println("   FAIL");

            foundT = trinarySearch(accountsS, 0000000, accountsS.length);
            foundB = Arrays.binarySearch(accountsS, 0000000);
            System.out.println("\ntrinarySearch: element 0000000 is found " + foundT);
            if (foundT && foundB >= 0 || !foundT && foundB < 0)
                System.out.println("   PASS");
            else
                System.out.println("   FAIL");

            foundT = trinarySearch(accountsS, 1111111, accountsS.length);
            foundB = Arrays.binarySearch(accountsS, 1111111);
            System.out.println("\ntrinarySearch: element 1111111 is found " + foundT);
            if (foundT && foundB >= 0 || !foundT && foundB < 0)
                System.out.println("   PASS");
            else
                System.out.println("   FAIL");

            foundT = trinarySearch(accountsS, 1005231, accountsS.length);
            foundB = Arrays.binarySearch(accountsS, 1005231);
            System.out.println("\ntrinarySearch: element 1005231 is found " + foundT);
            if (foundT && foundB >= 0 || !foundT && foundB < 0)
                System.out.println("   PASS");
            else
                System.out.println("   FAIL");

            foundT = trinarySearch(accountsS, 8777541, accountsS.length);
            foundB = Arrays.binarySearch(accountsS, 8777541);
            System.out.println("\ntrinarySearch: element 8777541 is found " + foundT);
            if (foundT && foundB >= 0 || !foundT && foundB < 0)
                System.out.println("   PASS");
            else
                System.out.println("   FAIL");
            System.out.println("\n*** Done ***");
        }

        catch ( FileNotFoundException fnfe )
        {
            System.out.println( "Unable to find accounts.txt" );
        }

        catch ( IOException ioe )
        {
            ioe.printStackTrace( );
        }
    }
}
