import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        // picking a word
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] words = {"Apple", "Banana", "Carpet", "Dolphin", "Elephant", "Flamingo", "Giraffe", "Hamburger", "Iceberg", "Jaguar",
                "Kangaroo", "Lighthouse", "Mushroom", "Nectarine", "Octopus", "Penguin", "football", "Rainbow", "Seahorse", "Tiger",
                "Umbrella", "Violin", "Watermelon", "Xylophone", "Yak", "Zebra", "Airplane", "Basketball", "Cactus", "Dandelion",
                "Espresso", "Fireworks", "Gorilla", "Hammock", "Iguana", "Jigsaw", "Kiwi", "Llama", "Mandolin", "Narwhal", "Ostrich",
                "Parrot", "Quilt", "Raccoon", "Saxophone", "Toucan", "Ukulele", "Volleyball", "Walrus", "Xenon", "Yacht", "Zucchini",
                "Ambulance", "Backpack", "Computer", "Dinosaur", "Elephant", "Firetruck", "Guitar", "Helicopter", "Island", "Jellyfish",
                "Koala", "Lighthouse", "Motorcycle", "Notebook", "Orangutan", "Pineapple", "tiger", "Rainbow", "Seahorse", "Telescope",
                "Umpire", "Vegetables", "Waterfall", "Xylophone", "Yarn", "Zucchini", "Astronaut", "Butterfly", "Caterpillar",
                "Dragonfly", "underwear", "Fireworks", "Grasshopper", "Hummingbird", "Icicle", "Jellyfish", "Kaleidoscope", "Ladybug",
                "Moonlight", "Nightingale", "Octopus", "Parachute", "Quilt", "Rainbow", "Starfish", "Thunderstorm", "Universe", "Waterfall"};
        int randomIndex = random.nextInt(words.length);
        String answer = words[randomIndex];
        answer = answer.toLowerCase();
        String gameState = "";
        int amountOfWrongGuesses = 0;
        boolean wordFound = false;

        for (int i = 0; i < answer.length(); i++) {
            System.out.print("_");
            gameState += "_";
        }

        System.out.println();
        System.out.println(answer);
        while (!wordFound) {
            System.out.println("guess");
            String guess = scanner.nextLine();
            if (answer.equals(guess)) {
                System.out.println("Correct");
                wordFound = true;
            } else if (!answer.contains(guess)) {
                System.out.println("Incorrect");
                amountOfWrongGuesses++;
                continue;
            } else {
                gameState = gameState.replaceAll(String.valueOf(gameState.charAt(gameState.indexOf(guess))), guess);
            }
            if (gameState.toLowerCase().equals(answer.toLowerCase())) {
                System.out.println("Correct");
                wordFound = true;
            }
            if (amountOfWrongGuesses == 10) {
                System.out.println("You lost");
                wordFound = true;
            }
        }
    }
}
