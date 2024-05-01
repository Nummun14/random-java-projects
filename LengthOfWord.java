import java.util.Scanner;

public class LengthOfWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        System.out.println("Length of the word is: " + word.length());

        scanner.close();
    }
}
