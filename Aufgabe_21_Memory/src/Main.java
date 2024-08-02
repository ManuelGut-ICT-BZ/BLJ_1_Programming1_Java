import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String[][] GAME_STATE = new String[4][4];
    private static final String[][] MEMORY = new String[4][4];
    private static final String[] SYMBOLS = {"🚢", "🌴", "💟", "🔥", "🏖️", "🍎", "🐈", "🦄"};
    private static final String FILL_CARD = "❓";
    private static final String SOLVED_CARD = " ";
    private static final String[] CARDS = new String[16];
    private static int guessCounter = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        printWelcomeText();
        setUpGame();
        printGameState();

        while (!isSolved()) {
            int[] guessedFields = readUserInput(scanner);
            checkGuess(guessedFields);
        }

    }

    private static void printWelcomeText() {
        System.out.println("""
                MEMORY -> Hinter den '?' verstecken sich Symbole, die paarweise vorkommen. Finden Sie diese!
                Zum Aufdecken wählen Sie zwei Positionen in der Form: Ziel1Spalte1Zeile2Spalte2.
                Z.Bsp.: 2142 deckt das Symbol in Zeile 2 u. Spalte 1 auf sowie das Symbol in Zeile 4 u. Spalte 2.
                """);
    }

    private static void setUpGame() {
        setUpGameState();
        setUpMemory();

    }

    private static void setUpGameState() {
        for (String[] array : GAME_STATE) {
            Arrays.fill(array, FILL_CARD);
        }
    }

    private static void setUpMemory() {
        setUpCards();
        int cardsCounter = 0;
        for (int i = 0; i < MEMORY.length; i++) {
            for (int j = 0; j < MEMORY[i].length; j++) {
                MEMORY[i][j] = CARDS[cardsCounter];
                cardsCounter++;
            }
        }
    }

    private static void setUpCards() {
        for (int i = 0; i < SYMBOLS.length; i++) {
            CARDS[i] = SYMBOLS[i];
            CARDS[i + SYMBOLS.length] = SYMBOLS[i];
        }
        shuffleCards();
    }

    private static void shuffleCards() {
        Random random = new Random();
        for (int i = CARDS.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Elemente tauschen
            String temp = CARDS[index];
            CARDS[index] = CARDS[i];
            CARDS[i] = temp;
        }
    }

    private static void printGameState() {
        System.out.println("\t1\t2\t3\t4");
        for (int i = 0; i < GAME_STATE.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < GAME_STATE.length; j++) {
                System.out.print(GAME_STATE[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void printMemory() {
        System.out.println("\t1\t2\t3\t4");
        for (int i = 0; i < MEMORY.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < MEMORY.length; j++) {
                System.out.print(MEMORY[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int[] readUserInput(Scanner scanner) {
        int[] inputNumbers = new int[4];
        String repeatText = " Wiederhole die Eingabe.";
        String input;
        boolean isValidInteger = false;
        while (!isValidInteger) {
            try {
                input = scanner.nextLine();
                int inputNumber = Integer.parseInt(input);
                char[] inputs = input.toCharArray();
                inputNumbers[0] = Character.getNumericValue(inputs[0]) - 1;
                inputNumbers[1] = Character.getNumericValue(inputs[1] - 1);
                inputNumbers[2] = Character.getNumericValue(inputs[2] - 1);
                inputNumbers[3] = Character.getNumericValue(inputs[3] - 1);
                if (inputNumber > 4444) {
                    System.out.println("Erlaubte Zahlen 1111 - 4444." + repeatText);
                } else if (inputNumbers[0] == inputNumbers[2] && inputNumbers[1] == inputNumbers[3]) {
                    System.out.println("Du hast zweimal dasselbe Feld gewählt." + repeatText);
                } else if (GAME_STATE[inputNumbers[0]][inputNumbers[1]].equals(SOLVED_CARD) ||
                        GAME_STATE[inputNumbers[2]][inputNumbers[3]].equals(SOLVED_CARD)) {
                    System.out.println("Ein Feld ist bereits aufgedeckt." + repeatText);
                } else {
                    isValidInteger = true;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Es sind nur Zahlen erlaubt." + repeatText);
            }
        }
        return inputNumbers;
    }

    private static void checkGuess(int[] inputNumbers) {
        guessCounter++;
        String guessInfoText = " Anzahl Tipps bisher: " + guessCounter;
        GAME_STATE[inputNumbers[0]][inputNumbers[1]] = MEMORY[inputNumbers[0]][inputNumbers[1]];
        GAME_STATE[inputNumbers[2]][inputNumbers[3]] = MEMORY[inputNumbers[2]][inputNumbers[3]];
        printGameState();
        if (GAME_STATE[inputNumbers[0]][inputNumbers[1]].equals(GAME_STATE[inputNumbers[2]][inputNumbers[3]])) {
            System.out.println("Treffer!" + guessInfoText);
            GAME_STATE[inputNumbers[0]][inputNumbers[1]] = SOLVED_CARD;
            GAME_STATE[inputNumbers[2]][inputNumbers[3]] = SOLVED_CARD;
            printGameState();
        } else {
            System.out.println("Leider kein Treffer!" + guessInfoText);
            GAME_STATE[inputNumbers[0]][inputNumbers[1]] = FILL_CARD;
            GAME_STATE[inputNumbers[2]][inputNumbers[3]] = FILL_CARD;
            printGameState();
        }
    }

    private static boolean isSolved() {
        for (int i = 0; i < GAME_STATE.length; i++) {
            for (int j = 0; j < GAME_STATE.length; j++) {
                if (!GAME_STATE[i][j].equals(SOLVED_CARD)) {
                    return false;
                }
            }
        }
        System.out.println("Gratulation! Sie haben " + guessCounter + " Tipps benötigt!");
        printMemory();
        return true;
    }
}