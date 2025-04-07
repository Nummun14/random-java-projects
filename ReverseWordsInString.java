public class ReverseWordsInString {
    private static final String PUNCTUATION = "!”#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    public static String reverse(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (String word : words) {
            StringBuilder punctuation = new StringBuilder();
            StringBuilder wordBuilder = new StringBuilder(word);
            while (PUNCTUATION.contains(wordBuilder.subSequence(wordBuilder.length() - 1, wordBuilder.length()))) {
                punctuation.append(wordBuilder.subSequence(wordBuilder.length() - 1, wordBuilder.length()));
                wordBuilder.replace(wordBuilder.length() - 1, wordBuilder.length(), "");
            }
            reversed.append(reverseWord(wordBuilder.toString()));
            reversed.append(punctuation);
            reversed.append(" ");
        }
        return reversed.toString();
    }

    private static String reverseWord(String word) {
        StringBuilder reversed = new StringBuilder();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            String originalLetterInPlace = word.substring(i, i + 1);
            boolean isLowerCase = originalLetterInPlace.toLowerCase().equals(originalLetterInPlace);
            String letter = word.substring(length - i - 1, length - i);
            if (isLowerCase)
                reversed.append(letter.toLowerCase());
            else
                reversed.append(letter.toUpperCase());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello world!"));
        // Olleh dlrow!
        System.out.println(reverse("This is a test."));
        // Siht si a tset.
        System.out.println(reverse("Wow!!! This works? Yes, it does."));
        // Wow!!! Siht skrow? Sey, ti seod.
        System.out.println(reverse("THis iS so cOoL!!!"));
    }
}