package Lab10;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

// TODO Project 4
/**
 * A class for finding an interval in a sorted array that holds everything in a list of the target data values.
 *
 * Consider an array data of n numerical values in sorted order and a list of numerical target values. Your goal is to
 * compute the smallest range of array indices that contains all of the target values.
 *
 * If a target value is smaller than data[0], the range should start with -1.
 * If a target value is larger than data[n - 1], the range should end with n.
 *
 * For example, given the array: 5 8 10 13 15 20 22 26 and the target values (8, 2, 9, 17), the range is -1 to 5.
 *
 * Devise and implement an efficient algorithm that solves this problem.
 * HINT:
 *    1) Find the max target and min target in the list of target values.
 *    2) Utilize the iterative binary search algorithm to find the position that min target and max target values
 *       would have if inserted into the list of sorted data.
 *
 *
 * @author Kirsty Alexandra Nguegang
 * @version 4/3/2018
 */

public class IntervalSearch
{
	/* Finds the smallest interval in the sortedData holding all the target values.
	 * @param sortedData    a sorted array of comparable values (n >= 1)
	 * @param targetValues  a list of comparable values (m >= 1)
	 * @return an ordered pair of integers, where the first value is the largest
	 *         index i in the sorted data such that data[i] is smaller than all target values.
	 *         If a target value is smaller than data[0], return -1.
	 *         The second value in the pair is the smallest index j in the sorted data such that
	 *         data[j] is greater than all target values. If a target value is larger than 
	 *         the last value in data, return the n.
	 */
	public static <T extends Comparable<? super T>>
	Interval findInterval(T[] sortedData, TreeSet<T> targetValues)
	{
		int leftBoundary = -1;
		int rightBoundary = sortedData.length;
		//System.out.println("Inside the findInterval method - you need to implement me iteratively");
		//System.out.println("Target list is " + targetValues);
		// STEP 1 - Run the code first before starting the implementation
		if (sortedData.length > 0 && targetValues.size() > 0)
		{
			// YOUR CODE GOES HERE
			// Implement the method WITHOUT RECURSION
			// STEP 2 - get the smallest and the largest targets
			T smallestTarget = targetValues.pollFirst();
			T largestTarget = targetValues.pollLast();
			if (largestTarget == null)
			{
				System.out.println("Target list is ["+ smallestTarget +"]");
				largestTarget = smallestTarget;
			}
			else
			{
				System.out.println("Target list is [" + smallestTarget + ", " + largestTarget + "]");
			}
				// STEP 3 - utilizing the binary search algorithm search for the smallest target
			//          DO NOT USE RECURSION
			if ((smallestTarget.compareTo(sortedData[0]) < 0))
			{
				leftBoundary = -1;
			}
			else if (smallestTarget.compareTo(sortedData[sortedData.length - 1]) > 0)
			{
				leftBoundary = sortedData.length;
			}
			else
			{
				boolean found = false;
				int left = 0;
				int right = sortedData.length - 1;
				int mid = 0;

				while (left <= right && !found)
				{
					mid = left + (right - left) / 2;
					int comparison = smallestTarget.compareTo(sortedData[mid]);
					if (comparison > 0)
					{
						left = mid + 1;
					}
					else if (comparison < 0)
					{
						right = mid - 1;
					}
					else
					{
						found = true;
						leftBoundary = mid;
						int i = mid;
						while (sortedData[i - 1].compareTo(smallestTarget) == 0)
						{
							i--;
							leftBoundary = i;
						}

					}
				}
				if (!found)
					leftBoundary = right;
			}

			// STEP 4 - set the left boundary to the appropriate index


			// STEP 5 - utilizing the binary search algorithm search for the largest target
			//          DO NOT USE RECURSION
			//          NOTE that you can reduce the searches by setting the left index
			//               to the leftBoundary that you calculated in step 4
			if (largestTarget.compareTo(sortedData[1]) < 0)
			{
				rightBoundary = -1;
			}
			else if (largestTarget.compareTo(sortedData[sortedData.length - 1]) > 0)
			{
				rightBoundary = sortedData.length;
			}
			else
			{
				boolean found = false;
				int left = leftBoundary;
				int right = sortedData.length - 1;
				int mid = 0;

				while (left <= right && !found)
				{
					mid = left + (right - left) / 2;
					int comparison = largestTarget.compareTo(sortedData[mid]);
					if (comparison > 0)
					{
						left = mid + 1;
					}
					else if (comparison < 0)
					{
						right = mid - 1;
					}
					else
					{
						found = true;
						rightBoundary = mid;
						int i = mid;
						while (sortedData[i + 1].compareTo(largestTarget) == 0) // checking for duplicates
						{
							i++;
							rightBoundary = i;
						}

					}
				}
				if (!found)
					rightBoundary = left;
			}
			// STEP 6 - set the right boundary to the appropriate index
		}

		return new Interval(leftBoundary, rightBoundary);
	} // end findInterval

	/**
	 * Initialize the list of ints by reading them from the keyboard
	 * @return a list of integers 
	 */
	public static TreeSet<Integer> getTargetValues()
	{
		TreeSet<Integer> targets = new TreeSet<Integer>();
		System.out.println("Enter the list of integer values separated by spaces (all on one line), " +
		"or just press enter if you are done.");
		Scanner keyboard = new Scanner(System.in);      
		Scanner dataValues = new Scanner(keyboard.nextLine());

		while (dataValues.hasNextInt())
		{
			targets.add(dataValues.nextInt());            
		}       
		return targets;
	}

	public static void main(String args[])
	{
		Random generator = new Random(7);
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many elements in the array?");
		final int DEFAULT = 10;
		int size;

		try
		{
			size = keyboard.nextInt();

		}
		catch(NumberFormatException e)
		{
			System.out.println("Could not convert input to an integer");
			System.out.println(e.getMessage());
			System.out.println("Will use " + DEFAULT + " as the default value");
            size = DEFAULT;
		}        

		// generate a random array of integers
		Integer sortedData[] = new Integer[size];
		for(int i = 0; i < size; i++)
		{
			sortedData[i] = generator.nextInt(10);

			// guarantee is larger than the last value
			if (i > 0 && sortedData[i] < sortedData[i-1])
				sortedData[i] += sortedData[i-1];
		}

		System.out.println("The sorted data is:");  
		for (int i = 0; i < size; i++)
		{
			System.out.print("["+ i + "]="  + sortedData[i] + "  ");
		}
		System.out.println();

		//get the target values
		TreeSet<Integer> targets = getTargetValues();           
		while (targets.size() > 0)
		{
			System.out.println("The interval is: " + findInterval(sortedData, targets));
			System.out.println();
			targets = getTargetValues();
		}
		System.out.println("\n*** Done ***");
	}
} // end SearchArray