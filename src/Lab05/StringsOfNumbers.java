package Lab05;

import java.util.Scanner;

/**
 * The class recursively generates strings of n numbers
 *
 * @author YOUR NAME
 * @version 2/20/2018
 */

public class StringsOfNumbers
{
    /**
     * bitString - a recursive function that generates strings of n bits
     *
     * @param n    the number of digits
     * @param str  one permutation of the string to be constructed and printed
     */
    private static void bitString(String str, int n)
    {
        // TODO Project #2
        // IMPLEMENT THIS RECURSIVE METHOD

        // STEP#1 Base case - the string is constructed so print it



        // STEP#2 recursive case - make two recursive calls:
        //                        one to append 0 and the second one to append 1


    }

    /**
     * bitString - a recursive function that generates strings of n digits [0..k)
     *
     * @param n    the number of digits
     * @param k    k-1 should be the largest digit in the string str
     * @param str  one permutation of the string to be constructed and printed
     */
    private static void kString(String str, int n, int k)
    {
        // TODO Project #2
        // IMPLEMENT THIS RECURSIVE METHOD

    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer value of n representing the number of digits in a string");
        int n = input.nextInt();
        System.out.println();
        System.out.println("Generating binary-Strings:");
        bitString("", n);
        System.out.println();
        System.out.println("Please enter an integer value k; strings of length n will be drown from 0..k-1");

        int k = input.nextInt();
        System.out.println("Generating k-Strings:");
        kString("", n, k);
    }
}
