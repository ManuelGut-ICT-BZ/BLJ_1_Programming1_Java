import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String fillingCar = "*";

        try {
            System.out.print("Breite des Stammes? ");
            int widthTrunk = Integer.parseInt(scanner.nextLine());
            System.out.print("Höhe des Stammes? ");
            int heightTrunk = Integer.parseInt(scanner.nextLine());
            System.out.print("Höhe der Krone? ");
            int heightTreeTop = Integer.parseInt(scanner.nextLine());

            drawTreeTop(heightTreeTop, fillingCar);
            drawTreeTrunk(heightTrunk, widthTrunk, heightTreeTop, fillingCar);

        } catch (NumberFormatException numberFormatException) {
            System.out.println("❌ Fehler: Es sind nur Ganzzahlen erlaubt.");
        }
    }

    public static void drawTreeTop(int heightTreeTop, String fillingCar) {
        for (int i = 1; i <= heightTreeTop; i++) {
            drawRow(calculateTreeTopWidth(heightTreeTop), calculateTreeTopWidth(i), fillingCar);
        }
    }

    public static void drawTreeTrunk(int heightTrunk, int widthTrunk, int heightTreeTop, String fillingCar) {
        for (int i = 1; i <= heightTrunk; i++) {
            drawRow(calculateTreeTopWidth(heightTreeTop), widthTrunk, fillingCar);
        }
    }

    public static void drawRow(int lengthRow, int amountFilling, String fillingChar) {
        int amountFillingEachSide = (lengthRow - amountFilling) / 2;
        System.out.println(" ".repeat(amountFillingEachSide) + fillingChar.repeat(amountFilling) + " ".repeat(amountFillingEachSide));
    }

    public static int calculateTreeTopWidth(int heightTreeTop) {
        return heightTreeTop * 2 - 1;
    }
}