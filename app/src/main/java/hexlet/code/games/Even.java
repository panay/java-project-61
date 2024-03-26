package hexlet.code.games;

import  hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String TITLE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play() {
        Engine.play(TITLE, checkAnswer());
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String[][] checkAnswer() {
        final int from = 0;
        final int to = 100;
        final int rounds = Engine.getRounds();
        String[][] engineData = new String[rounds][rounds];

        for (int i = 0; i < rounds; i++) {
            final int number = Utils.generateRandomInt(from, to);
            String question = String.format("Question: %s%n", number);
            String correctAnswer = isEven(number) ? YES : NO;

            engineData[i][0] = question;
            engineData[i][1] = correctAnswer;
        }

        return engineData;
    }
}
