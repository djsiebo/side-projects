import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramTest {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What is the first string you want to compare?");
        String wordOne = userInput.nextLine();
        System.out.printf("\nWhat is the second string you want to compare?");
        String wordTwo = userInput.nextLine();
        isAnagram(wordOne, wordTwo);
    }

    public static boolean isAnagram(String wordOne, String wordTwo) {

        Map<String, Integer> mapOne = new HashMap<>();
        Map<String, Integer> mapTwo = new HashMap<>();

        String[] arrayOne = wordOne.replaceAll("[^A-Za-z0-9]+", "").toLowerCase().split("");
        String[] arrayTwo = wordTwo.replaceAll("[^A-Za-z0-9]+", "").toLowerCase().split("");

        for (int i = 0; i < arrayOne.length; i++) {
            if (!mapOne.containsKey(arrayOne[i])) {
                mapOne.put(arrayOne[i], 1);
            } else {
                mapOne.put(arrayOne[i], mapOne.get(arrayOne[i]) + 1);
            }
        }

        for (int i = 0; i < arrayTwo.length; i++) {
            if (!mapTwo.containsKey(arrayTwo[i])) {
                mapTwo.put(arrayTwo[i], 1);
            } else {
                mapTwo.put(arrayTwo[i], mapTwo.get(arrayTwo[i]) + 1);
            }
        }

        if (mapOne.equals(mapTwo)) {
            System.out.println("\nThese strings are anagrams of each other.");
            return true;
        } else {
            System.out.println("\nThese strings are not anagrams of each other.");
            return false;
        }
    }
}

