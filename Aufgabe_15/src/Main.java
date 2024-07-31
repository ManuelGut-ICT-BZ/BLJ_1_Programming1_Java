import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int MAX_NUMBER = 100;
    private static int tryCounter = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String playAgain = "y";

        while (playAgain.equals("y")) {
            boolean isCorrect = false;
            Random random = new Random();
            int solution = random.nextInt(MAX_NUMBER + 1);


            while (!isCorrect) {
                int guessedNumber;
                do {
                    System.out.println("Deine Zahl (1..100):");
                    guessedNumber = readNumberFromConsole(scanner);
                } while (guessedNumber < 0);
                isCorrect = isCorrectCheck(guessedNumber, solution);
            }
            playAgain = scanner.nextLine();
            if (playAgain.equals("y")) {
                setBack();
            }
        }
    }

    private static int readNumberFromConsole(Scanner scanner) {
        int input = -1;
        try {
            input = Integer.parseInt(scanner.nextLine());
            if (input < 0 || input > 100) {
                System.out.println("Nur Zahlen zwischen 0 und 100 sind erlaubt.");
                input = -1;
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Nur positive Ganzzahlen zwischen 0 und 100 sind erlaubt.");
        }
        return input;
    }

    private static boolean isCorrectCheck(int guessedNumber, int solution) {
        tryCounter++;
        if (guessedNumber < solution) {
            System.out.println("Zahl ist zu klein, nächster Versuch");
            return false;
        } else if (guessedNumber > solution) {
            System.out.println("Zahl ist zu gross, nächste Versuch");
            return false;
        } else {
            System.out.println("Die Zahl stimmt! Du hast total " + tryCounter + " Versuche benötigt. Noch einmal spielen? [y/n]");
            return true;
        }
    }

    private static void setBack() {
        tryCounter = 0;
    }
}