//
//    Name:        Kryzia, Damian
//    Project:     2
//    Due:         10/07/2022
//    Course:      cs-2400-02-f22
//
//    Description: 
//                 This file is part of the Set ADT project and contains the generic
//                 LinkedSet class that implements the generic SetInterface interface.
//

public class LinkedSet<T> implements SetInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedSet()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    public boolean isEmpty()
    {
        return (numberOfEntries == 0);
    }

    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    public boolean add(T newEntry)
    {
        if (contains(newEntry))
            return false;
        else
        {
            Node newNode = new Node(newEntry, firstNode);
            firstNode = newNode;
            numberOfEntries++;
            return true;
        }
    }

    public T remove()
    {
        T result = null;

        if (firstNode != null)
        {
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }

        return result;
    }

    public boolean remove(T anEntry)
    {
        if (isEmpty() || !(contains(anEntry)))
            return false;
        
        Node toRemove = getReferenceOf(anEntry);
        toRemove.data = firstNode.data;
        remove();

        return true;
    }

    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    }

    public boolean contains(T anEntry)
    {
        return (getReferenceOf(anEntry) != null);
    }

    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] setArray = (T[])new Object[numberOfEntries];
        Node currentNode = firstNode;
        int i = 0;

        while ((currentNode != null) && (i < numberOfEntries))
        {
            setArray[i] = currentNode.data;
            currentNode = currentNode.next;
            i++;
        }

        return setArray;
    }

    public boolean subset(SetInterface<T> rhs)
    {

        if (rhs.getCurrentSize() == 0)
            return true;

        T[] rhsArray = rhs.toArray();

        for (T entry : rhsArray)
        {
            if (!contains(entry))
                return false;
        }

        return true;
    }

    public boolean equals(SetInterface<T> rhs)
    {
        Node currentNode = firstNode;

        if (numberOfEntries == rhs.getCurrentSize())
        {
            while (currentNode != null)
            {
                if (!rhs.contains(currentNode.data))
                    return false;
                currentNode = currentNode.next;
            }

            return true;
        }
        else
            return false;
    }

    public SetInterface<T> union(SetInterface<T> rhs)
    {
        SetInterface<T> unionSet = new LinkedSet<T>();
        T[] lhsArray = toArray();
        T[] rhsArray = rhs.toArray();

        for (T entry : lhsArray)
        {
            if (!unionSet.contains(entry))
                unionSet.add(entry);
        }

        for (T entry : rhsArray)
        {
            if (!unionSet.contains(entry))
                unionSet.add(entry);
        }

        return unionSet;
    }

    public String toString()
    {
        StringBuilder display = new StringBuilder();
        T[] setArray = toArray();

        display.append("{");

        if (setArray.length > 0)
        {
            display.append(" ");
            display.append(setArray[0].toString());
            if (setArray.length > 1)
            {
                for (int index = 1; index < setArray.length; index++)
                {
                    display.append("," + setArray[index].toString());
                }
            }
            display.append(" ");
        }

        display.append("}");

        return display.toString();
    }

    private Node getReferenceOf(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }

        return currentNode;
    }

    private class Node {

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