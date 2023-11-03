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

public class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T>
{
    private T[] queue;
    private int backIndex;
    private int numberOfEntries;
    private int capacity;
    private static final int MAX_CAPACITY = 10000;

    public PriorityQueue()
    {
        this(100);
    }

    public PriorityQueue(int desiredCapacity)
    {
        capacity = desiredCapacity;
        if (capacity > MAX_CAPACITY)
            throw new RuntimeException("PriorityQueue: Desired capacity exceeds maximum allowed capacity.");

        @SuppressWarnings("unchecked")
        T[] temp = (T[])new Comparable[capacity];
        queue = temp;

        numberOfEntries = 0;
        backIndex = 0;
    }

    public void add(T newEntry)
    {
        boolean found = false;
        int index = backIndex;

        if (isEmpty())
        {
            queue[index] = newEntry;
            backIndex++;
        }
        else
        {
            backIndex++;

            while (!found)
            {
                if ((index == 0) || (queue[index - 1].compareTo(newEntry) >= 0))
                {
                    found = true;

                    T temp = queue[index];
                    queue[index] = newEntry;
                    index++;

                    for (int i = index; i < backIndex + 1; i++)
                    {
                        T temp2 = queue[i];
                        queue[i] = temp;
                        temp = temp2;
                    }
                }
                index--;
            }
        }
        numberOfEntries++;
    }

    public T remove()
    {
        T target = queue[0];

        for (int i = 0; i < numberOfEntries; i++)
        {
            queue[i] = queue[i + 1];
        }

        backIndex--;
        numberOfEntries--;
        return target;
    }

    public T peek()
    {
        return queue[0];
    }

    public boolean isEmpty()
    {
        return (numberOfEntries == 0);
    }

    public int getSize()
    {
        return numberOfEntries;
    }

    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }

        numberOfEntries = 0;
        backIndex = 0;
    }
}
