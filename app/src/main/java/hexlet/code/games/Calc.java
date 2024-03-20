package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class Calc {
    private static final char[] OPERATIONS = {'+', '-', '*'};
    private static final String TITLE = "What is the result of the expression?";

    public static void play() {
        Engine.play(TITLE, Calc::checkAnswer);
    }

    private static int calc(int firstOperand, int secondOperand, char operator) throws Exception {
        return switch (operator) {
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
        int firstOperand = Utils.generateRandomInt(from, to);
        int secondOperand = Utils.generateRandomInt(from, to);
        char operation = OPERATIONS[operationIndex];
        out.printf("Question: %s %s %s%n", firstOperand, operation, secondOperand);

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        int correctAnswer = calc(firstOperand, secondOperand, operation);

        Engine.setUserAnswer(answer);
        Engine.setCorrectAnswer(String.valueOf(correctAnswer));

        return Integer.parseInt(answer) == correctAnswer;
    }
}
