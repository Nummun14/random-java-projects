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
}