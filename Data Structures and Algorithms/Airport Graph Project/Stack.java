//
//      Name:       D.Kryzia
//      Project:    5
//      Due:        12/9/2022
//      Course:     cs-2400-02-f22
//  
//      Description:
//                  This project is the AirportApp that uses the Graph adt. Using a directed, weighted graph
//                  the user can operate on a graph where airports are vertices and routes between them are edges.
//                  The implementation uses other ADTs: Queue, PriorityQueue, Stack, List, and HashMap.
//

/**
 * Interface representing a stack.
 */
public interface Stack<T> {

    /**
     * Pushes a new entry onto the stack.
     * @param newEntry The new entry.
     */
    public void push(T newEntry);

    /**
     * Removes the topmost entry from the stack.
     * @return The removed entry.
     */
    public T pop();

    /**
     * Returns the topmost entry from the stack without removing it.
     * @return The topmost entry.
     */
    public T peek();

    /**
     * Checks whether the stack is empty.
     * @return True if stack is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Clears the stack.
     */
    public void clear();
    
}