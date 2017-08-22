package LinkedLists;

import java.util.*;

/**
 * Created by kalsi on 22/08/17.
 * . Design queue for getMiddle() in O(1) time complexity.
 */
public class GetMiddle {
    Node mid = null;
    Node start = null;
    Node end = null;
    int count = 0;

    public static void main(String[] args) {
        new GetMiddle().demo();
    }

    private void demo() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1: insert");
            System.out.println("2: get mid");
            System.out.println("3: remove");
            System.out.println("4: display");
            System.out.println("Your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element to be insert");
                    add(scanner.nextInt());
                    break;
                case 2:
                    getMid();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    displayQueue();
                    break;
                default:
                    System.out.println("exiting");
                    System.exit(0);
            }
        }
    }

    private void add(int item) {
        if (start == null) {
            start = new Node(item);
            mid = start;
            end = start;
        } else {
            end.right = new Node(item);
            end = end.right;
            setMid();
        }
        count++;
    }

    private void getMid() {
        if (mid == null) {
            System.out.println("MID is null");
        } else {
            System.out.println("mid element is " + mid.data);
        }
    }

    private void setMid() {
        if (start == null) {
            mid = null;
        } else if (count % 2 == 0) {
            mid = mid.right;
        }
    }

    private void remove() {
        if (start == null) {
            System.out.println("Nothing to remove");
        } else {
            System.out.println("Removed: " + start.data);
            start = start.right;
            setMid();
            count--;
        }
    }

    private void displayQueue() {
        if (start == null) {
            System.out.println("Queue is empty!!");
            return;
        }
        Node i = start;
        while (i != null) {
            System.out.print(i.data + "\t");
            i = i.right;
        }
        System.out.println();
    }
}
