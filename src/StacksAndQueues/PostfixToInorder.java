package StacksAndQueues;

/**
 * Created by kalsi on 28/08/17.
 */
public class PostfixToInorder {
    public static void main(String[] args) {
        new PostfixToInorder().demo();
    }

    private void demo() {
        String postfix = "231*+9-";
        System.out.println(printInorder(postfix));
    }

    private String printInorder(String postfix) {
        String stack[] = new String[postfix.length()];
        String first = null, second = null;
        int top = -1;
        for (int i = 0; i < postfix.length(); i++) {
            if (isChar(postfix.charAt(i))) {
                stack[++top] = String.valueOf(postfix.charAt(i));
            } else {
                second = stack[top--];
                first = stack[top--];
                stack[++top] = first + String.valueOf(postfix.charAt(i)) + second;
            }
        }
        return stack[0];
    }

    private boolean isChar(char c) {
        return ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122));
    }
}
