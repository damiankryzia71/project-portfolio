// 
//  Name:     Kryzia, Damian 
//  Project:  4 
//  Due:      12/02/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            This generic class implements a binary node that is used when
//            implementing binary trees.
// 

/**
 * Generic class that represents a binary node used for building binary tree data types.
 */
public class BinaryNode<T>
{
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    /**
     * Default constructor, creates an empty node.
     */
    public BinaryNode()
    {
        this(null);
    }

    /**
     * Creates a node with a specified data portion.
     * @param dataPortion The data to be held by the node.
     */
    public BinaryNode(T dataPortion)
    {
        this(dataPortion, null, null);
    }

    /**
     * Creates a node with a specified data portion, as well as specified children.
     * @param dataPortion The data to be held by the node.
     * @param newLeftChild The left child node.
     * @param newRightChild The right child node.
     */
    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild)
    {
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    }

    /**
     * Gets the data held by this node.
     * @return The data portion of this node.
     */
    public T getData()
    {
        return data;
    }

    /**
     * Sets the data held by this node to the specified value.
     * @param newData The new data portion to be held by this node.
     */
    public void setData(T newData)
    {
        data = newData;
    }

    /**
     * Gets the left child node of this node.
     * @return The left child node.
     */
    public BinaryNode<T> getLeftChild()
    {
        return leftChild;
    }

    /**
     * Sets the left child node of this node to the specified value.
     * @param newLeftChild The new left child node.
     */
    public void setLeftChild(BinaryNode<T> newLeftChild)
    {
        leftChild = newLeftChild;
    }

    /**
     * Checks whether this node has a left child node.
     * @return True if a left child node is present, false otherwise.
     */
    public boolean hasLeftChild()
    {
        return leftChild != null;
    }

    /**
     * Gets the right child node of this node.
     * @return The right child node.
     */
    public BinaryNode<T> getRightChild()
    {
        return rightChild;
    }

    /**
     * Sets the right child node of this node to the specified value.
     * @param newRightChild The new right child node.
     */
    public void setRightChild(BinaryNode<T> newRightChild)
    {
        rightChild = newRightChild;
    }

    /**
     * Checks whether this node has a right child node.
     * @return True if a right child node is present, false otherwise.
     */
    public boolean hasRightChild()
    {
        return rightChild != null;
    }

    /**
     * Checks whether this node is a leaf node.
     * @return True if this node is a leaf node, false otherwise.
     */
    public boolean isLeaf()
    {
        return (leftChild == null) && (rightChild == null);
    }

    /**
     * Gets the total number of nodes including this node and all of its descendants.
     * @return The total number of nodes as an integer.
     */
    public int getNumberOfNodes()
    {
        int leftNumber = 0;
        int rightNumber = 0;

        if (leftChild != null)
            leftNumber = leftChild.getNumberOfNodes();

        if (rightChild != null)
            rightNumber = rightChild.getNumberOfNodes();

        return 1 + leftNumber + rightNumber;
    }

    /**
     * Returns the height of the tree created by this node and all of its descendants.
     * @return The height of the tree as an integer.
     */
    public int getHeight()
    {
        return getHeight(this);
    }

    private int getHeight(BinaryNode<T> node)
    {
        int height = 0;

        if (node != null)
            height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));

        return height;
    }

    /**
     * Creates a copy of this node.
     * @return A copy of this node.
     */
    public BinaryNode<T> copy()
    {
        BinaryNode<T> newRoot = new BinaryNode<>(data);

        if (leftChild != null)
            newRoot.setLeftChild(leftChild.copy());
        
        if (rightChild != null)
            newRoot.setRightChild(rightChild.copy());

        return newRoot;
    }
}
