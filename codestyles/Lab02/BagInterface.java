package codestyles.Lab02;/** * ResizableArrayBag * An interface that describes the operations of a bag of objects. * * @author Frank M. Carrano *         modified by atb * @version 1/30/2018 */public interface BagInterface<T extends Comparable<? super T>>{    /**     * Gets the current number of entries in this bag.     *     * @return the integer number of entries currently in the bag     */    public int getCurrentSize();    /**     * Sees whether this bag is empty.     *     * @return true if the bag is empty, or false if not     */    public boolean isEmpty();    /**     * Adds a new entry to this bag.     *     * @param newEntry the object to be added as a new entry     * @return true if the addition is successful, or false if not     */    public boolean add(T newEntry);    /**     * Removes one unspecified entry from this bag, if possible.     *     * @return either the removed entry, if the removal     * was successful, or null     */    public T remove();    /**     * Removes one occurrence of a given entry from this bag.     *     * @param anElement the entry to be removed     * @return true if the removal was successful, or false if not     */    public boolean removeElement(T anElement);    /**     * Removes all entries from this bag.     */    public void clear();    /**     * Counts the number of times a given entry appears in this bag.     *     * @param anEntry the entry to be counted     * @return the number of times anEntry appears in the bag     */    public int getFrequencyOf(T anEntry);    /**     * Tests whether this bag contains a given entry.     *     * @param anEntry the entry to locate     * @return true if this bag contains anEntry, or false otherwise     */    public boolean contains(T anEntry);    /**     * Retrieves all entries that are in this bag.     *     * @return a newly allocated array of all the entries in the bag     */    public T[] toArray();    /**     * Displays all the elements in the bag     */    public void display();    /**     * Checks if the given bag called otherBag is the same as this bag     *     * @param otherBag the other bag to be compared with     * @return true both bags are the same     */    public boolean equals(Object otherBag);    /**     * Removes the largest entry from the this.bag     *     * @return - null if the element was not found or the largest element     */    public T removeMax();    /**     * Removes every occurrence of a given entry from this bag.     *     * @param anEntry the entry to be removed     */    public void removeEvery(T anEntry);    /**     * Replaces an entry in this bag with a given object.     *     * @param replacement the given object     * @return the original entry in the bag that was replaced     */    public T replace(T replacement);    /**     * Creates a new bag that combines the contents of this bag and a     * second given bag without affecting the original two bags.     *     * @param otherBag the given bag     * @return a bag that is the union of the two bags     */    public BagInterface<T> union(BagInterface<T> otherBag);    /**     * Creates a new bag that contains those objects that occur in both this     * bag and a second given bag without affecting the original two bags.     *     * @param otherBag the given bag     * @return a bag that is the intersection of the two bags     */    public BagInterface<T> intersection(BagInterface<T> otherBag);    /**     * Creates a new bag of objects that would be left in this bag     * after removing those that also occur in a second given bag     * without affecting the original two bags.     *     * @param otherBag the given bag     * @return a bag that is the difference of the two bags     */    public BagInterface<T> difference(BagInterface<T> otherBag);    /**     * Checks if all the elements of the given bag are also included in the other bag     *     * @param otherBag bag to check     * @return returns true if all the elements of the given bag are also included in the other bag     */    public boolean isSubset(BagInterface<T> otherBag);    /**     * Creates a new bag of objects that are in this bag and are less than a given object.     *     * @param anEntry a given object     * @return a new bag of objects that are in this bag and are less than anObject     */    public BagInterface<T> getAllLessThan(T anEntry);} // end BagInterface