package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    private static final String TITLE = "What number is missing in the progression?";
    private static final int INITIAL_PROGRESSION_LENGTH = 6;
    private static final int ADDITIONAL_PROGRESSION_LENGTH = 5;
    private static final int SIZE_OF_DIFFERENCE_BETWEEN_NUMBERS = 10;
    private static final int FROM = 0;

    public static void play() {
        Engine.play(TITLE, checkAnswer());
    }

    private static String[] generateProgression(int start, int difference, int length) {
        int[] progression = new int[length];
        progression[0] = start;

        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + difference;
        }

        return Arrays.toString(progression).split("[\\[\\]]")[1].split(", ");
    }

    private static String[][] checkAnswer() {
        final int rounds = Engine.getRounds();
        String[][] engineData = new String[rounds][rounds];

        for (int i = 0; i < rounds; i++) {
            int length = Utils.generateRandomInt(INITIAL_PROGRESSION_LENGTH,
                    (INITIAL_PROGRESSION_LENGTH) + ADDITIONAL_PROGRESSION_LENGTH);
            int start = Utils.generateRandomInt(FROM, SIZE_OF_DIFFERENCE_BETWEEN_NUMBERS);
            int difference = Utils.generateRandomInt(FROM, SIZE_OF_DIFFERENCE_BETWEEN_NUMBERS);
            int hiddenIndex = Utils.generateRandomInt(FROM, length);

            String[] progression = generateProgression(start, difference, length);
            String hiddenNum = progression[hiddenIndex];
            progression[hiddenIndex] = "..";
            String question = String.format("Question: %s%n", String.join(" ", progression));

            engineData[i][0] = question;
            engineData[i][1] = hiddenNum;
        }

        return engineData;
    }
}
