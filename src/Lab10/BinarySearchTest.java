package Lab10;

import java.util.Scanner;

public class BinarySearchTest
{
    private int binarySearch(int[] sortedArray, int target, int start, int end) {

        if(start <= end)
        {
            int mid = (start + end)/2;
            if(sortedArray[mid] == (target))
            {
                return mid;
            }
            else if (target < sortedArray[mid])
            {
                return binarySearch(sortedArray, target, start, mid - 1);
            }
            else {
                return binarySearch(sortedArray, target, mid + 1, end);
            }
        }
        return start;
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
        int index = bst.binarySearch(testValues, target, 0, testValues.length - 1);
        System.out.println("The target was found at " + index);
    }
}
