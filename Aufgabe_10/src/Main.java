import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = readNumbers(scanner);
        printHeader();

        for (int i = numbers[0]; i <= numbers[1]; i++) {
            int crossSum = calculateCrossSum(i);
            if (i % crossSum == 0) {
                //System.out.println(i + "\t\t| " + crossSum + "\t\t\t\t| " + i / crossSum);
                System.out.print(formatStringWithWhitespace(String.valueOf(i), 10) + "| ");
                System.out.print(formatStringWithWhitespace(String.valueOf(crossSum), 20) + "| ");
                System.out.println(formatStringWithWhitespace(String.valueOf(i), 20));
            }
        }
    }

    private static int calculateCrossSum(int zahl) {
        int sum = 0;
        while (zahl != 0) {
            sum += (zahl % 10);
            zahl /= 10;

        }
        return sum;
    }

    private static int[] readNumbers(Scanner scanner) {
        int[] numbers = new int[2];
        System.out.println("Zahl 1:");
        numbers[0] = readNumber(scanner);
        System.out.println("Zahl 2:");
        numbers[1] = readNumber(scanner);
        return numbers;
    }

    private static int readNumber(Scanner scanner) {
        String input = scanner.nextLine();
        while (!isInt(input)) {
            System.out.println("Ungültige Eingabe. Bitte Ganzzahl eingeben:");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    private static boolean isInt(String s) {

        try {
            Integer.parseInt(s);
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    private static void printHeader() {
        System.out.println("-------------------------------------------------------");
        System.out.print(formatStringWithWhitespace("Zahl", 10) + "| ");
        System.out.print(formatStringWithWhitespace("Quersumme", 20) + "| ");
        System.out.println(formatStringWithWhitespace("Zahl / Quersumme", 20));
        System.out.println("--------------------------------------------------------");
    }

    private static String formatStringWithWhitespace(String textToFormat, int fieldLength) {
        return textToFormat + " ".repeat(fieldLength - textToFormat.length());
    }
}

