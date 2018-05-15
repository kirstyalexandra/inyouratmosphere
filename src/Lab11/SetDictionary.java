package Lab11;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * @author Kirsty Alexandra Nguegang
 * @version 4/10/2018
 */

public class SetDictionary<K extends Comparable<? super K>> implements SetInterface<K>, Iterable<K>
{
    private TreeMap<K, Boolean> items;

    public SetDictionary()
    {
       // TODO Project 1
        this.items = new TreeMap<>();
    } // end default constructor

    public boolean add(K newEntry)
    {
        // TODO Project
        boolean result = true;
        if (this.items.put(newEntry, true) == null)
        {
            result = false;
        }
        return result;
    } // end add

    public boolean remove(K anEntry)
    {
        // TODO Project 1
        return this.items.remove(anEntry, true);
    } // end remove

    public void clear()
    {
        // TODO Project 1
        this.items.clear();
    } // end clear

    public boolean contains(K anEntry)
    {
        // TODO Project 1
        return this.items.containsKey(anEntry);
    } // end contains

    public int getCurrentSize()
    {
        // TODO Project 1
        return this.items.size();
    } // end getCurrentSize

    public boolean isEmpty()
    {
        // TODO Project 1
        return this.items.size() == 0;
    } // end isEmpty

    public boolean equals(Object o)
    {
        // TODO Project 1
        boolean same = false;
        if (this.items == o)
        {
            same = true;
        }
        else if (o == null || getClass() != o.getClass())
        {
            same = false;
        }
        else
        {
            SetDictionary<K> other = (SetDictionary<K>) o;
            if (this.items.equals(other.items))
            {
                same = true;
            }
        }
        return same;
    } // equals

    public Iterator<K> getIterator()
    {
        // TODO Project 1
        return this.items.keySet().iterator();
    } // end getIterator

    public Iterator<K> iterator()
    {
        // TODO Project 1
        return getIterator();
    } // end iterator

    public K[] toArray()
    {
        // TODO Project 1
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        K[] result = (K[]) new Comparable[getCurrentSize()]; // unchecked cast
        Set<K> keys = this.items.keySet();
        Iterator<K> itr = keys.iterator();
        int i = 0;
        while (itr.hasNext())
        {
            result[i] = itr.next();
            i++;
        }
        //MUST BE IMPLEMENTED WITH ITERATOR
        return result;
    } // end toArray

    public SetInterface<K> union(SetInterface<K> otherSet)
    {
        // TODO Project 1
        SetDictionary<K> other = (SetDictionary<K>) otherSet;
        SetInterface<K> result = new SetDictionary<>();

        this.items.forEach((k, v) -> result.add(k));
        other.items.forEach((k, v) -> result.add(k));

        return result;
        //MUST BE IMPLEMENTED WITH ITERATORS USING forEach lambda CONSTRUCT
        // AS SHOWN IN LectureDictionary EXAMPLES

    } // end union

    public SetInterface<K> intersection(SetInterface<K> otherSet)
    {
        // TODO Project 1
        SetInterface<K> result = new SetDictionary<>();
        SetDictionary<K> other = (SetDictionary<K>) otherSet;
        Iterator<K> otherItr = other.iterator();
        Iterator<K> itemsItr = iterator();
        try
        {
                K otherItem = otherItr.next();
                K item = itemsItr.next();
                int comparison = item.compareTo(otherItem);
                while (true)
                {
                    if (comparison == 0)
                    {
                        result.add(item);
                        item = itemsItr.next();
                        otherItr.next();
                    }
                    else if (comparison < 0)
                    {
                        item = itemsItr.next();
                    }
                    else
                    {
                        otherItr.next();
                    }
                }
        }
        catch (NoSuchElementException nsee)
        {
            System.out.println("Finished creating intersection.");
        }
        return result;
    } // end intersection

    public static void main(String args[])
    {
        System.out.println("CREATING set1");
        SetInterface<Integer> set1 = new SetDictionary<>();
        set1.add(1);
        set1.add(3);
        set1.add(2);
        set1.add(0);
        set1.add(-1);

        System.out.println("--> set1 has " + set1.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println();

        System.out.println("--> contains for -1 yields " + set1.contains(-1));
        System.out.println("--> contains for -2 yields " + set1.contains(-2));
        System.out.println("--> contains for 3 yields " + set1.contains(3));
        System.out.println("--> contains for 4 yields " + set1.contains(4));

        set1.add(1);
        System.out.println("\n--> Added 1 again to the set1, should be the same");
        System.out.println("--> set1 has " + set1.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println();

        System.out.println("--> Iterating over set1 utilizing getIterator method");
        Iterator<Integer> kIter = set1.getIterator();
        while (kIter.hasNext())
        {
            System.out.println("\t" + kIter.next());
        } // end while

        System.out.println("--> Iterating over set1 utilizing iterator method");
        kIter = ((SetDictionary<Integer>) set1).iterator();
        while (kIter.hasNext())
        {
            System.out.println("\t" + kIter.next());
        } // end while

        System.out.println("--> Iterating over set1 utilizing forEach lambda");
        ((SetDictionary<Integer>) set1).items.forEach((k,v) -> System.out.println("\t " + k));

        System.out.println("\n--> Removing -1 20 3 from set1:");
        boolean result = set1.remove(-1);
        if (result)
            System.out.println("---> -1 was removed - CORRECT");
        else
            System.out.println("---> -1 was not removed - INCORRECT");
        result = set1.remove(20);
        if (result)
            System.out.println("---> 20 was removed - INCORRECT");
        else
            System.out.println("---> 20 was not removed - CORRECT");
        result = set1.remove(3);
        if (result)
            System.out.println("---> 3 was removed - CORRECT");
        else
            System.out.println("---> 3 was not removed - INCORRECT");

        System.out.println("--> Should just have 0 1 and 2 now");
        System.out.println("--> set1 has " + set1.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println();

        System.out.println("CREATING set2");
        SetInterface<Integer> set2 = new SetDictionary<>();
        set2.add(1);
        set2.add(3);
        set2.add(2);
        set2.add(-1);
        set2.add(5);
        set2.add(8);

        System.out.println("--> set2 has " + set2.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set2.toArray()));
        System.out.println();

        if (set1.equals(set2))
            System.out.println("set1 and set2 are the same - INCORRECT");
        else
            System.out.println("set1 and set2 are NOT the same - CORRECT");
        System.out.println();

        System.out.println("CREATING UNION OF set1 and set2");
        SetInterface<Integer> testUnion = set1.union(set2);
        System.out.print("--> The union of set1 and set2 has " + testUnion.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(testUnion.toArray()));
        System.out.println();

        System.out.println("--> set1 should be unchanged");
        System.out.println("--> set1 has " + set1.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println();

        System.out.println("--> set2 should be unchanged");
        System.out.println("--> set2 has " + set2.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set2.toArray()));
        System.out.println();

        System.out.println("CREATING UNION OF set1 and set1");
        testUnion = set1.union(set1);
        System.out.print("--> The union of set1 and set1 has " + testUnion.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(testUnion.toArray()));
        System.out.println();

        if (set1.equals(testUnion))
            System.out.println("set1 and testUnion are the same - CORRECT");
        else
            System.out.println("set1 and testUnion are NOT the same - INCORRECT");
        System.out.println();

        System.out.println("CREATING INTERSECTION OF set1 and set2");
        SetInterface<Integer> testIntersection = set1.intersection(set2);
        System.out.print("--> The intersection of set1 and set2 has " + testIntersection.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(testIntersection.toArray()));
        System.out.println();

        System.out.println("--> set1 should be unchanged");
        System.out.println("--> set1 has " + set1.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println();

        System.out.println("--> set2 should be unchanged");
        System.out.println("--> set2 has " + set2.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set2.toArray()));
        System.out.println();

        System.out.println("CREATING INTERSECTION OF set2 and set1");
        testIntersection = set2.intersection(set1);
        System.out.print("--> The intersection of set2 and set1 has " + testIntersection.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(testIntersection.toArray()));
        System.out.println();

        System.out.println("--> set1 should be unchanged");
        System.out.println("--> set1 has " + set1.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println();

        System.out.println("--> set2 should be unchanged");
        System.out.println("--> set2 has " + set2.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set2.toArray()));
        System.out.println();

        System.out.println("CREATING INTERSECTION OF set2 and set2");
        testIntersection = set2.intersection(set2);
        System.out.print("--> The intersection of set2 and set2 has " + testIntersection.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(testIntersection.toArray()));
        System.out.println();

        System.out.println("--> set1 should be unchanged");
        System.out.println("--> set1 has " + set1.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println();

        System.out.println("--> set2 should be unchanged");
        System.out.println("--> set2 has " + set2.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set2.toArray()));
        System.out.println();

        if (set2.equals(testIntersection))
            System.out.println("set2 and testIntersection are the same - CORRECT");
        else
            System.out.println("set2 and testIntersection are NOT the same - INCORRECT");
        System.out.println();

        System.out.println("CREATING INTERSECTION OF testUnion and set2");
        testIntersection = testUnion.intersection(set2);
        System.out.print("--> The intersection of testUnion and set2 has " + testIntersection.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(testIntersection.toArray()));
        System.out.println();

        System.out.println("--> testUnion should be unchanged");
        System.out.println("--> testUnion has " + testUnion.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(testUnion.toArray()));
        System.out.println();

        System.out.println("--> set2 should be unchanged");
        System.out.println("--> set2 has " + set2.getCurrentSize() + " items: ");
        System.out.println(Arrays.toString(set2.toArray()));
        System.out.println();

        if (set2.equals(testIntersection))
            System.out.println("set2 and testIntersection are the same - INCORRECT");
        else
            System.out.println("set2 and testIntersection are NOT the same - CORRECT");
        System.out.println();
    } // end main
}
