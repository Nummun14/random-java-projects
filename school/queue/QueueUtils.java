package school.queue;

import school.Table;

public class QueueUtils {
    public static boolean isInQueue(Queue<Integer> queue, Integer value) {
        while (!queue.isEmpty()) {
            if (queue.remove().equals(value))
                return true;
        }
        return false;
    }

    public static boolean isInQueueWithoutModifying(Queue<Integer> queue, Integer value) {
        Queue<Integer> tempQueue = new Queue<>();
        boolean found = false;

        while (!queue.isEmpty()) {
            Integer currentValue = queue.remove();
            if (currentValue.equals(value))
                found = true;
            tempQueue.insert(currentValue);
        }

        while (!tempQueue.isEmpty())
            queue.insert(tempQueue.remove());

        return found;
    }

    public static int getBiggest(Queue<Integer> queue) {
        Queue<Integer> tempQueue = new Queue<>();
        int biggest = queue.head();

        while (!queue.isEmpty()) {
            Integer currentValue = queue.remove();
            if (currentValue > biggest)
                biggest = currentValue;
            tempQueue.insert(currentValue);
        }

        while (!tempQueue.isEmpty())
            queue.insert(tempQueue.remove());

        return biggest;
    }
//
//    public static Queue<Integer> getNumbersThatAppearTwice(Queue<Integer> queue) {
//        Queue<Integer> reversedQueue = new Queue<Integer>();
//        Queue<Integer> returningQueue = new Queue<Integer>();
//
//
//
//        while (!reversedQueue.isEmpty())
//            queue.insert(reversedQueue.remove());
//    }

    public static boolean areEqual(Queue<Integer> q1, Queue<Integer> q2) {
        if (q1.isEmpty() && q2.isEmpty())
            return true;
        if (q1.isEmpty() || q2.isEmpty())
            return false;

        Queue<Integer> tempQ1 = new Queue<>();
        Queue<Integer> tempQ2 = new Queue<>();
        boolean equal = true;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Integer val1 = q1.remove();
            Integer val2 = q2.remove();
            if (!val1.equals(val2))
                equal = false;
            tempQ1.insert(val1);
            tempQ2.insert(val2);
        }

        if (!q1.isEmpty() || !q2.isEmpty())
            equal = false;

        while (!tempQ1.isEmpty())
            q1.insert(tempQ1.remove());
        while (!tempQ2.isEmpty())
            q2.insert(tempQ2.remove());

        return equal;
    }

    public static void removeSmallest(Queue<Integer> queue) {
        Queue<Integer> tempQueue = new Queue<Integer>();
        int smallest = queue.head();

        while (!queue.isEmpty()) {
            int num = queue.remove();
            if (num < smallest)
                smallest = num;
            tempQueue.insert(num);
        }

        boolean hasRemoved = false;
        while (!tempQueue.isEmpty()) {
            int temp = tempQueue.remove();
            if (temp != smallest || hasRemoved)
                queue.insert(temp);
            else
                hasRemoved = true;
        }
    }

    public static void colorYellow(Queue<Table> tables) {
        Queue<Table> tempQueue = new Queue<Table>();

        while (!tempQueue.isEmpty()) {
            Table table = tempQueue.remove();
            table.setColor("Yellow");
            tempQueue.insert(table);
        }

        while (!tempQueue.isEmpty())
            tables.insert(tempQueue.remove());
    }
}