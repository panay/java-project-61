package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class Calc {
    private static int firstOperand;
    private static int secondOperand;
    private static char operation;
    private static final char[] OPERATIONS = {'+', '-', '*'};

    public static void play() {
        String title = "What is the result of the expression?";
        try {
            Engine.play(title, Calc::checkAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    private static boolean checkAnswer() throws Exception {
        generateQuestion();

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        int correctAnswer;
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
                throw new Exception("no such operator");
        }

        return Engine.checkAnswer(answer, correctAnswer);
    }
}
