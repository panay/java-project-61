package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

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

    private static boolean checkAnswer(Scanner scanner) {
        number = Engine.generateNumberQuestion(100);

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
