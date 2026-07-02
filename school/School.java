package school;

import java.util.Scanner;

public class School {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        if (right(num1) == right(num2) && num1 % 10 == num2 % 10)
            System.out.println("Numbers are brothers");
        else
            System.out.println("Numbers are not brothers");
    }

    public static boolean isOrderedPlaces(int[] arr) {
        if (arr.length <= 2)
            return true;
        for (int i = 2; i < arr.length; i += 2) {
            if (arr[i] < arr[i - 2])
                return false;
        }
        return true;
    }

    public static boolean isOrderedValues(int[] arr) {
        if (arr.length <= 1)
            return true;

        int lastEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] < lastEven)
                    return false;
                lastEven = arr[i];
            }
        }
        return true;
    }

    public static int right(int num) {
        while (num >= 10)
            num /= 10;

        return num;
    }

    public static boolean isSquareRootWhole(int number) {
        int m = 0;
        while (m * m < number)
            m++;
        return m * m == number;
    }

    public static String combine(String first, String second) {
        char[] firstList = first.toCharArray();
        char[] secondList = second.toCharArray();
        char[] combined = new char[(firstList.length / 2) + (secondList.length / 2)];
        for (int i = firstList.length / 2, j = 0; i < firstList.length; i++, j++)
            combined[i] = firstList[j];
        for (int i = 0, j = secondList.length / 2; j < secondList.length; j++, i++)
            combined[i] = secondList[j];
        return new String(combined);
    }

    public static String combineBetter(String first, String second) {
        String s1 = first.substring(0, first.length() / 2);
        String s2 = second.substring(second.length() / 2);
        return s2 + s1;
    }
}