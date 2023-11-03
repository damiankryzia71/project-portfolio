// 
//  Name:     Kryzia, Damian 
//  Project:  4 
//  Due:      12/02/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            This generic Tree interface is used to implement the tree
//            data structure by tree classes.
// 

/*
 * Generic interface that represents a general tree data type.
 */
public interface TreeInterface<T>
{
    /**
     * Returns the data portion of the tree's root node.
     * @return The data portion of the tree's root node.
     */
    public T getRootData();

    /**
     * Returns the height of the tree.
     * @return The height of the tree as an integer.
     */
    public int getHeight();

    /**
     * Returns the number of nodes in the tree.
     * @return The total number of nodes as an integer.
     */
    public int getNumberOfNodes();

    /**
     * Checks whether the tree is empty.
     * @return True if the tree is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Clears the tree.
     */
    public void clear();
}