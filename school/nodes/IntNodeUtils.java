package school.nodes;

public class IntNodeUtils {
    public static boolean isSorted(IntNode node) {
        if (node.getNext() == null)
            return true;
        return node.getValue() <= node.getNext().getValue() && isSorted(node.getNext());
    }

    public static IntNode getEvenNumbersNode(IntNode head) {
        IntNode head2 = null;
        IntNode current = head;
        IntNode prev = null;
        while (current != null) {
            if (current.getValue() % 2 == 0) {
                if (prev == null) {
                    head2 = new IntNode(current.getValue());
                    prev = head2;
                } else {
                    prev.setNext(new IntNode(current.getValue()));
                    prev = prev.getNext();
                }
            }
            current = current.getNext();
        }
        return head2;
    }

    public static IntNode sort(IntNode input) {
        if (input == null || input.getNext() == null)
            return input;
        while (!isSorted(input)) {
            IntNode current = input;
            while (current.getNext() != null) {
                if (current.getValue() > current.getNext().getValue()) {
                    int temp = current.getValue();
                    current.setValue(current.getNext().getValue());
                    current.getNext().setValue(temp);
                }
                current = current.getNext();
            }
        }
        return input;
    }

    public static IntNode removeEvenNumbers(IntNode input) {
        if (input == null)
            return null;
        IntNode current = input;
        IntNode prev = null;
        while (current != null) {
            if (current.getValue() % 2 == 0) {
                if (current.getNext() != null) {
                    current.setValue(current.getNext().getValue());
                    current.setNext(current.getNext().getNext());
                } else if (prev != null)
                    prev.setNext(null);
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        return input;
    }

    public static IntNode mergeSortedNodes(IntNode list1, IntNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        IntNode mergedHead = new IntNode(Math.min(list1.getValue(), list2.getValue()));
        IntNode currentMerged = mergedHead;
        while (list2 != null || list1 != null) {
            if ((list2 == null) || (list1 != null && list1.getValue() <= list2.getValue())) {
                currentMerged.setNext(new IntNode(list1.getValue()));
                list1 = list1.getNext();
            } else {
                currentMerged.setNext(new IntNode(list2.getValue()));
                list2 = list2.getNext();
            }
            currentMerged = currentMerged.getNext();
        }

        return mergedHead;
    }

    public static IntNode swapFirstTwoNodes(IntNode index) {
        if (index == null || index.getNext() == null)
            return index;
        IntNode temp = index.getNext();
        index.setNext(temp.getNext());
        temp.setNext(index);
        return temp;
    }
}