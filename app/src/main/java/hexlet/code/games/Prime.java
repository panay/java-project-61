package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Prime {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static int number;

    public static void play() {
        String title = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.play(title, Prime::checkAnswer);
    }

    private static boolean isPrime() {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void generateQuestion() {
        Random random = new Random();
        number = random.nextInt(100);
        out.printf("Question: %s%n", number);
    }

    private static boolean checkAnswer(Scanner scanner) {
        generateQuestion();

        String answer = scanner.next();
        String correctAnswer = isPrime() ? YES : NO;
        boolean isTrue = correctAnswer.equals(answer);

        if (!isTrue) {
            Engine.printWrong(answer, correctAnswer);
        } else {
            Engine.printCorrect();
        }

        return isTrue;
    }
}
