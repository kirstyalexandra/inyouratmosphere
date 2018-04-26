package Lab13;

import java.util.*;
/**
 * @author YOUR NAME
 * @version 4/24/2018
 */

public class WorkingWithHeaps
{
    private ArrayList<Node<Integer>> lists;

    public WorkingWithHeaps()
    {
        this.lists = new ArrayList<>();
        createLists();
    }

    public Node<Integer> mergeKSortedLists()
    {
        Node<Integer> headOfMergedList = null;


        // TODO Project 4b
        PriorityQueue<Node<Integer>> heap;




        return headOfMergedList;
    }

    public void createLists()
    {
        Scanner keyboard = new Scanner(System.in);
        int numberOfLists;
        do
        {
            System.out.println("How many lists to create?");
            numberOfLists = keyboard.nextInt();
        } while (numberOfLists < 1);

        final int MIN_SIZE = 5;
        int maxSize;
        do
        {
            System.out.println("Maximum number of elements for the lists?");
            maxSize = keyboard.nextInt();
        } while (maxSize < MIN_SIZE);

        Random random = new Random(11);
        final int MAX_FIRST_VALUE = 7;
        Node<Integer> firstNode;
        Node<Integer> current;
        int sizeUpTo;
        int randomNumber;

        for (int list = 0; list < numberOfLists; list++)
        {
            firstNode = null;
            current = null;
            sizeUpTo = random.nextInt(maxSize - MIN_SIZE + 1) + MIN_SIZE;
            randomNumber = random.nextInt(MAX_FIRST_VALUE) + 1;
            for (int i = 1; i <= sizeUpTo; i++)
            {
                if (random.nextBoolean())
                {
                    if (firstNode == null)
                    {
                        firstNode = new Node<>(randomNumber);
                        current = firstNode;
                    }
                    else
                    {
                        current.next = new Node<>(randomNumber);
                        current = current.next;
                    }
                    randomNumber += i;
                }
                randomNumber++;
            }
            this.lists.add(firstNode);
        }
        displayCreatedLists();
    }

    private void displayCreatedLists()
    {
        System.out.println("\nCreated lists:");
        // TODO Project 4a

    }

    public static void main(String args[])
    {
        WorkingWithHeaps tester = new WorkingWithHeaps();

        Node<Integer> mergedHead = tester.mergeKSortedLists();
        System.out.println("\nMerged List:");
        if (mergedHead == null)
            System.out.println("The list is empty");
        else
        {
            Node<Integer> current = mergedHead;
            while (current != null)
            {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
        System.out.println("\n*** Done ***");
    } // end main

    private class Node<S>
    {
        private S data;
        private Node<S> next;

        private Node(S dataPortion)
        {
            this.data = dataPortion;
            this.next = null;
        }

        private Node(S dataPortion, Node nextNode)
        {
            this.data = dataPortion;
            this.next = nextNode;
        }
    } // end Node
}
