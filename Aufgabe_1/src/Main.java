import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Dieses Programm berechnet die Summe von zwei Zahlen.");

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Zahl 1: ");
            int input1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Zahl 2: ");
            int input2 = Integer.parseInt(scanner.nextLine());
            int sum = input1 + input2;
            System.out.print("Summe: " + sum);
        } catch (Exception exception) {
            System.out.println("Es sind nur Zahlen erlaubt.");
        }
    }
}