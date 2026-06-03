public class ChocolateBarBreaks {
    public static int calculateMinimumAmountOfBreaks(int w, int l) {
        if (w < 1 || l < 1)
            return -1;
        return (w * l) - 1;
    }

    public static int calculateMinimumAmountOfBreaks(int w, int l, int minSize) {
        if (w < minSize || l < minSize || w % minSize != 0 || l % minSize != 0)
            return -1;

        w /= minSize;
        l /= minSize;
        return (w * l) - 1;
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumAmountOfBreaks(2, 2));
        System.out.println(calculateMinimumAmountOfBreaks(1, -1));

        System.out.println(calculateMinimumAmountOfBreaks(4, 4, 2));

    }
}