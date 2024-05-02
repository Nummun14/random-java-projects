import java.util.Scanner;

public class WordsInSentence {

    static String Calculate(String sentence) {
        boolean ifWord = false;
        int wordSum = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetter(sentence.charAt(i))) {
                if (!ifWord) {
                    wordSum += 1;
                }
                ifWord = true;
            } else {
                ifWord = false;
            }
        }
        String total = Integer.toString(wordSum);
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();

        System.out.println("The number of words is " + Calculate(sentence));
    }
}
