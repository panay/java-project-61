package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class GCD {
    private static int firstOperand;
    private static int secondOperand;
    public static void play() {
        String title = "Find the greatest common divisor of given numbers.";
        try {
            Engine.play(title, GCD::checkAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateQuestion() {
        Random random = new Random();
        final int bound = 50;
        firstOperand = random.nextInt(bound);
        secondOperand = random.nextInt(bound);
        out.printf("Question: %s %s%n", firstOperand, secondOperand);
    }

    private static int calcGCD() {
        while (secondOperand != 0) {
            int temp = secondOperand;
            secondOperand = firstOperand % secondOperand;
            firstOperand = temp;
        }
        return firstOperand;
    }

    private static boolean checkAnswer() {
        generateQuestion();

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        int correctAnswer = calcGCD();
        return Engine.checkAnswer(answer, correctAnswer);
    }
}
