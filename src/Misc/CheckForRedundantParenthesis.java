package Misc;

/**
 * Created by kalsi on 24/07/17.
 */
public class CheckForRedundantParenthesis {
    public static void main(String[] args) {
        String exp = "((a+(b))+((c+d)))";
        // I assume the given expression is a valid expression
//         String exp = "((a+b)+((c+d)*e))";
//         String exp = "((a+b)+(c+d))";
        if (new CheckForRedundantParenthesis().isRedundant(exp)) {
            System.out.println("The given expression contains duplicate parenthesis");
        } else {
            System.out.println("No duplicate parenthesis found");
        }
    }

    private boolean isRedundant(String expression) {
        char[] stack = new char[expression.length()];
        int top = -1;
        char currentChar;
        for (int i = 0; i < expression.length(); i++) {
            if ((currentChar = expression.charAt(i)) != ')') {
                stack[++top] = currentChar;
            } else {
                if (stack[top] == '(') {
                    return true;
                }
                while (stack[top--] != '(') ;
            }
        }
        return false;
    }
}
