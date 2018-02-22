package Lab04;/**   An interface for the ADT stack.   @author Frank M. Carrano   @author Timothy M. Henry   @version 4.0*/public interface TextbookStackInterface<T>{   /** Adds a new entry to the top of this stack.       @param newEntry  An object to be added to the stack. */   public void push(T newEntry);     /** Removes and returns this stack's top entry.       @return  The object at the top of the stack.        throws  appropriate exception if the stack is empty before the operation. */   public T pop();     /** Retrieves this stack's top entry.       @return  The object at the top of the stack.       throws  appropriate exception if the stack is empty. */   public T peek();     /** Detects whether this stack is empty.       @return  True if the stack is empty. */   public boolean isEmpty();     /** Removes all entries from this stack. */   public void clear();    /** ADDED TO TEST THE ARRAY IMPLEMENTATION ONLY */    public int getTopIndex();    public int getCapacity();} // end StackInterface