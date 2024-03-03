package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Calc {
    private static int firstOperand;
    private static int secondOperand;
    private static char operation;
    private static final char[] OPERATIONS = {'+', '-', '*'};

    public static void play() {
        String title = "What is the result of the expression?";
        Engine.play(title, Calc::checkAnswer);
    }

    private static void generateQuestion() {
        Random random = new Random();

        int operationIndex = random.nextInt(OPERATIONS.length);
        final int bound = 25;
        firstOperand = random.nextInt(bound);
        secondOperand = random.nextInt(bound);
        operation = OPERATIONS[operationIndex];
        out.printf("Question: %s %s %s%n", firstOperand, operation, secondOperand);
    }

    private static boolean checkAnswer(Scanner scanner) {
        generateQuestion();

        String answer = scanner.next();
        int correctAnswer = 0;
        boolean isTrue = false;
        switch (operation) {
            case '+':
                correctAnswer = firstOperand + secondOperand;
                break;
            case '-':
                correctAnswer = firstOperand - secondOperand;
                break;
            case '*':
                correctAnswer = firstOperand * secondOperand;
                break;
            default:
        }

        try {
            final int radix = 10;
            isTrue = Integer.parseInt(answer, radix) == correctAnswer;

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
