// 
//  Name:     Kryzia, Damian 
//  Project:  4 
//  Due:      12/02/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            This generic BinaryTree interface is used to implement the binary tree
//            data structure by binary tree classes. It inherits the methods set by TreeInterface.
// 

/**
 * Generic interface that represents a binary tree data type.
 */
public interface BinaryTreeInterface<T> extends TreeInterface<T>
{
    /**
     * Sets the data portion of the tree's root node to the specified value.
     * @param rootData The new data portion.
     */
    public void setRootData(T rootData);

    /**
     * Sets the tree's root node and its left and right children to specified values.
     * @param rootData The new data portion for the tree's root node.
     * @param leftTree The root node's left child.
     * @param rightTree The root node's right child.
     */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
