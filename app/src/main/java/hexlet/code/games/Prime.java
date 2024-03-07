package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

import static java.lang.System.in;

public class Prime {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static int number;

    public static void play() {
        String title = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        try {
            Engine.play(title, Prime::checkAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    private static boolean checkAnswer() {
        final int bound = 100;
        number = Engine.generateNumberQuestion(bound);

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        String correctAnswer = isPrime() ? YES : NO;
        return Engine.checkAnswer(answer, correctAnswer);
    }
}
