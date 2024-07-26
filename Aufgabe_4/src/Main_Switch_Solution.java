import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main_Switch_Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Zahl eingeben:");

        try {
            int numberOfMonth = Integer.parseInt(scanner.nextLine());
            String month;

            switch (numberOfMonth) {
                case 1:
                    month = "Januar";
                    break;
                case 2:
                    month = "Februar";
                    break;
                case 3:
                    month = "März";
                    break;
                case 4:
                    month = "April";
                    break;
                case 5:
                    month = "Mai";
                    break;
                case 6:
                    month = "Juni";
                    break;
                case 7:
                    month = "Juli";
                    break;
                case 8:
                    month = "August";
                    break;
                case 9:
                    month = "September";
                    break;
                case 10:
                    month = "Oktober";
                    break;
                case 11:
                    month = "November";
                    break;
                case 12:
                    month = "Dezember";
                    break;
                default:
                    System.out.println("🧐 Gültig sind nur Ganzzahlen von 1 bis 12.");
                    return;
            }

            System.out.println("Monat: " + month);

        } catch (NumberFormatException ex) {
            System.out.println("Ungültige Eingabe. Ganzzahl erwartet.");
        } catch (Exception ex) {
            System.out.println("Unbekannter Fehler: " + ex);
        }
    }
}