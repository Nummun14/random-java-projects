import java.util.HashSet;

public class MaximumUniqueWindowSum {
    public static int maximumWindowSum(int[] numbers, int k) {
        if (numbers.length < k)
            return -1;

        int highestSum = 0;
        for (int i = 0; i <= numbers.length - k; i++) {
            HashSet<Integer> seen = new HashSet<>();
            int currentSum = 0;
            boolean validWindow = true;

            for (int j = 0; j < k; j++) {
                if (seen.contains(numbers[i + j])) {
                    validWindow = false;
                    break;
                }
                seen.add(numbers[i + j]);
                currentSum += numbers[i + j];
            }
            if (validWindow)
                highestSum = Math.max(currentSum, highestSum);
        }

        return highestSum;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 1, 2, 3, 2, 9, 2};
        System.out.println(maximumWindowSum(a, 3));
        // 14
        System.out.println(maximumWindowSum(a, 4));
        // 12
        System.out.println(maximumWindowSum(a, 10));
        // -1
        System.out.println(maximumWindowSum(a, 5));
        // 0
    }
}