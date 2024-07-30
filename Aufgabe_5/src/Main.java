import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wie viele Kilometer möchtest du rennen?");

        try {
            int distanceInKilometer = Integer.parseInt(scanner.nextLine());
            if (distanceInKilometer > 42) {
                System.out.println("Das schaffst du nicht 😜");
            } else {
                float roundAmount = calculateRounds(distanceInKilometer);
                System.out.println("Das sind " + roundAmount + " Runden. Bereit für den Lauf?");
                String readyCommand;
                do {
                    readyCommand = scanner.nextLine();
                    readyCommand = readyCommand.toLowerCase();
                    if (readyCommand.equals("ja")) {
                        runRounds(roundAmount);
                        System.out.println("Du hast es geschafft!");
                    } else if (readyCommand.equals("nein")) {
                        return;
                    } else {
                        System.out.println("Eingabe ungültig. Zulässige Werte sind 'ja' oder 'nein'");
                    }
                } while (!readyCommand.equals("ja"));
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Ungültige Eingabe. Ganzzahl erwartet.");
        }
    }

    private static float calculateRounds(int distanceInKilometer) {
        return distanceInKilometer / 0.4f;
    }

    private static void runRounds(float roundAmount) {
        for (int i = 0; i <= roundAmount; i++) {
            System.out.println("Du läufst Runde " + i);
        }
    }
}