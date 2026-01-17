package school.nodes;

import school.Range;

public class NodeUtils {
    public static boolean isThird(Node<Integer> node) {
        final int length = getLength(node);
        if (length % 3 != 0)
            return false;
        int count = 0;
        Node<Integer> current = node;
        int[] third = new int[length / 3];
        while (current != null) {
            if (count <= length / 3) {
                third[count % (length / 3)] = current.getValue();
            } else {
                if (current.getValue() != third[count % (length / 3)])
                    return false;
            }
            count++;
            current = current.getNext();
        }
        return true;
    }

    public static boolean isThirdNoArray(Node<Integer> node) {
        final int length = getLength(node);
        if (length % 3 != 0 || length == 0)
            return false;

        Node<Integer> current = node;
        for (int i = 0; i < length / 3; i++) {
            int value = current.getValue();
            Node<Integer> checker = current;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < length / 3; k++)
                    checker = checker.getNext();
                if (checker == null || checker.getValue() != value)
                    return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public static int getLength(Node<Integer> head) {
        int length = 0;
        Node<Integer> current = head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    public static Node<Range> toRange(Node<Integer> head) {
        Node<Range> rangeNode = new Node<>(null);
        Node<Range> rangeNodeCurrent = rangeNode;
        int from = head.getValue();
        Node<Integer> current = head.getNext();
        while (current.getNext() != null) {
            if (current.getNext().getValue() - current.getValue() != 1) {
                if (rangeNodeCurrent.getValue() == null)
                    rangeNodeCurrent.setValue(new Range(from, current.getValue()));
                else {
                    rangeNodeCurrent.setNext(new Node<>(new Range(from, current.getValue())));
                    rangeNodeCurrent = rangeNodeCurrent.getNext();
                }
                from = current.getNext().getValue();
            }
            current = current.getNext();
        }
        rangeNodeCurrent.setNext(new Node<>(new Range(from, current.getValue())));
        return rangeNode;
    }

    public static Node<Integer> veryAnnoyingQuestionINeverWantToTouchAgain(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> L1Current = L1;
        Node<Integer> L3 = new Node<>(null);
        Node<Integer> L3Current = L3;
        while (L1Current != null) {
            if (L1Current.getValue() % 2 == 0) {
                Node<Integer> L2Current = L2;
                int index = 1;
                while (L2Current.getNext() != null && index < L1Current.getValue() - 1) {
                    L2Current = L2Current.getNext();
                    index++;
                }
                if (L2Current.getNext() != null)
                    L2Current.setNext(L2Current.getNext().getNext());
            } else {
                Node<Integer> L2Current = L2;
                int index = 1;
                while (L2Current.getNext() != null && index < L1Current.getValue() - 1) {
                    L2Current = L2Current.getNext();
                    index++;
                }
                if (L2Current.getNext() != null) {
                    if (L3.getValue() == null) {
                        L3.setValue(L2Current.getNext().getValue());
                        L3Current = L3;
                    } else {
                        L3Current.setNext(L2Current.getNext());
                        L3Current = L3Current.getNext();
                    }
                }
            }
            L1Current = L1Current.getNext();
        }
        return L3;
    }

    public static void removeNextValue(Node<Integer> list) {
        list.setNext(list.getNext().getNext());
    }
}