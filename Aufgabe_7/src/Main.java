//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Zahlen zwischen 1 und 30, die durch 5 und/oder 3 ohne Rest teilbar sind:");
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i != 30) {
                    System.out.print(i + ", ");
                } else {
                    System.out.print(i);
                }
            }
        }
    }
}