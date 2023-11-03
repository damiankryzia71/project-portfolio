// 
//  Name:     Kryzia, Damian 
//  Project:  3 
//  Due:      10/21/2022 
//  Course:   cs-2400-02-f22 
// 
//  Description: 
//            The class Expression contains methods that convert
//            infix expressions into postfix expression and evaluate
//            postfix expressions. The generic class LinkedStack is
//            also used as part of this project. This class contains
//            private helper methods that are used to check an infix 
//            expression before it is converted, as well as to check 
//            the precedence of operators during conversion.
// 

import java.util.*;

/**
 * The class Expression contains methods for converting an infix expression
 * into a postfix expression, as well as evaluating a postfix expression.
 */
public class Expression {
    
    private Expression() {}
    
    /**
     * Converts an infix expression into a postfix expression.
     * @param infixExpression An infix expression as an array of String.
     * @return A postfix expression created from the provided infix expression
     * as an array of String.
     * @throws RuntimeException If the infix exception is not well-formed or a not number literal.
     */
    public static String[] convertToPostfix(String[] infixExpression)
    {
        Stack<String> stack = new LinkedStack<>();
        ArrayList<String> postfix = new ArrayList<>();

        if (!checkInfixExpression(infixExpression))
            throw new RuntimeException("Expression: convertToPostfix(): Invalid expression.");
        
        for (String element : infixExpression)
        {
            switch (element)
            {
                case "^":
                    stack.push(element);
                    break;

                case "(":
                    stack.push(element);
                    break;

                case "+": 
                case "-":
                case "*": 
                case "/":
                    while (!stack.isEmpty() && (!(checkPrecedence(stack.peek()) < checkPrecedence(element))))
                    {
                        postfix.add(stack.pop());
                    }
                    stack.push(element);
                    break;

                case ")":
                    while (!(stack.peek().equals("(")))
                    {
                        postfix.add(stack.pop());
                    }
                    stack.pop();
                    break;

                default:
                    postfix.add(element);
            }
        }

        while (!stack.isEmpty())
        {
            postfix.add(stack.pop());
        }

        return postfix.toArray(new String[postfix.size()]);
    }


    /**
     * Evaluates a postfix expression.
     * @param postfixExpression A postfix expression as an array of String.
     * @return The value of the postfix expression as double.
     * @throws RuntimeException If the postfix expression is not well-formed, not a number literal,
     * or in the case of a zero division error.
     */
    public static double evaluatePostfix(String[] postfixExpression)
    {
        String message = "Expression: evaluatePostfix(): Invalid expression.";
        Stack<Double> stack = new LinkedStack<>();
        double temp;

        for (String element : postfixExpression)
        {
            switch (element)
            {
                case "+":
                    try
                    {
                    stack.push(stack.pop() + stack.pop());
                    }
                    catch (RuntimeException error)
                    {
                        throw new RuntimeException(message);
                    }
                    break;

                case "-":
                    try
                    {
                        temp = stack.pop();
                        stack.push(stack.pop() - temp);
                    }
                    catch (RuntimeException error)
                    {
                        throw new RuntimeException(message);
                    }
                    break;

                case "*":
                    try
                    {
                        stack.push(stack.pop() * stack.pop());
                    }
                    catch (RuntimeException error)
                    {
                        throw new RuntimeException(message);
                    }
                    break;

                case "/":
                    try
                    {
                        temp = stack.pop();
                        if (temp == 0)
                        {
                            throw new RuntimeException();
                        }
                        stack.push(stack.pop() / temp);
                    }
                    catch (RuntimeException error)
                    {
                        throw new RuntimeException(message);
                    }
                    break;

                case "^":
                    try
                    {
                        temp = stack.pop();
                        stack.push(Math.pow(stack.pop(), temp));
                    }
                    catch (RuntimeException empty)
                    {
                        throw new RuntimeException("Expression: evaluatePostfix(): Invalid expression.");
                    }
                    break;

                default:
                    try
                    {
                        stack.push(Double.valueOf(element));
                    }
                    catch (Exception e)
                    {
                        throw new RuntimeException("Expression: evaluatePostfix(): Invalid expression.");
                    }
            }
        }
        
        return stack.pop().doubleValue();
    }

    /**
     * Checks the precedence of an operator.
     * @param operator The operator to check.
     * @return 0 for parentheses, 1 for "+" or "-",
     * 2 for "*" or "/", 3 for "^", and -1 for invalid operators.
     */
    private static int checkPrecedence(String operator)
    {
        switch (operator)
        {
            case "(":
                return 0;
            case "+": case "-":
                return 1;
            case "*": case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }

    /**
     * Checks the correctness of an infix expression.
     * @param expression The infix expression to check in the form of a String array.
     * @return True if expression is valid, false otherwise.
     */
    private static boolean checkInfixExpression(String[] expression)
    {
        boolean isValid = checkInfixBalance(expression);
        Stack<String> stack = new LinkedStack<>();
        int i = 0;

        if (expression.length <= 1)
            isValid = false;

        if ((isOperator(expression[0])) || (isOperator(expression[expression.length - 1])))
            isValid = false;
        
        if ((expression[0].equals(")")) || (expression[expression.length - 1].equals("(")))
            isValid = false;

        while ((isValid) && (i < expression.length - 1))
        {
           if (isOperand(expression[i]))
           {
                if (isOperand(expression[i + 1]))
                    isValid = false;
                else if (isParenthesis(expression[i + 1]))
                {
                    if (expression[i + 1].equals("("))
                        isValid = false;
                }
           }
           else if (isOperator(expression[i]))
           {
                if (isOperator(expression[i + 1]))
                    isValid = false;
                else if (isParenthesis(expression[i + 1]))
                {
                    if (expression[i + 1].equals(")"))
                        isValid = false;
                }
           }
           else if (isParenthesis(expression[i]))
           {
                switch (expression[i])
                {
                    case "(":
                        if (isOperator(expression[i + 1]))
                            isValid = false;
                        break;
                    
                    case ")":
                        if (isOperand(expression[i + 1]))
                            isValid = false;
                }
           }
           else
           {
                isValid = false;
           }

           i++;
        }

        if (!stack.isEmpty())
            isValid = false;

        return isValid;
    }

    /**
     * Checks whether parentheses in an infix expression are balanced.
     * @param expression The infix expression to check in the form of a String array.
     * @return True if expression is valid, false otherwise.
     */
    private static boolean checkInfixBalance(String[] expression)
    {
        boolean isBalanced = true;
        int i = 0;
        Stack<String> stack = new LinkedStack<>();

        while ((isBalanced) && (i < expression.length))
        {
            switch (expression[i])
            {
                case "(":
                    stack.push(expression[i]);
                    break;
                case ")":
                    if (stack.isEmpty())
                        isBalanced = false;
                    else
                    {
                        if (stack.pop().equals("("))
                            isBalanced = true;
                        else
                            isBalanced = false;
                    }
                    break;
            }
            i++;
        }
        
        if (!stack.isEmpty())
            isBalanced = false;
        
        return isBalanced;
    }

    /**
     * Checks whether an element is an operand.
     * @param element The element to check as a String.
     * @return True if element is an operand, false otherwise.
     */
    private static boolean isOperand(String element)
    {
        try
        {
            Double.parseDouble(element);
            return true;
        }

        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Checks whether an element is an operator.
     * @param element The element to check as a String.
     * @return True if element is an operator, false otherwise.
     */
    private static boolean isOperator(String element)
    {
        switch (element)
        {
            case "+": case "-": case "*": case "/": case "^":
                return true;
            
            default:
                return false;
        }
    }

    /**
     * Checks whether an element is a parenthesis.
     * @param element The element to check as a String.
     * @return True if element is a parenthesis, false otherwise.
     */
    private static boolean isParenthesis(String element)
    {
        switch (element)
        {
            case "(": case ")":
                return true;
            
            default:
                return false;
        }
    }

}
