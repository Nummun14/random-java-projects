package school;

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
}