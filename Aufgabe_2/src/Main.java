import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Berechnung von Sekunden eines Monats in Abhängigkeit seiner Anzahl Tage");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Wieviele Tage hat der Monat, für den Sie die Sekundenzahl berechnen wollen?");
        Scanner scanner = new Scanner(System.in);
        try {
            int amountOfDays = Integer.parseInt(scanner.nextLine());

            if(amountOfDays >= 28 && amountOfDays <= 31){
                int amountOfSeconds = amountOfDays * 24 * 60 * 60;
                System.out.println("Ein Monat mit " + amountOfDays + " Tagen hat " + amountOfSeconds + " Sekunden.");
            }else {
                System.out.println("Ungültige Eingabe. Ein Monat mit " + amountOfDays + " gibt es nicht.");
            }

        } catch (NumberFormatException ex) {
            System.out.println("Ungültige Eingabe. Ganzzahl erwartet.");
        } catch (Exception ex) {
            System.out.println("Unbekannter Fehler: " + ex);
        }
    }
}