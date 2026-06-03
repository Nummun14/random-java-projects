import java.util.Arrays;

public class Leetcode {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        int maxLength = 1;
        int currentLength = maxLength;
        int startIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.substring(startIndex, i).contains(s.substring(i, i + 1))) {
                startIndex = s.indexOf(s.substring(i, i + 1), startIndex) + 1;
                maxLength = Math.max(currentLength, maxLength);
                currentLength = i + 1 - startIndex;
                continue;
            }
            currentLength++;
        }
        return Math.max(maxLength, currentLength);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = new int[nums1.length + nums2.length];
        for (int i = 0; i < combined.length; i++) {
            if (i < nums1.length) {
                combined[i] = nums1[i];
                continue;
            }
            combined[i] = nums2[i - nums1.length];
        }
        Arrays.sort(combined);
        return combined.length % 2 == 0 ? (double) (combined[combined.length / 2] + combined[combined.length / 2 - 1]) / 2 : combined[combined.length / 2];
    }

    static String DIGITS = "0123456789";

    public static int myAtoi(String s) {
        if (s.isEmpty())
            return 0;
        if (s.charAt(0) == ' ')
            return myAtoi(s.substring(1));
        StringBuilder answer = new StringBuilder(s.charAt(0) == '-' ? "-" : "");
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);
        if (s.isEmpty())
            return 0;
        if (!DIGITS.contains(s.substring(0, 1)))
            return 0;
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0')
            i++;
        while (i < s.length() && DIGITS.contains(s.substring(i, i + 1))) {
            answer.append(s.charAt(i));
            i++;
        }
        if (answer.length() > 11)
            return answer.charAt(0) == '-' ? -2147483648 : 2147483647;
        return answer.isEmpty() || answer.toString().equals("-") || answer.toString().equals("+") ? 0 : (int) Math.max(Math.min(Long.parseLong(answer.toString()), 2147483647), -2147483648);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));
    }
}