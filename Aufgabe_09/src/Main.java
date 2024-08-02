import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Zahl: ");

        try {
            int zahl = Integer.parseInt(scanner.nextLine());
            int quersumme = berechneQuersumme(zahl);
            System.out.println("Die Quersumme von " + zahl + " ist: " + quersumme);

        } catch (NumberFormatException numberFormatException) {
            System.out.println("❌ Es sind nur Ganzzahlen erlaubt!");
        }
    }

    static int berechneQuersumme(int zahl) {
        int sum = 0;
        while (zahl != 0) {
            sum += (zahl % 10);
            zahl /= 10;
        }
        return sum;
    }
}