// 
//  Name:     Kryzia, Damian 
//  Project:  4 
//  Due:      12/02/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            The ExpressionTest class contains the main() method and is
//            used to test the functionality of the ExpressionTree class.
// 

public class ExpressionTest
{
    public static void main(String[] args)
    {
        String[] expression = args[0].split(" ");
        ExpressionTree tree = new ExpressionTree(expression);

        System.out.println("Expression Tree by D. Kryzia\n");
        System.out.println("Input: " + args[0]);
        System.out.println("Value: " + tree.evaluate() + "\n");
        System.out.println("Postorder Traversal:");
        tree.postorder();
    }
}
