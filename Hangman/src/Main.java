import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("D:/Lectures/Programming/Java/Hangman-Game-in-Java-/words.txt/"));
        Scanner keyboard = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));
        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        while (true) {
            printWordState(word, playerGuesses);
            getPlayerGuess(keyboard, word, playerGuesses);

            if (printWordState(word, playerGuesses)){
                System.out.println("You win!");
                break;
            }
            System.out.println("Please enter your guess for the word:");
            if (keyboard.nextLine().equals(word)){
                System.out.println("You win!");
                break;
            }
            else {
                System.out.println("Nope! Try again.");
            }
        }
    }

    private static void getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses){
            System.out.println("Please enter a letter: ");
            String letterGuess = keyboard.nextLine();
            playerGuesses.add(letterGuess.charAt(0));

            printWordState(word, playerGuesses);
    }


    private static boolean printWordState(String word, List<Character> playerGuesses){
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++){
            if (playerGuesses.contains(word.charAt(i))){
                System.out.println(word.charAt(i));
                correctCount++;
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == correctCount);
    }
}