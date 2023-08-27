import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("D:/Lectures/Programming/Java/Hangman-Game-in-Java-/words.txt/"));

        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));
        System.out.println(word);

        List<Character> playGuesses = new ArrayList<>();

        for (int i = 0; i < word.length(); i++){
            if (playGuesses.contains(word.charAt(i))){
                System.out.println(word.charAt(i));
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println();

    }
}