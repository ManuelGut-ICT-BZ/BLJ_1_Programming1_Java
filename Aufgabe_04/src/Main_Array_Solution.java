import java.util.Scanner;

public class Main_Array_Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Zahl eingeben:");

        String[] months = new String[]{"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August",
                "September", "Oktober", "November", "Dezember"};

        int numberOfMonth;

        try {
            numberOfMonth = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Ungültige Eingabe. Ganzzahl erwartet.");
            return;
        }

        if(numberOfMonth >= 1 && numberOfMonth <= 12 ){
            System.out.println("Monat: " + months[numberOfMonth - 1]);
        }else{
            System.out.println("🧐 Gültig sind nur Ganzzahlen von 1 bis 12.");
        }

    }
}
