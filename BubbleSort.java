import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    private static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 1, 9, 2, 4, 10};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }
}