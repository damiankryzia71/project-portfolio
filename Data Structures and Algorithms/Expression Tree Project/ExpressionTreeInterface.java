// 
//  Name:     Kryzia, Damian 
//  Project:  4 
//  Due:      12/02/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            This ExpressionTreeInterface interface is used to implement the expression tree
//            data structure. It inherits the methods of BinaryTreeInterface<String>.
// 

/**
 * Interface that represents the expression tree data type.
 */
public interface ExpressionTreeInterface extends BinaryTreeInterface<String>
{
    /**
     * Evaluates the expression tree.
     * @return The value of the expression represented by the tree as a double.
     */
    public double evaluate();
}