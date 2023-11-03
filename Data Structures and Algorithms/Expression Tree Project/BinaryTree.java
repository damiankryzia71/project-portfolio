// 
//  Name:     Kryzia, Damian 
//  Project:  4 
//  Due:      12/02/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            This generic BinaryTree class is used to implement the
//            binary tree data structure. 
// 

/**
 * Generic class that represents the binary tree data type.
 */
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
    private BinaryNode<T> root;

    /**
     * Default constructor, creates an empty tree.
     */
    public BinaryTree()
    {
        root = null;
    }

    /**
     * Creates a tree with a specified data portion in the root node.
     * @param rootData The data portion for the root node.
     */
    public BinaryTree(T rootData)
    {
        root = new BinaryNode<T>(rootData);
    }

    /**
     * Creates a tree with a specified data portion in the root node, as well as specified left and right children.
     * @param rootData The data portion for the root node.
     * @param leftTree The left child.
     * @param rightTree The right child.
     */
    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        initializeTree(rootData, leftTree, rightTree);
    }

    /**
     * Sets the tree's root node and its left and right children to specified values.
     * @param rootData The data portion for the root node.
     * @param leftTree The left child.
     * @param rightTree The right child.
     */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
        initializeTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
    }

    private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        root = new BinaryNode<>(rootData);

        if ((leftTree != null) && !leftTree.isEmpty())
            root.setLeftChild(leftTree.root.copy());

        if ((rightTree != null) && !rightTree.isEmpty())
        {
            if (rightTree != leftTree)
                root.setRightChild(rightTree.root);
            else
                root.setRightChild(rightTree.root.copy());

            if ((leftTree != null) && (leftTree != this))
                leftTree.clear();

            if ((rightTree != null) && (rightTree != this))
                rightTree.clear();
        }
    }

    /**
     * Sets the data held by the root node to a specified value.
     * @param rootData The data portion for the root node.
     */
    public void setRootData(T rootData)
    {
        root.setData(rootData);
    }

    /**
     * Gets the data held by this tree's root node.
     * @return The data held by this tree's root node.
     */
    public T getRootData()
    {
        if (isEmpty())
            throw new RuntimeException("Tree: getRootData(): Tree is empty.");
        else
            return root.getData();
    }

    /**
     * Sets this tree's root node to a specified node.
     * @param rootNode The new root node.
     */
    protected void setRootNode(BinaryNode<T> rootNode)
    {
        root = rootNode;
    }

    /**
     * Gets this tree's root node.
     * @return This tree's root node.
     */
    protected BinaryNode<T> getRootNode()
    {
        return root;
    }

    /**
     * Gets the height of this tree.
     * @return The height of this tree as an integer.
     */
    public int getHeight()
    {
        int height = 0;
        if (root != null)
            height = root.getHeight();
        return height;
    }

    /**
     * Gets the total number of nodes in this tree.
     * @return The total number of nodes in this tree as an integer.
     */
    public int getNumberOfNodes()
    {
        int numberOfNodes = 0;
        if (root != null)
            numberOfNodes = root.getNumberOfNodes();
        return numberOfNodes;
    }

    /**
     * Checks whether this tree is empty.
     * @return True if this tree is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Clears this tree.
     */
    public void clear()
    {
        root = null;
    }
}
