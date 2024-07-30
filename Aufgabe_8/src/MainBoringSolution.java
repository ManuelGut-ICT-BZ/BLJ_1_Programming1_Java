import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainBoringSolution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "notSet";

        while (!input.equals("q")) {
            System.out.println("Ganzzahlige Dezimalzahl (q to Quit):");
            input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                String bin = Integer.toBinaryString(number);
                System.out.println("Binär: " + bin);

            } catch (NumberFormatException numberFormatException) {
                if (!input.equals("q")) {
                    System.out.println("Nur ganzzahlen erlaubt!");
                }
            }

        }
    }
}