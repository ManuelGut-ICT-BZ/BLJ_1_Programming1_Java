import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static int i = 10;

    public static void main(String[] args) {

        /*
         * do {
         * doSomething(); // kann i manipulieren
         * } while (i >= 0);
         */


        doSomething();
        while(i >= 0){
            doSomething();
        }

    }

    private static void doSomething(){
        System.out.println(i);
        i--;
    }
}