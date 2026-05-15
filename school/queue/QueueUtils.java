package school.queue;

import school.Table;
import school.binnode.BinNode;
import school.binnode.BinNodeUtils;

public class QueueUtils {
    public static boolean isSimilar(Queue<Integer> q1, Queue<Integer> q2) {
        int size1 = getQueueSize(q1);
        if (size1 != getQueueSize(q2))
            return false;

        boolean isSimilar = false;

        for (int i = 0; i < size1; i++) {
            if (isIdentical(q1, q2))
                isSimilar = true;

            q1.insert(q1.remove());
        }

        return isSimilar;
    }

    public static boolean isIdentical(Queue<Integer> q1, Queue<Integer> q2) {
        if (getQueueSize(q1) != getQueueSize(q2))
            return false;

        boolean areIdentical = true;
        Queue<Integer> temp1 = new Queue<>();
        Queue<Integer> temp2 = new Queue<>();

        while (!q1.isEmpty()) {
            int num1 = q1.remove();
            int num2 = q2.remove();
            if (num1 != num2)
                areIdentical = false;
            temp1.insert(num1);
            temp2.insert(num2);
        }

        while (!temp2.isEmpty()) {
            q1.insert(temp1.remove());
            q2.insert(temp2.remove());
        }

        return areIdentical;
    }

    public static Queue<Integer> copyQueue(Queue<Integer> original) {
        if (original == null)
            return null;

        Queue<Integer> copyQueue = new Queue<Integer>();
        Queue<Integer> auxQueue = new Queue<Integer>();

        // Step 1: Empty the original queue, building both the copy and the backup
        while (!original.isEmpty()) {
            Integer current = original.remove();
            copyQueue.insert(current);
            auxQueue.insert(current);
        }
        // Step 2: Restore the original queue using the backup (auxQueue)
        while (!auxQueue.isEmpty())
            original.insert(auxQueue.remove());
        return copyQueue;
    }

    public static void sortQueue(Queue<Integer> q) {
        // If the queue is empty or has only one element, it's already sorted.
        if (q == null || q.isEmpty())
            return;

        Queue<Integer> sortedQueue = new Queue<Integer>();
        Queue<Integer> auxQueue = new Queue<Integer>();
        // Loop until all elements from the original queue are sorted
        while (!q.isEmpty()) {
            // Assume the first element is the minimum
            int min = q.remove();
            // Check the rest of the elements in the queue
            while (!q.isEmpty()) {
                int current = q.remove();
                // If we find a new minimum, send the old minimum to the auxiliary queue
                if (current < min) {
                    auxQueue.insert(min);
                    min = current;
                } else
                    // Otherwise, send the current element to the auxiliary queue
                    auxQueue.insert(current);

            }
            // Insert the absolute minimum of this pass into the sorted queue
            sortedQueue.insert(min);
            // Transfer all remaining elements back from the aux queue to the original queue for the next pass
            while (!auxQueue.isEmpty())
                q.insert(auxQueue.remove());
        }
        // Finally, transfer the fully sorted elements back into the original queue
        while (!sortedQueue.isEmpty())
            q.insert(sortedQueue.remove());
    }

    public static int maxConnect(Queue<Integer> q1, Queue<Integer> q2) {
        int size1 = getQueueSize(q1);
        int size2 = getQueueSize(q2);
        int smallest = 0;
        if (size2 >= size1)
            smallest = size1;
        else
            smallest = size2;

        for (int i = smallest; i > 0; i--) {
            if (isMConnect(q1, q2, smallest))
                return smallest;
        }
        return 0;
    }

    public static boolean isMConnect(Queue<Integer> q1, Queue<Integer> q2, int m) {
        int size1 = getQueueSize(q1);
        int size2 = getQueueSize(q2);
        boolean isConnected = true;

        for (int i = 0; i < size1 - m; i++)
            q1.insert(q1.remove());

        for (int i = 0; i < m; i++) {
            int num1 = q1.remove();
            int num2 = q2.remove();

            if (num1 != num2)
                isConnected = false;

            q1.insert(num1);
            q2.insert(num2);
        }

        for (int i = 0; i < size2 - m; i++)
            q2.insert(q2.remove());

        return isConnected;
    }

    public static int getQueueSize(Queue<Integer> q) {
        Queue<Integer> temp = new Queue<Integer>();
        int count = 0;

        while (!q.isEmpty()) {
            temp.insert(q.remove());
            count++;
        }

        while (!temp.isEmpty())
            q.insert(temp.remove());
        return count;
    }

    public static Queue<Integer> getInBoth(Queue<Integer> first, Queue<Integer> second) {
        Queue<Integer> tempQueue1 = new Queue<Integer>();
        Queue<Integer> inBothQueue = new Queue<>();

        while (!first.isEmpty()) {
            int num = first.remove();
            tempQueue1.insert(num);
            if (isInQueueWithoutModifying(second, num) && !isInQueueWithoutModifying(inBothQueue, num))
                inBothQueue.insert(num);
        }

        while (!tempQueue1.isEmpty())
            first.insert(tempQueue1.remove());

        return inBothQueue;
    }

    public static int getHowManyOnlyEven(Queue<BinNode<Integer>> queue) {
        int num = 0;
        while (!queue.isEmpty())
            if (BinNodeUtils.areAllNumbersEven(queue.remove()))
                num++;

        return num;
    }

    public static boolean isInQueue(Queue<Integer> queue, Integer value) {
        while (!queue.isEmpty()) {
            if (queue.remove().equals(value))
                return true;
        }
        return false;
    }

    public static boolean isInQueueWithoutModifying(Queue<Integer> queue, Integer value) {
        Queue<Integer> tempQueue = new Queue<Integer>();
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