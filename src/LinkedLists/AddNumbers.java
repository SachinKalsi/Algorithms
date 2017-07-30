package LinkedLists;

/**
 * Created by kalsi on 30/07/17.
 */
public class AddNumbers {
    int carry = 0;

    public static void main(String[] args) {
        new AddNumbers().demo();
    }

    private void demo() {
        int[] number1 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] number2 = {9, 9, 9, 9, 6, 3, 1, 3, 5, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        Node firstNumber = LinkedList.createSLL(number1);
        Node secondNumber = LinkedList.createSLL(number2);
        Node result = prepareAndAddNumbers(firstNumber, secondNumber);
        LinkedList.displayDLL(result, false);
    }

    private Node prepareAndAddNumbers(Node firstNumber, Node secondNumber) {
        int firstNumberLength = LinkedList.getLength(firstNumber);
        int secondNumberLength = LinkedList.getLength(secondNumber);
        if (firstNumberLength != secondNumberLength) {
            Node imbalancedNode = firstNumberLength > secondNumberLength ? secondNumber : firstNumber;
            imbalancedNode = appendZeros(imbalancedNode, Math.abs(firstNumberLength - secondNumberLength));
            if (firstNumberLength > secondNumberLength) {
                secondNumber = imbalancedNode;
            } else {
                firstNumber = imbalancedNode;
            }
        }
        return addNumbers(firstNumber, secondNumber, 0);
    }

    private Node addNumbers(Node firstNumber, Node secondNumber, int level) {
        Node result = null;
        if (firstNumber.right != null) {
            result = addNumbers(firstNumber.right, secondNumber.right, ++level);
        }
        int sum = firstNumber.data + secondNumber.data + carry;
        carry = 0;
        if (sum >= 10) {
            sum = sum % 10;
            carry = 1;
        }
        Node sumNode = new Node(sum);
        sumNode.right = result;
        if (level == 1 && carry == 1) {
            Node carryNode = new Node(1);
            carryNode.right = sumNode;
            sumNode = carryNode;
        }
        return sumNode;
    }

    private Node appendZeros(Node imbalancedNode, int numberOfZeros) {
        if (numberOfZeros != 0) {
            Node zeroLastNode = null;
            while (numberOfZeros-- != 0) {
                zeroLastNode = new Node(0);
                zeroLastNode.right = imbalancedNode;
                imbalancedNode = zeroLastNode;
            }
        }
        return imbalancedNode;
    }
}
