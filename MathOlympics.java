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
        if (a.length != 12)
            return -1;

        int sum = 0;
        Arrays.sort(a);
        for (int i = a.length - 2; i > 3; i -= 2)
            sum += a[i];

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {120, 119, 109, 118, 117, 110, 116, 115, 111, 114, 113, 112};
        System.out.println(maxFruitPrice(a)); // 464
        int[] b = {96, 104, 104, 104, 96, 104, 100, 100, 96, 97, 98, 98};
        System.out.println(maxFruitPrice(b)); // 406
        int[] c = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(maxFruitPrice(c)); // 4
        int[] d = {6, 11, 9, 12, 12};
        System.out.println(maxFruitPrice(d)); // -1
    }
}