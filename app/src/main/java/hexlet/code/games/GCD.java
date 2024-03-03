package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class GCD {
    private static int firstOperand;
    private static int secondOperand;
    public static void play() {
        String title = "Find the greatest common divisor of given numbers.";
        Engine.play(title, GCD::checkAnswer);
    }

    private static void generateQuestion() {
        Random random = new Random();

        int sizeOfGeneratedNumber = 50;
        firstOperand = random.nextInt(sizeOfGeneratedNumber);
        secondOperand = random.nextInt(sizeOfGeneratedNumber);
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

    private static boolean checkAnswer(Scanner scanner) {
        generateQuestion();

        String answer = scanner.next();
        int correctAnswer = calcGCD();
        boolean isTrue = false;
        try {
            isTrue = Integer.parseInt(answer, 10) == correctAnswer;

            if (!isTrue) {
                Engine.printWrong(answer, String.valueOf(correctAnswer));
            } else {
                Engine.printCorrect();
            }

            return isTrue;
        } catch (Exception e) {
            Engine.printWrong(answer, String.valueOf(correctAnswer));
        }

        return isTrue;
    }
}