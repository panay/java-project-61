package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class GCD {
    private static final String TITLE = "Find the greatest common divisor of given numbers.";

    public static void play() {
        try {
            Engine.play(TITLE, GCD::checkAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getCorrectAnswer(int firstOperand, int secondOperand) {
        while (secondOperand != 0) {
            int temp = secondOperand;
            secondOperand = firstOperand % secondOperand;
            firstOperand = temp;
        }
        return firstOperand;
    }

    private static boolean checkAnswer() {
        final int from = 0;
        final int to = 50;
        int firstOperand = Utils.generateRandomInt(from, to);
        int secondOperand = Utils.generateRandomInt(from, to);
        out.printf("Question: %s %s%n", firstOperand, secondOperand);

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        int correctAnswer = getCorrectAnswer(firstOperand, secondOperand);
        return Engine.checkAnswer(answer, correctAnswer);
    }
}
