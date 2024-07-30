import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printHeader();

        while (true) {
            System.out.print("Eingabe Jahr (q to quit): ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            try {
                int year = Integer.parseInt(input);
                String messageDynamicPart = "KEIN";
                if (isLeapYear(year)) {
                    messageDynamicPart = "ein";
                }
                String message = "Das Jahr " + year + " ist " + messageDynamicPart + " Schaltjahr";
                System.out.println(message);
            } catch (NumberFormatException e) {
                System.out.println("Nur Ganzzahlen erlaubt.");
            }
        }
    }

    private static void printHeader() {
        System.out.println("""
                Prüfen, ob es sich bei einem Jahr um ein Schaltjahr handelt.
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                """);
    }

    private static boolean isLeapYear(int year) {
        return isModulo4(year) && (!isModulo100(year) || isModulo100(year) && isModulo400(year));
    }

    private static boolean isModulo4(int number) {
        return number % 4 == 0;
    }

    private static boolean isModulo100(int number) {
        return number % 100 == 0;
    }

    private static boolean isModulo400(int number) {
        return number % 400 == 0;
    }
}
