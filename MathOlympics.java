import java.util.Arrays;

public class MathOlympics {
    public static int grapefruit(int[] a) {
        int n = a.length;
        int amount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((a[i] + a[j] + a[k]) % 3 == 0)
                        amount++;
                }
            }
        }
        return amount;
    }

    public static int bilimbi(int[] bMin, int[] bMax) {
        for (int i = 0; i < bMax.length - 1; i++) {
            for (int j = 0; j < bMax.length - i - 1; j++) {
                if (bMax[j] > bMax[j + 1]) {
                    int temp = bMax[j];
                    bMax[j] = bMax[j + 1];
                    bMax[j + 1] = temp;
                    int temp2 = bMin[j];
                    bMin[j] = bMin[j + 1];
                    bMin[j + 1] = temp2;
                }
            }
        }

        int fridgeCount = 0;
        int currentMaxTemp = Integer.MIN_VALUE;

        for (int i = 0; i < bMin.length; i++) {
            if (bMin[i] > currentMaxTemp) {
                fridgeCount++;
                currentMaxTemp = bMax[i];
            }
        }
        return fridgeCount;
    }

    public static int maxFruitPrice(int[] a) {
        if (a.length % 3 != 0)
            return -1;

        int sum = 0;
        Arrays.sort(a);
        for (int i = a.length - 2; i > (a.length / 3) - 1; i -= 2)
            sum += a[i];

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {96, 104, 104, 104, 96, 104, 100, 100, 96, 97, 98, 98};
        System.out.println(maxFruitPrice(a)); // 406
        int[] b = {1, 2, 3, 4, 5, 6};
        System.out.println(maxFruitPrice(b)); // 8
        int[] c = {100, 200, 200};
        System.out.println(maxFruitPrice(c)); // 200
        int[] d = {6, 11, 9, 12, 12};
        System.out.println(maxFruitPrice(d)); // -1
    }
}