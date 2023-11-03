//
// Name:       Kryzia, Damian
// Homework:   #1
// Due:        9/26/2022
// Course:     cs-2400-02-ff22
//
// Description:
//             An interface serving as an implementation of the bag data structure,
//             to be implemented by bag classes.
//
public interface BagInterface<T> {
    
    public int getCurrentSize(); // Return the current size of the bag
    public boolean isEmpty(); // Return true if the bag is empty, return false otherwise
    public boolean add(T newEntry); // Add a new entry to the bag, return true if addition was sucessful, return false otherwise
    public T remove(); // Remove an entry from the bag, return the removed entry
    public boolean remove(T anEntry); // Remove a specific entry from the bag, return true if removal was successful, return false otherwise
    public void clear(); // Clear the bag
    public int getFrequencyOf(T anEntry); // Return the number of occurences of a specific entry in the bag
    public boolean contains(T anEntry); // Return true if the bag contains a specific entry, return false otherwise
    public T[] toArray(); // Return the contents of the bag in the form of an array
    
}
