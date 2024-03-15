package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class Calc {
    private static int firstOperand;
    private static int secondOperand;
    private static char operation;
    private static final char[] OPERATIONS = {'+', '-', '*'};
    private static final String TITLE = "What is the result of the expression?";

    public static void play() {
        try {
            Engine.play(TITLE, Calc::checkAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getCorrectAnswer() throws Exception {
        return switch (operation) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            default -> throw new Exception("no such operator");
        };
    }

    private static boolean checkAnswer() throws Exception {
        final int from = 0;
        final int to = 25;
        int operationIndex = Utils.generateRandomInt(from, OPERATIONS.length);
        firstOperand = Utils.generateRandomInt(from, to);
        secondOperand = Utils.generateRandomInt(from, to);
        operation = OPERATIONS[operationIndex];
        out.printf("Question: %s %s %s%n", firstOperand, operation, secondOperand);

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        int correctAnswer = getCorrectAnswer();

        return Engine.checkAnswer(answer, correctAnswer);
    }
}
