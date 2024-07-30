import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char fillingChar = '*';
        char lineChar = ' ';

        try {

            System.out.print("""
                    Wie lang soll die Linie sein?
                    Deine Eingabe:""" + " ");
            int amountLines = Integer.parseInt(scanner.nextLine());

            for(int i = 1; i <= amountLines; i++){
                for(int j = 1; j <= amountLines; j++){
                    if(i != j) {
                        System.out.print(fillingChar);
                    }else{
                        System.out.print(lineChar);
                    }
                }
                System.out.println();
            }

        }catch (NumberFormatException numberFormatException){
            System.out.println("Nur Ganzzahlen als Eingabe erlaubt.");
        }

    }
}