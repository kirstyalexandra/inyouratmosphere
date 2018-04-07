package Lab10;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class BinarySearchTest
{
    public int binarySearch(int [] a, int desiredItem)
    {
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        boolean found = false;
        while (left <= right && !found)
        {
            mid = left + (right - left)/2;
            if (desiredItem > a[mid])
            {
                left = mid + 1;
            }
            else if (desiredItem < a[mid])
            {
                right = mid - 1;
            }
            else
            {
                found = true;
                return mid;
            }
        }
        if (!found)
        {
            mid++;
        }
        return mid;
    }

    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        BinarySearchTest bst = new BinarySearchTest();
        int [] testValues = {2, 9, 17, 26, 37, 44, 50, 68, 74};
        System.out.println("Here is the sorted array: ");
        for (int i = 1; i <= testValues.length; i++)
        {
            System.out.print(+ testValues[i - 1] + " ");
        }
        System.out.println("\nEnter a target value: ");
        int target = keyboard.nextInt();
        int index = bst.binarySearch(testValues, target);
        System.out.println("The target was found at " + index);
    }
}
