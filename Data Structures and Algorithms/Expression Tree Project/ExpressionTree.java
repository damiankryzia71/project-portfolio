// 
//  Name:     Kryzia, Damian 
//  Project:  4 
//  Due:      12/02/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            The class ExpressionTree implements the expression tree data structure
//            by converting a postfix expression into an expression tree. It inherits the
//            methods of the BinaryTree<String> class.
// 

/**
 * Class that implements the expression tree data type.
 */
public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface
{
    /**
     * Creates an expression tree using a specified postfix expression.
     * @param postfix The postfix expression to be converted into an expression tree.
     */
    public ExpressionTree(String[] postfix)
    {
        Stack<BinaryTree<String>> stack = new LinkedStack<>();

        for (String element : postfix)
        {
            try
            {
                switch (element)
                {
                    case "+": case "-": case "*": case "/":
                        BinaryTree<String> rhs = stack.pop();
                        BinaryTree<String> lhs = stack.pop(); 
                        stack.push(new BinaryTree<>(element, lhs, rhs));
                        break;
                    default:
                        stack.push(new BinaryTree<>(element));
                        break;
                }
            }
            catch (RuntimeException emptyStackException)
            {
                throw new RuntimeException("ExpressionTree: Expression is not well-formulated or not a number.");
            }
        }

        setRootNode(stack.pop().getRootNode());
    }

    /**
     * Evaluates this expression tree.
     * @return The value of this tree as a double.
     */
    public double evaluate()
    {
        return evaluate(getRootNode());
    }

    private double evaluate(BinaryNode<String> rootNode)
    {
        double result;

        if (isEmpty())
            result = 0;
        else if (rootNode.isLeaf())
        {
            result = getValueOf(rootNode.getData());
        }
        else
        {
            double firstOperand = evaluate(rootNode.getLeftChild());
            double secondOperand = evaluate(rootNode.getRightChild());
            String operator = rootNode.getData();

            result = compute(operator, firstOperand, secondOperand);
        }

        return result;
    }

    private double compute(String operator, double firstOperand, double secondOperand)
    {
        switch (operator)
        {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return firstOperand / secondOperand;
            default:
                return 0;
        }
    }

    private double getValueOf(String variable)
    {
        return Double.valueOf(variable);
    }

    /**
     * Outputs the postorder traversal of this tree's contents.
     */
    public void postorder()
    {
        postorder(getRootNode());
    }

    private void postorder(BinaryNode<String> rootNode)
    {
        if (rootNode == null)
            return;

        postorder(rootNode.getLeftChild());
        postorder(rootNode.getRightChild());
        
        switch (rootNode.getData())
        {
            case "+": case "-": case "*": case "/":
                System.out.println(rootNode.getLeftChild().getData() + " : " + rootNode.getData() + " : " + rootNode.getRightChild().getData());
                break;
            default:
                System.out.println(rootNode.getData());
        }
    }
}
