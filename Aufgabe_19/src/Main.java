import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static int firstElement;
    private static int secondElement;
    private static char operator = '_';

    public static void main(String[] args) {

        while (true) {
            System.out.println("Make your calculation (or press Q to quit)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            try {
                setUpPartsOfCalculation(input);
                float result = calculate(firstElement, secondElement, operator);
                System.out.println(result);
            } catch (Exception exception) {
                System.out.println("Error: Unerlaubte Operation");
            }
        }
    }

    private static void setUpPartsOfCalculation(String input) {
        char[] chars = input.toCharArray();
        char[] allowedOperatorArray = {'+', '-', '*', '/', '%'};
        List<Character> allowedOperators = new ArrayList<>();
        for (char element : allowedOperatorArray) {
            allowedOperators.add(element);
        }
        StringBuilder firstPartStringBuilder = new StringBuilder();
        StringBuilder secondPartStringBuilder = new StringBuilder();
        boolean isFirstPart = true;
        for (char element : chars) {
            if (allowedOperators.contains(element)) {
                operator = element;
                isFirstPart = false;
            } else if (isFirstPart) {
                firstPartStringBuilder.append(element);
            } else {
                secondPartStringBuilder.append(element);
            }
        }
        firstElement = Integer.parseInt(firstPartStringBuilder.toString().trim());
        secondElement = Integer.parseInt(secondPartStringBuilder.toString().trim());
    }

    private static float calculate(int firstElement, int secondElement, char operator) throws Exception {
        return switch (operator) {
            case '+' -> firstElement + secondElement;
            case '-' -> firstElement - secondElement;
            case '*' -> firstElement * secondElement;
            case '/' -> (float) firstElement / secondElement;
            case '%' -> firstElement % secondElement;
            default -> throw new Exception("Nicht erlaubter Operator");
        };
    }
}