import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

public class Main {

    private static final int TIME_INTERVAL_IN_SECONDS = 1;
    private static final String TREE = "🌲";
    private static final String TREE_BURNING = "🔥";
    private static final String TREE_BURNT = "🔺";
    private static final String HUMUS = "🟫";
    private static final String STONE = "🪨";
    private static final String[][] PLAYGROUND = new String[10][30];
    private static final int PROBABILITY_FIRE_PER_MILLE = 1;
    private static final int PROBABILITY_NEW_TREE_PER_MILLE = 100;
    private static final Random RANDOM = new Random();
    private static boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        // Sehr fortgeschritten: In einem neuen Thread auf Tastatureingabe zum Beenden der Animation warten
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            running = false;
        });
        inputThread.start();

        setUpPlayground();
        drawPlayground();

        while (running) {
            sleep(TIME_INTERVAL_IN_SECONDS * 1000);
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
        System.out.println("Press enter to quit.");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();
    }

    private static void changePlayground() {
        // Kopie des aktuellen Spielfelds
        String[][] playgroundCopy = new String[PLAYGROUND.length][PLAYGROUND[0].length];
        for (int i = 0; i < PLAYGROUND.length; i++) {
            System.arraycopy(PLAYGROUND[i], 0, playgroundCopy[i], 0, PLAYGROUND[i].length);
        }

        for (int i = 0; i < PLAYGROUND.length; i++) {
            for (int j = 0; j < PLAYGROUND[i].length; j++) {
                // verglühter Baum wird zu Humus
                if (PLAYGROUND[i][j].equals(TREE_BURNT)) {
                    PLAYGROUND[i][j] = HUMUS;
                }
                // verglühender Baum
                else if (PLAYGROUND[i][j].equals(TREE_BURNING)) {
                    PLAYGROUND[i][j] = TREE_BURNT;
                }
                // spontaner neuer Baum
                else if (PLAYGROUND[i][j].equals(HUMUS) && RANDOM.nextInt(1000) < PROBABILITY_NEW_TREE_PER_MILLE) {
                    PLAYGROUND[i][j] = TREE;
                }
                // spontanes Feuer
                else if (PLAYGROUND[i][j].equals(TREE) && RANDOM.nextInt(1000) < PROBABILITY_FIRE_PER_MILLE) {
                    PLAYGROUND[i][j] = TREE_BURNING;
                }

                // Feuer durch Nachbarbaum (mit Prüfung der Kopie)
                else if (playgroundCopy[i][j].equals(TREE) && hasBurningNeighbour(i, j, playgroundCopy)) {
                    PLAYGROUND[i][j] = TREE_BURNING;
                }
            }
        }
    }

    private static boolean hasBurningNeighbour(int i, int j, String[][] playgroundCopy) {
        return (i > 0 && j > 0 && playgroundCopy[i - 1][j - 1].equals(TREE_BURNING))
                || (i > 0 && playgroundCopy[i - 1][j].equals(TREE_BURNING))
                || (i > 0 && j < playgroundCopy[i].length - 1 && playgroundCopy[i - 1][j + 1].equals(TREE_BURNING))
                || (j > 0 && playgroundCopy[i][j - 1].equals(TREE_BURNING))
                || (j < playgroundCopy[i].length - 1 && playgroundCopy[i][j + 1].equals(TREE_BURNING))
                || (i < playgroundCopy.length - 1 && j > 0 && playgroundCopy[i + 1][j - 1].equals(TREE_BURNING))
                || (i < playgroundCopy.length - 1 && playgroundCopy[i + 1][j].equals(TREE_BURNING))
                || (i < playgroundCopy.length - 1 && j < playgroundCopy[i].length - 1 && playgroundCopy[i + 1][j + 1].equals(TREE_BURNING));
    }
}
