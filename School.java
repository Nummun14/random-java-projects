public class School {
    public static boolean isSquareRootWhole(int number) {
        int m = 0;
        while (m * m < number)
            m++;
        return m * m == number;
    }
}
