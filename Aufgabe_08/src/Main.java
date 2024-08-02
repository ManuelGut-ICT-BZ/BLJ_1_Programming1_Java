import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "notSet";

        while (!input.equals("q")) {
            System.out.println("Ganzzahlige Dezimalzahl (q to Quit):");
            input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                String bin = calculateBinaryString(number);
                System.out.println("Binär: " + bin);

            } catch (NumberFormatException numberFormatException) {
                if (!input.equals("q")) {
                    System.out.println("Nur ganzzahlen erlaubt!");
                }
            }
        }

        // executeTest("1010", calculateBinaryString(10));
        // executeTest("101010", calculateBinaryString(42));
        // executeTest("1111101000", calculateBinaryString(1000));

    }

    private static String calculateBinaryString(int n) {
        String bin = "";
        do {
            int rest = n % 2;
            bin = rest + bin;
            int wert = n / 2;
            n = wert;
        } while (n != 0);
        return bin;
    }

    private static void executeTest(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("💚 Dein Ergebnis " + actual + " ist gleich wie das erwartete Ergebnis " + expected);
        } else {
            System.out.println("🟥 Dein Ergebnis " + actual + " ist anders als das erwartete Ergebnis " + expected);
        }
    }
}
