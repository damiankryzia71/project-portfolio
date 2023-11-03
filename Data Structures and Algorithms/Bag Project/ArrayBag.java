//
// Name:        Kryzia, Damian
// Homework:    #1
// Due:         9/26/2022
// Course:      cs-2400-02-f22
//
// Description:
//              A class that implements BagInterface in order to create a bag object that operates
//              on its contents using an array.
//              Interface method descriptions are provided in BagInterface.java
//
public class ArrayBag<T> implements BagInterface<T> {
    
    private T[] bag; // Array used to store the bag's content
    private int numberOfEntries; // The number of entries inside the bag
    private boolean integrityOK = false; // Integrity check
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    // Default constructor, uses the second constructor with DEFAULT_CAPACITY as the argument
    public ArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    // The class's constructor, check's whether the provided capacity doesn't exceed the allowed maximum,
    // initializes the array and number of entries, verifies the integrity of the created object.
    public ArrayBag(int capacity)
    {
        if (capacity <= MAX_CAPACITY)
        {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[capacity];
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        }

        else
        {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }
    }

    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    public boolean isEmpty()
    {
        return (numberOfEntries == 0);
    }

    public boolean add(T newEntry)
    {
        checkIntegrity();
        if (isArrayFull())
            return false;
        else
            bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    public T remove()
    {
        if(!isEmpty())
        {
            T temp = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return temp;
        }
        return null;
    }

    public boolean remove(T anEntry)
    {
        boolean found = false;
        int i = 0;

        
        while ((!found) && (i < numberOfEntries))
        {
            if (bag[i].equals(anEntry))
            {
                found = true;
                bag[i] = bag[numberOfEntries - 1];
                bag[numberOfEntries - 1] = null;
                numberOfEntries--;
            }
            i++;
        }
 
        return found;
    } 

    public void clear()
    {
        for (int i = 0; i < numberOfEntries; i++)
            bag[i] = null;
        numberOfEntries = 0;
    }

    public int getFrequencyOf(T anEntry)
    {
        int counter = 0;

        for (int i = 0; i < numberOfEntries; i++)
        {
            if (bag[i].equals(anEntry))
                counter++;
        }

        return counter;
    }

    public boolean contains(T anEntry)
    {
        boolean found = false;
        int i = 0;

        while((!found) && (i < numberOfEntries))
        {
            if (bag[i].equals(anEntry))
                found = true;
            i++;
        }

        return found;
    }

    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[])new Object[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++)
        {
            newArray[i] = bag[i];
        }

        return newArray;
    }

    // Private method, used to check the integrity of an ArrayBag object
    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
    }

    // Private method, used to check if the bag array used by an ArrayBag object is full.
    // Returns true if full, false otherwise.
    private boolean isArrayFull()
    {
        return (numberOfEntries == bag.length);
    }
}
