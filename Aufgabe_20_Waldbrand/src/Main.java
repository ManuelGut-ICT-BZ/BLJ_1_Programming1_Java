import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int TIME_INTERVALL_IN_SECONDS = 2;
    private static final String TREE = "🌲";
    private static final String TREE_BURNING = "🔥";
    private static final String TREE_BURNT = "🔺";
    private static final String HUMUS = "🟫";
    private static final String STONE = "🪨";
    private static final String[][] PLAYGROUND = new String[10][30]; // 10 30
    private static final int PROBABILITY_FIRE_PERCENT = 1;
    private static final int PROBABILITY_NEW_TREE_PERCENT = 1;
    private static final Random RANDOM = new Random();


    public static void main(String[] args) throws InterruptedException {

        setUpPlayground();
        drawPlayground();


        while (true) {
            sleep(TIME_INTERVALL_IN_SECONDS * 1000);
            changePlayground();
            drawPlayground();
        }
    }


    private static void setUpPlayground() {

        for (int i = 0; i < PLAYGROUND.length; i++) {
            for (int j = 0; j < PLAYGROUND[i].length; j++) {
                switch (RANDOM.nextInt(3)) {
                    case 0 -> PLAYGROUND[i][j] = TREE;
                    case 1 -> PLAYGROUND[i][j] = STONE;
                    case 2 -> PLAYGROUND[i][j] = HUMUS;
                }
            }
        }
    }

    private static void drawPlayground() {
        for (int i = 0; i < PLAYGROUND.length; i++) {
            for (int j = 0; j < PLAYGROUND[i].length; j++) {
                System.out.print(PLAYGROUND[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("---------------------------------------------------------");
        System.out.println();
    }

    private static void changePlayground() {
        for (int i = 0; i < PLAYGROUND.length; i++) {
            for (int j = 0; j < PLAYGROUND[i].length; j++) {
                // Reihenfolge der if-Statements ist wichtig, da sonst der Baum in einem Zeitintervall brennt, verbrennt und zu Humus wird
                // verglühter Baum wird zu Humus
                if (PLAYGROUND[i][j].equals(TREE_BURNT)) {
                    PLAYGROUND[i][j] = HUMUS;
                    System.out.println("New Humus");
                }
                // verglühender Baum
                if (PLAYGROUND[i][j].equals(TREE_BURNING)) {
                    PLAYGROUND[i][j] = TREE_BURNT;
                    System.out.println("Burnt Tree");
                }

                // spontaner neuer Baum
                if (PLAYGROUND[i][j].equals(HUMUS)) {
                    if (RANDOM.nextInt(100 / PROBABILITY_NEW_TREE_PERCENT) == 0) {
                        PLAYGROUND[i][j] = TREE;
                        System.out.println("New Tree");
                    }
                }

                // Feuer durch Nachbarbaum
                if (PLAYGROUND[i][j].equals(TREE)) {
                    if ((i > 0 && j > 0 && PLAYGROUND[i - 1][j - 1].equals(TREE_BURNING))
                            || (i > 0 && PLAYGROUND[i - 1][j].equals(TREE_BURNING))
                            || (i > 0 && j < PLAYGROUND[i].length - 2 && PLAYGROUND[i - 1][j + 1].equals(TREE_BURNING))
                            || (j > 0 && PLAYGROUND[i][j - 1].equals(TREE_BURNING))
                            || (j < PLAYGROUND[i].length - 2 && PLAYGROUND[i][j + 1].equals(TREE_BURNING))
                            || (i < PLAYGROUND.length - 2 && j > 0 && PLAYGROUND[i + 1][j - 1].equals(TREE_BURNING))
                            || (i < PLAYGROUND.length - 2 && PLAYGROUND[i + 1][j].equals(TREE_BURNING))
                            || (i < PLAYGROUND.length - 2 && j < PLAYGROUND[i].length - 2 && PLAYGROUND[i + 1][j + 1].equals(TREE_BURNING))) {
                        PLAYGROUND[i][j] = TREE_BURNING;
                        System.out.println("Fire from neighbour");
                    }
                }

                // spontanes Feuer (muss nach Feuer vom Nachbarn stehen)
                if (PLAYGROUND[i][j].equals(TREE)) {
                    if (RANDOM.nextInt(100 / PROBABILITY_FIRE_PERCENT) == 0) {
                        PLAYGROUND[i][j] = TREE_BURNING;
                        System.out.println("Tree burning");
                    }
                }
            }
        }
    }
}