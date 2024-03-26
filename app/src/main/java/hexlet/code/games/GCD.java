package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final String TITLE = "Find the greatest common divisor of given numbers.";

    public static void play() {
        Engine.play(TITLE, checkAnswer());
    }

    private static int getCorrectAnswer(int firstOperand, int secondOperand) {
        while (secondOperand != 0) {
            int temp = secondOperand;
            secondOperand = firstOperand % secondOperand;
            firstOperand = temp;
        }
        return firstOperand;
    }

    private static String[][] checkAnswer() {
        final int from = 0;
        final int to = 50;
        final int rounds = Engine.getRounds();
        String[][] engineData = new String[rounds][rounds];

        for (int i = 0; i < rounds; i++) {
            int firstOperand = Utils.generateRandomInt(from, to);
            int secondOperand = Utils.generateRandomInt(from, to);
            String question = String.format("Question: %s %s%n", firstOperand, secondOperand);
            String correctAnswer = String.valueOf(getCorrectAnswer(firstOperand, secondOperand));

            engineData[i][0] = question;
            engineData[i][1] = correctAnswer;
        }

        return engineData;
    }
}
