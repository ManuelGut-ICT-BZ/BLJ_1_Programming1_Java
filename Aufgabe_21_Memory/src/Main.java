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
        //Todo: Remove
        printMemory();

        while (!isSolved()) {
            String guessedFields = readUserInput(scanner);
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

    private static String readUserInput(Scanner scanner) {
        String repeatText = " Wiederhole die Eingabe.";
        String input = "1111";
        boolean isValidInteger = false;
        while (!isValidInteger) {
            try {
                input = scanner.nextLine();
                int inputNumber = Integer.parseInt(input);
                char[] inputs = input.toCharArray();
                if(inputNumber > 4444){
                    System.out.println("Erlaubte Zahlen 1111 - 4444." + repeatText);
                }else if(inputs[0] == inputs[2] && inputs[1]==inputs[3]){
                    System.out.println("Du hast zweimal dasselbe Feld gewählt." + repeatText);
                }else {
                    isValidInteger = true;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Es sind nur Zahlen erlaubt." + repeatText);
            }
        }
        return input;
    }

    private static void checkGuess(String userInput) {
        guessCounter++;
        char[] inputs = userInput.toCharArray();
        int indexRowCard1 = Character.getNumericValue(inputs[0]) - 1;
        int indexColumnCard1 = Character.getNumericValue(inputs[1] - 1);
        int indexRowCard2 = Character.getNumericValue(inputs[2] - 1);
        int indexColumnCard2 = Character.getNumericValue(inputs[3] - 1);
        GAME_STATE[indexRowCard1][indexColumnCard1] = MEMORY[indexRowCard1][indexColumnCard1];
        GAME_STATE[indexRowCard2][indexColumnCard2] = MEMORY[indexRowCard2][indexColumnCard2];
        printGameState();
        if (GAME_STATE[indexRowCard1][indexColumnCard1].equals(GAME_STATE[indexRowCard2][indexColumnCard2])) {
            System.out.println("Treffer!");
            GAME_STATE[indexRowCard1][indexColumnCard1] = SOLVED_CARD;
            GAME_STATE[indexRowCard2][indexColumnCard2] = SOLVED_CARD;
            printGameState();
        } else {
            System.out.println("Leider kein Treffer!");
            GAME_STATE[indexRowCard1][indexColumnCard1] = FILL_CARD;
            GAME_STATE[indexRowCard2][indexColumnCard2] = FILL_CARD;
            printGameState();
        }
    }

    private static boolean isSolved(){
        for (int i = 0; i < GAME_STATE.length; i++) {
            for (int j = 0; j < GAME_STATE.length; j++) {
                if (!GAME_STATE[i][j].equals(SOLVED_CARD)){
                        return false;
                }
            }
        }
        System.out.println("Gratulation! Sie haben " + guessCounter + " Tipps benötigt!");
        return true;
    }
}