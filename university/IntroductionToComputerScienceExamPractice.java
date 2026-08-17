package university;

public class IntroductionToComputerScienceExamPractice {
    private static int sigma(int num, int currentNum) {
        if (num == currentNum)
            return num;
        return currentNum + sigma(num, currentNum + 1);
    }

    private static int getSum(int[] arr, int[] indexes, int index) {
        if (index == arr.length)
            return 0;

        return arr[indexes[index]] + getSum(arr, indexes, index);
    }

    private static void printPath(int[] arr, int index) {
        if (index == arr.length)
            return;

        System.out.print(arr[index]);
        if (index != arr.length - 1) {
            System.out.print(" -- ");
            printPath(arr, index + 1);
        }
    }

    public static int findTriplet(int[] arr) {
        if (arr.length < 3)
            return 0;

        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;
        int thirdLowest = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
            else if (arr[i] > secondMax)
                secondMax = arr[i];

            if (arr[i] < lowest) {
                thirdLowest = secondLowest;
                secondLowest = lowest;
                lowest = arr[i];
            }
            else if (arr[i] < secondLowest) {
                thirdLowest = secondLowest;
                secondLowest = arr[i];
            }
            else if (arr[i] < thirdLowest)
                thirdLowest = arr[i];
        }

        int value1 = lowest * thirdLowest * secondLowest;
        int value2 = lowest * max * secondMax;

        if (value2 < value1)
            System.out.println(lowest + " " + max + " " + secondMax);
        else
            System.out.println(lowest + " " + secondLowest + " " + thirdLowest);
        return Math.min(value2, value1);
    }

    public static int alternateSorted(int[] a, int[] b) {
        int[] x = new int[0];
        int[] maxArray = alternateSorted(a, b, 0, 0, false, x);
        int[] maxArray2 = alternateSorted(a, b, 0, 0, true, x);

        if (maxArray.length < maxArray2.length)
            maxArray = maxArray2;

        printArrayWithBraces(maxArray, 0);

        return maxArray.length;
    }

    private static int[] alternateSorted(int[] a, int[] b, int currentAIndex, int currentBIndex, boolean isATurn, int[] currentArray) {
        if ((currentAIndex == a.length && isATurn) || (!isATurn && currentBIndex == b.length))
            return currentArray;

        int[] arr = new int[currentArray.length + 1];
        fillArray(arr, currentArray, 0);
        int i = findNextIndex(isATurn ? a : b, isATurn ? currentAIndex : currentBIndex, arr.length > 1 ? arr[arr.length - 2] : Integer.MIN_VALUE);
        if (i == -1)
            return currentArray;

        int[] maxWith;
        if (isATurn) {
            arr[arr.length - 1] = a[i];
            maxWith = alternateSorted(a, b, i, currentBIndex, false, arr);
        } else {
            arr[arr.length - 1] = b[i];
            maxWith = alternateSorted(a, b, currentAIndex, i, true, arr);
        }

        if (isATurn)
            currentAIndex++;
        else
            currentBIndex++;

        int[] maxWithout = alternateSorted(a, b, currentAIndex, currentBIndex, isATurn, currentArray);

        if (maxWithout.length > maxWith.length)
            return maxWithout;
        return maxWith;
    }

    private static void fillArray(int[] newArray, int[] arr, int currentIndex) {
        if (currentIndex == arr.length)
            return;
        newArray[currentIndex] = arr[currentIndex];
        fillArray(newArray, arr, currentIndex + 1);
    }

    private static void printArrayWithBraces(int[] arr, int currentIndex) {
        if (currentIndex == 0)
            System.out.print("{");
        if (currentIndex == arr.length) {
            System.out.print("}");
            return;
        }

        System.out.print(arr[currentIndex]);
        if (currentIndex != arr.length - 1)
            System.out.print(", ");

        printArrayWithBraces(arr, currentIndex + 1);
    }

    private static int findNextIndex(int[] arr, int currentIndex, int num) {
        if (currentIndex == arr.length)
            return -1;
        if (arr[currentIndex] > num)
            return currentIndex;
        return findNextIndex(arr, currentIndex + 1, num);
    }

    public static int findFirstMissing(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] <= arr.length && arr[i] > 0 && arr[i] != arr[arr[i] - 1]) {
                int num = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = num;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1)
                return i + 1;
        }

        return arr.length + 1;
    }

    public static int countEqualDiff(int[] arr) {
        int[] arr1 = new int[0];
        int[] arr2 = new int[0];
        return helper(0, arr1, arr2, arr);
    }

    private static int helper(int currentCount, int[] currentArray, int[] currentOtherArray, int[] arr) {
        if (arr.length == currentArray.length + currentOtherArray.length) {
            if (areEqualDiff(currentArray, currentOtherArray))
                currentCount++;
            return currentCount;
        }

        int[] newCurrentArray = new int[currentArray.length + 1];
        fillArray(newCurrentArray, currentArray, 0);
        int[] newOtherArray = new int[currentOtherArray.length + 1];
        fillArray(newOtherArray, currentOtherArray, 0);

        newCurrentArray[newCurrentArray.length - 1] = arr[newCurrentArray.length + currentOtherArray.length - 1];
        newOtherArray[newOtherArray.length - 1] = arr[newOtherArray.length + currentArray.length - 1];

        return helper(currentCount, newCurrentArray, currentOtherArray, arr) + helper(currentCount, currentArray, newOtherArray, arr);
    }

    private static boolean areEqualDiff(int[] arr1, int[] arr2) {
        int sum1 = getArraySum(arr1, 0);
        int sum2 = getArraySum(arr2, 0);
        if (Math.abs(sum1 - sum2) == Math.abs(arr1.length - arr2.length)) {
            printArray(arr1, 0);
            System.out.print("\t sum = " + sum1 + " count = " + arr1.length);
            System.out.println();
            printArray(arr2, 0);
            System.out.print("\t sum = " + sum2 + " count = " + arr2.length);
            System.out.println();

            return true;
        }

        return false;
    }

    private static void printArray(int[] arr, int currentIndex) {
        if (currentIndex == arr.length)
            return;

        System.out.print(arr[currentIndex] + " ");
        printArray(arr, currentIndex + 1);
    }

    private static int getArraySum(int[] arr, int currentIndex) {
        if (currentIndex == arr.length)
            return 0;
        return arr[currentIndex] + getArraySum(arr, currentIndex + 1);
    }
}