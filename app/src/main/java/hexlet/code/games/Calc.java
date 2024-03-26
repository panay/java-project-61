package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static java.lang.System.out;

public class Calc {
    private static final char[] OPERATIONS = {'+', '-', '*'};
    private static final String TITLE = "What is the result of the expression?";

    public static void play() {
        Engine.play(TITLE, checkAnswer());
    }

    private static int calc(int firstOperand, int secondOperand, char operator) throws Exception {
        return switch (operator) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            default -> throw new Exception("no such operator");
        };
    }

    private static String[][] checkAnswer() {
        final int from = 0;
        final int to = 25;
        final int rounds = Engine.getRounds();
        String[][] engineData = new String[rounds][rounds];

        for (int i = 0; i < rounds; i++) {
            int operationIndex = Utils.generateRandomInt(from, OPERATIONS.length);
            int firstOperand = Utils.generateRandomInt(from, to);
            int secondOperand = Utils.generateRandomInt(from, to);
            char operation = OPERATIONS[operationIndex];

            String question = String.format("Question: %s %s %s%n", firstOperand, operation, secondOperand);
            String correctAnswer = "NaN";
            try {
                correctAnswer = String.valueOf(calc(firstOperand, secondOperand, operation));
            } catch (Exception e) {
                out.println(e.getMessage());
            }

            engineData[i][0] = question;
            engineData[i][1] = correctAnswer;
        }

        return engineData;
    }
}
