package school;

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
}