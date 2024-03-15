package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Prime {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String TITLE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void play() {
        try {
            Engine.play(TITLE, Prime::checkAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkAnswer() {
        final int from = 0;
        final int to = 100;
        int number = Utils.generateRandomInt(from, to);
        out.printf("Question: %s%n", number);

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        String correctAnswer = isPrime(number) ? YES : NO;
        return Engine.checkAnswer(answer, correctAnswer);
    }
}
