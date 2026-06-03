import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GoogleInterviewQuestion {
    public static List<String> loadWords(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(); // Return empty list on error
        }
    }
    public static final List<String> WORDS = loadWords("words.txt");

    public static String[] findPossibleWords(String word) {
        ArrayList<String> possibleWords = new ArrayList<>();
        for (String currentWord : WORDS) {
            if (word.length() != currentWord.length())
                continue;
            boolean isValidWord = true;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) != currentWord.charAt(j) && word.charAt(j) != '_') {
                    isValidWord = false;
                    break;
                }
            }
            if (isValidWord)
                possibleWords.add(currentWord);
        }
        return possibleWords.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPossibleWords("s_i_e")));
    }
}