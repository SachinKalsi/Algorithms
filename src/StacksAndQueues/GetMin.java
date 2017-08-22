package StacksAndQueues;

import java.util.Scanner;

/**
 * Created by kalsi on 21/08/17.
 * Simplest and famous one: Design stack for top(),push(),pop() and getMin() operations in
 * O(1) time complexity.
 */
public class GetMin {
    class MinMax {
        int min;
        int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private int top = -1, minStackTop = -1;
    private int[] stack = new int[100];
    private int[] minItemStack = new int[100];

    public static void main(String[] args) {
        new GetMin().demo();

    }

    private void demo() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1: push");
            System.out.println("2: pop");
            System.out.println("3: get min");
            System.out.println("4: get top");
            System.out.println("5: display stack");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element to be pushed");
                    push(scanner.nextInt());
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    getMin();
                    break;
                case 4:
                    getTop();
                    break;
                case 5:
                    displayStack();
                    break;
                default:
                    System.out.println("exiting");
                    System.exit(0);
            }
        }
    }

    private boolean isEmptyStack() {
        return top == -1;
    }

    private void displayStack() {
        if (isEmptyStack()) {
            System.out.println("Nothing to display");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);

        }

    }

    private void push(int item) {
        if (top == 99) {
            System.out.println("Stack Overflow!!");
            return;
        }
        stack[++top] = item;
        pushMin(item);
    }

    private void pushMin(int item) {
        if (minStackTop == -1 || item < minItemStack[minStackTop]) {
            minStackTop++;
            minItemStack[minStackTop] = item;
        }
    }


    private void pop() {
        if (isEmptyStack()) {
            System.out.println("Under Flow");
            return;
        }
        int itemPopped = stack[top--];
        System.out.println("Popped Element: " + itemPopped);
        popMin(itemPopped);

    }

    private void popMin(int item) {
        if (item == minItemStack[minStackTop]) {
            minStackTop--;
        }
    }

    private void getMin() {
        if (isEmptyStack()) {
            System.out.println("Empty stack");
            return;
        }
        System.out.println(minItemStack[minStackTop]);
    }

    private void getTop() {
        if (isEmptyStack()) {
            System.out.println("Under Flow");
            return;
        }
        System.out.println(stack[top]);
    }
}
