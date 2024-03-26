package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String TITLE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void play() {
        Engine.play(TITLE, checkAnswer());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static String[][] checkAnswer() {
        final int from = 0;
        final int to = 100;
        final int rounds = Engine.getRounds();
        String[][] engineData = new String[rounds][rounds];

        for (int i = 0; i < rounds; i++) {
            int number = Utils.generateRandomInt(from, to);
            String question = String.format("Question: %s%n", number);
            String correctAnswer = isPrime(number) ? YES : NO;

            engineData[i][0] = question;
            engineData[i][1] = correctAnswer;
        }

        return engineData;
    }
}
