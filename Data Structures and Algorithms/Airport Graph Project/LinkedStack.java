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
 * Class representing the linked list implementation of a stack.
 */
public class LinkedStack<T> implements Stack<T> {

    private Node firstNode;
    
    /**
     * Default construcor, creates an empty stack.
     */
    public LinkedStack()
    {
        firstNode = null;
    }

    
    /**
     * Pushes a new entry onto the stack.
     * @param newEntry The new entry.
     */
    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, firstNode);
        firstNode = newNode;
    }

    /**
    * Removes the topmost entry from the stack.
    * @return The removed entry.
    */
    public T pop()
    {
        if (firstNode == null)
        {
            throw new RuntimeException("Stack: pop(): Stack is empty.");
        }
        else
        {
            T toRemove = firstNode.data;
            firstNode = firstNode.next;
            return toRemove;
        }
    }

    /**
    * Returns the topmost entry from the stack without removing it.
    * @return The topmost entry.
    */
    public T peek()
    {
        if (firstNode == null)
        {
            throw new RuntimeException("Stack: peek(): Stack if empty.");
        }
        else
        {
            return firstNode.data;
        }
    }

    /**
    * Checks whether the stack is empty.
    * @return True if stack is empty, false otherwise.
    */
    public boolean isEmpty()
    {
        return (firstNode == null);
    }

    
    /**
     * Clears the stack.
     */
    public void clear()
    {
        while (!isEmpty())
        {
            pop();
        }
    }

    private class Node
    {
        private T data;
        private Node next;

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
    }

}