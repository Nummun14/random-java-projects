import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}