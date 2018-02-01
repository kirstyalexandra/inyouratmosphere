package Lab02;/** * A class that implements the ADT set by using a ResizableArrayBag. * * @author YOUR NAME * @version 1/30/2018 */public class ArraySetWithResizableArrayBag<T extends Comparable<? super T>> implements SetInterface<T>{    private ResizableArrayBag<T> bagOfSetEntries;    public ArraySetWithResizableArrayBag()    {        //TODO Project1        this.bagOfSetEntries = new ResizableArrayBag<>();    } // end default constructor    public ArraySetWithResizableArrayBag(int capacity)    {        //TODO Project1        this.bagOfSetEntries = new ResizableArrayBag<>(capacity);    } // end of secondary constructor    public ArraySetWithResizableArrayBag(T[] contents)    {        //TODO Project1    }    public void clear()    {        this.bagOfSetEntries.clear();    } // end clear    public boolean add(T newEntry)    {        //TODO Project1        boolean addEntry = false;        if(!this.bagOfSetEntries.contains(newEntry))        {            add(newEntry);            addEntry = true;        }        return addEntry; //THIS IS A STUB    } // end add    public boolean removeElement(T anEntry)    {        //TODO Project1        boolean element = false;        if(this.bagOfSetEntries.contains(anEntry))        {            removeElement(anEntry);            element = true;        }        return element; //THIS IS A STUB    } // end remove    public T remove()    {        //TODO Project1        if (!this.bagOfSetEntries.isEmpty())        {            remove();        }        return null; //THIS IS A STUB    } // end remove    public boolean contains(T anEntry)    {        //TODO Project1        boolean entryContain = false;        if (this.bagOfSetEntries.contains(anEntry))        {            entryContain = true;        }        else        {            entryContain = false;        }        return entryContain; //THIS IS A STUB    } // end contains    public int getCurrentSize()    {        //TODO Project1        return 0; //THIS IS A STUB    } // end getCurrentSize    public boolean isEmpty()    {        //TODO Project1        return false; //THIS IS A STUB    } // end getLength    public T[] toArray()    {        //TODO Project1        return null; //THIS IS A STUB    } // end toArray    // Displays a set.    public void displaySet()    {        //TODO Project1    } // end displaySet    public static void main(String[] args)    {        String[] inputData = {"A", "B", "C", "D", "A", "C", "B", "B"};        System.out.println("Creating aSet with the secondary constructor - capacity of " + inputData.length);        SetInterface<String> aSet = new ArraySetWithResizableArrayBag<>(inputData.length);        System.out.println("Adding elements from inputData to aSet");        for (int i = 0; i < inputData.length; i++)            aSet.add(inputData[i]);        aSet.displaySet();        System.out.println("\nClearing aSet");        aSet.clear();        aSet.displaySet();        System.out.println("aSet isEmpty returns " + aSet.isEmpty());        System.out.println("The size of aSet is " + aSet.getCurrentSize());        System.out.println("\nCreating set1 with default constructor");        SetInterface<String> set1 = new ArraySetWithResizableArrayBag<>();        // Initial capacity is 3        System.out.println("\nset1 initially empty, capacity of 3: ");        set1.displaySet();        System.out.println("\nAdding elements to set1");        set1.add("A");        set1.add("A");        set1.add("B");        set1.add("A");        set1.add("C");        set1.add("A");        System.out.println("\nset1 after adding elements: ");        set1.displaySet();        System.out.println("\nset1 after adding more elements which should trigger resizing: ");        set1.add("V");        set1.add("V");        set1.add("T");        set1.add("U");        set1.add("V");        set1.add("W");        set1.add("X");        set1.add("Y");        set1.add("Z");        set1.displaySet();        System.out.println("\nCreating set2 with the secondary constructor that takes an array as input");        SetInterface<String> set2 = new ArraySetWithResizableArrayBag<>(inputData);        System.out.println("Adding more elements to set2");        set2.add("A");        set2.add("B");        set2.add("B");        set2.add("A");        set2.add("C");        set2.add("C");        set2.add("D");        set2.add("E");        set2.add("F");        set2.add("G");        set2.add("H");        System.out.println("set2 after adding and resizing: ");        set2.displaySet();        System.out.println("\nset1 contains A: " + set1.contains("A"));        System.out.println("set1 contains E: " + set1.contains("E"));        set1.removeElement("B");        System.out.println("After removing B from set1:");        set1.displaySet();        System.out.println("After removing " + set1.remove()                + " from set1:");        set1.displaySet();    }} // end ArraySetWithResizableArrayBag