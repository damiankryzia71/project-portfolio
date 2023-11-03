// 
//  Name:     Kryzia, Damian 
//  Project:  4 
//  Due:      12/02/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            This generic Stack interface is used to implement the stack
//            data structure by stack classes.
// 

/**
 * Generic interface representing the stack data type.
 * It is to be implemented by stack classes.
 */
public interface Stack<T> {

    /**
     * Pushes a new entry on top of the stack.
     * @param newEntry A new entry to be placed on top of the stack.
     */
    public void push(T newEntry);

    /**
     * Removes an entry from the top of the stack.
     * @return The removed entry.
     */
    public T pop();

    /**
     * Returns the entry that is on top of the stack without
     * affecting the stack itself.
     * @return The entry that is currently on top of the stack.
     */
    public T peek();

    /**
     * Checks whether the stack is empty.
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Clears the stack.
     */
    public void clear();
    
}