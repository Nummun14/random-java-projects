import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Arrays;

public class Codewars {
    private static String yesOrNo(boolean bool) {
        return bool ? "Yes" : "No";
    }

    private static int sortDesc(final int num) {
        char[] numChars = Integer.toString(num).toCharArray();
        String newNum = "";
        Arrays.sort(numChars);
        for (char numChar : numChars)
            newNum = numChar + newNum;
        return Integer.parseInt(newNum);
    }

    public static String areYouPlayingBanjo(String name) {
        return Character.toString(name.toLowerCase().charAt(0)).equals("r") ? name + " plays banjo" : name + " does not play banjo";
    }

    public static String evenOrOdd(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    public static List<Object> filterList(final List<Object> list) {
        List<Object> newList = new ArrayList<Object>();
        for (Object item : list) {
            if (item instanceof Integer)
                newList.add(item);
        }
        return newList;
    }

    public static String convert(boolean b) {
        return b ? "true" : "false";
    }

    public int GetSum(int a, int b) {
        int sum = b;
        if (a > b) {
            sum = a;
            a = b;
            b = sum;
        }
        for (int i = a; i < b; i++)
            sum += i;
        return sum;
    }

    public static int countPassengers(ArrayList<int[]> stops) {
        int end = 0;
        for (int[] i : stops) {
            end += i[0];
            end -= i[1];
        }
        return end;
    }

    public static String makeReadable(int seconds) {
        int hours = seconds / 3600;
        seconds -= 3600 * hours;
        int minutes = seconds / 60;
        seconds -= 60 * minutes;
        return String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
    }

    public static int[] countBy(int x, int n){
        int[] result = new int[n];
        for (int i = x; i < n * x + 1; i += x)
            result[i / x - 1] = i;
        return result;
    }

    public static int[] digitize(long n) {
        char[] nChars = Long.toString(n).toCharArray();
        int[] result = new int[nChars.length];
        for (int i = 0; i < nChars.length; i++)
            result[i] = Integer.parseInt(Character.toString(nChars[nChars.length - i - 1]));
        return result;
    }
}