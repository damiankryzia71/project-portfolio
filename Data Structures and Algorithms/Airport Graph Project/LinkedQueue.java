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

public class LinkedQueue<T> implements QueueInterface<T> {

    private Node<T> front;
    private Node<T> back;
    private int numberOfEntries;

    public LinkedQueue()
    {
        front = null;
        back = null;
        numberOfEntries = 0;
    }

    public void enqueue(T newEntry)
    {
        Node<T> newNode = new Node<>(newEntry);

        if (numberOfEntries == 0)
        {
            front = newNode;
            back = newNode;
        }
        else if (numberOfEntries == 1)
        {
            back = newNode;
            front.setNext(back);
        }
        else
        {
            back.setNext(newNode);
            back = newNode;
        }

        numberOfEntries++;
    }

    public T dequeue()
    {
        if (!isEmpty())
        {
            T dequeued = front.getData();
            front = front.getNext();
            numberOfEntries--;
            return dequeued;
        }
        else
        {
            throw new RuntimeException("Queue: dequeue(): Queue is empty.");
        }
    }

    public T getFront()
    {
        if (!isEmpty())
        {
            return front.getData();
        }
        else
        {
            throw new RuntimeException("Queue: getFront(): Queue is empty.");
        }
    }

    public boolean isEmpty()
    {
        return (numberOfEntries == 0);
    }

    public void clear()
    {
        while (!isEmpty())
        {
            dequeue();
        }
    }

}