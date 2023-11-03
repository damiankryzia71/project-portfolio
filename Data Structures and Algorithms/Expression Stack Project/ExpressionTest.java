// 
//  Name:     Kryzia, Damian 
//  Project:  3 
//  Due:      10/21/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            The class ExpressionTest contains the main method and tests
//            the methods of the Expression class. First, the main method tests
//            the methods with the command line argument. Then, tests are performed
//            for different cases, some containing valid expressions, some invalid ones.
//            This class contains helper methods test() and testEvaluation() that are
//            used by the main method.
//

public class ExpressionTest {
    
    public static void main(String[] args)
    {
        String[] infix = args[0].split(" ");
        String[] postfix = Expression.convertToPostfix(infix);
        double result = Expression.evaluatePostfix(postfix);
        System.out.println(result);
        System.out.println();

        System.out.println("Test 1: Valid infix expression.");
        System.out.println("Infix expression: 2 + 4");
        infix = "2 + 4".split(" ");
        test(infix);

        System.out.println("Test 2: Valid infix expression with multiple operators.");
        System.out.println("Infix expression: 2 + 3 * 2 / 12 ^ 8 - 14");
        infix = "2 + 3 * 2 / 12 ^ 8 - 14".split(" ");
        test(infix);

        System.out.println("Test 3: Valid infix expression with multiple operators and parentheses.");
        System.out.println("Infix expression: ( 2 + 3 ) * ( 2 / 12 ) ^ ( 8 - 14 )");
        infix = "( 2 + 3 ) * ( 2 / 12 ) ^ ( 8 - 14 )".split(" ");
        test(infix);

        System.out.println("Test 4: Invalid infix expression with incorrect operands or operators.");
        System.out.println("Infix expression: a + 10");
        infix = "a + 10".split(" ");
        test(infix);

        System.out.println("Test 5: Invalid infix expression with unbalanced parentheses.");
        System.out.println("Infix expression: ( 2 + 2 ) - 3 )");
        infix = "( 2 + 2 ) - 3 )".split(" ");
        test(infix);

        System.out.println("Test 6: Invalid infix expression with missing operands.");
        System.out.println("Infix expression: 2 * 3 / ( 7 - )");
        infix = "2 * 3 / ( 7 - )".split(" ");
        test(infix);

        System.out.println("Test 7: Invalid postfix expression with incorrect operands/operators.");
        System.out.println("Postfix expression: 2 a +");
        postfix = "2 a +".split(" ");
        testEvaluation(postfix);
        System.out.println();

        System.out.println("Test 8: Invalid postfix expression with missing operands/operators.");
        System.out.println("Postfix expression: 4 5 + -");
        postfix = "4 5 + -".split(" ");
        testEvaluation(postfix);
        System.out.println();

        System.out.println("Test 9: Invalid postfix expression with incorrect order.");
        System.out.println("For this purpose, a prefix expression is tested.");
        System.out.println("Postfix expression: + 2 3");
        postfix = "+ 2 3".split(" ");
        testEvaluation(postfix);
        System.out.println();

        System.out.println("Test 10: Postfix expression with zero division.");
        System.out.println("Postfix expression: 10 0 /");
        postfix = "10 0 /".split(" ");
        testEvaluation(postfix);
        System.out.println();

        System.out.print("Testing is concluded.");
    }

    public static void test(String[] infix)
    {
        try
        {
            String[] postfix = Expression.convertToPostfix(infix);
            System.out.print("Conversion successful: ");
            for (String e : postfix)
            {
                System.out.print(e + " ");
            }
            System.out.println();
            testEvaluation(postfix);
        }
        catch (RuntimeException e)
        {
            System.out.println("Error caught during conversion.");
        }
        System.out.println();
    }

    public static void testEvaluation(String[] postfix)
    {
        try
        {
            double result = Expression.evaluatePostfix(postfix);
            System.out.println("Evaluation successful: " + result);
        }
        catch (RuntimeException e)
        {
            System.out.println("Error caught during evaluation.");
        }
    }
    
}
