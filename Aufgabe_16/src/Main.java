import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static int counterAllVocals = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] vocals = {'a', 'e', 'i', 'o', 'u', 'ä', 'ö'};
        System.out.println("Deine Eingabe:");
        String input = scanner.nextLine().toLowerCase();
        HashMap<Character, Integer> solutionMap = countVocals(vocals, input);
        printSolution(solutionMap);
    }

    private static HashMap<Character, Integer> setUpHashMap(char[] vocals) {
        HashMap<Character, Integer> solutionMap = new HashMap<>();
        for (char vocal : vocals) {
            solutionMap.put(vocal, 0);
        }
        return solutionMap;
    }

    private static HashMap<Character, Integer> countVocals(char[] vocals, String input) {
        HashMap<Character, Integer> solutionMap = setUpHashMap(vocals);
        for (char letter : input.toCharArray()) {
            if (solutionMap.containsKey(letter)) {
                counterAllVocals++;
                solutionMap.put(letter, solutionMap.get(letter) + 1);
            }
        }
        return solutionMap;
    }

    private static void printSolution(HashMap<Character, Integer> solutionMap) {
        System.out.println("Dein Text hat total " + counterAllVocals + " Vokale");
        for (char vocal : solutionMap.keySet()) {
            if (solutionMap.get(vocal) > 0) {
                System.out.println("Der Buchstabe " + vocal + " kommt " + solutionMap.get(vocal) + " mal vor.");
            }
        }
    }
}