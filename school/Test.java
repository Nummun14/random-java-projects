package school;

import school.queue.Queue;
import school.queue.QueueUtils;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        boolean found = true;
        while (found) {
            int input = scanner.nextInt();
            if (input == -1)
                found = false;
            else
                queue.insert(input);
        }

        System.out.println(QueueUtils.getBiggest(queue));
    }
}
