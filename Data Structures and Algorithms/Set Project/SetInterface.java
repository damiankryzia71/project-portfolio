//
//    Name:        Kryzia, Damian
//    Project:     2
//    Due:         10/07/2022
//    Course:      cs-2400-02-f22
//
//    Description: 
//                 This file is part of the Set ADT project and contains the generic
//                 SetInterface interface that is to be implemented by set objects.
//

/**
 *  A generic interface that represents the set ADT and is to be implemented by set classes.
 */
public interface SetInterface<T> {

    /**
     * Returns the current size of the set.
     * @return Current size of the set.
     */
    public int getCurrentSize();

    /**
     * Checks whether the set is empty.
     * @return True if the set is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to the set.
     * @param newEntry A new entry to be added.
     * @return True if addition was successful, false if the entry already exists in the set.
     */
    public boolean add(T newEntry);

    /**
     * Removes the most recently added entry from the set.
     * @return The entry that was removed.
     */
    public T remove();

    /**
     * Removes a specific entry from the set.
     * @param anEntry The entry to be removed.
     * @return True if removal was successful, false otherwise.
     */
    public boolean remove(T anEntry);

    /**
     * Clears the set.
     */
    public void clear();

    /**
     * Checks whether the set contains a specific entry.
     * @param anEntry The entry to be checked.
     * @return True if the set contains the entry, false otherwise.
     */
    public boolean contains(T anEntry);

    /**
     * Converts the contents of the set into an array.
     * @return An array containing the contents of the set.
     */
    public T[] toArray();

    /**
     * Checks whether a set is a subset of this set.
     * @param rhs Right hand set.
     * @return True if right hand set is a subset of this set, false otherwise.
     */
    public boolean subset(SetInterface<T> rhs);

    /**
     * Check whether a set is equal to this set.
     * @param rhs Right hand set.
     * @return True if right hand set is equal to this set, false otherwise.
     */
    public boolean equals(SetInterface<T> rhs);

    /**
     * Creates a union of two sets.
     * @param rhs Right hand set.
     * @return A union set of the right hand set and this set.
     */
    public SetInterface<T> union(SetInterface<T> rhs);

    /**
     * Converts the set into a displayable string.
     * @return A string that represents the set.
     */
    public String toString();
    
}