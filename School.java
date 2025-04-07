public class School {
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

    public static void main(String[] args) {
        System.out.println(combine("oned", "thin"));
        System.out.println(combineBetter("oned", "thin"));
    }
}