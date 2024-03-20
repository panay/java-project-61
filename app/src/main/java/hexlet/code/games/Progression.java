package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class Progression {
    private static final String TITLE = "What number is missing in the progression?";
    private static final int INITIAL_PROGRESSION_LENGTH = 6;
    private static final int ADDITIONAL_PROGRESSION_LENGTH = 5;
    private static final int SIZE_OF_DIFFERENCE_BETWEEN_NUMBERS = 10;
    private static final int FROM = 0;

    public static void play() {
        Engine.play(TITLE, Progression::checkAnswer);
    }

    private static int[] generateProgression(int start, int difference, int length) {
        int[] progression = new int[length];
        progression[0] = start;

        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + difference;
        }

        return progression;
    }

    private static String hideNumber(int[] progression, int hiddenIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                sb.append(".. ");
            } else {
                sb.append(progression[i]).append(" ");
            }
        }
        return sb.toString();
    }

    private static boolean checkAnswer() {
        int length = Utils.generateRandomInt(INITIAL_PROGRESSION_LENGTH,
                (INITIAL_PROGRESSION_LENGTH) + ADDITIONAL_PROGRESSION_LENGTH);
        int start = Utils.generateRandomInt(FROM, SIZE_OF_DIFFERENCE_BETWEEN_NUMBERS);
        int difference = Utils.generateRandomInt(FROM, SIZE_OF_DIFFERENCE_BETWEEN_NUMBERS);
        int hiddenIndex = Utils.generateRandomInt(FROM, length);

        int[] progression = generateProgression(start, difference, length);
        int hiddenNum = progression[hiddenIndex];
        out.printf("Question: %s%n", hideNumber(progression, hiddenIndex));

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();

        Engine.setUserAnswer(answer);
        Engine.setCorrectAnswer(String.valueOf(hiddenNum));

        return Integer.parseInt(answer) == hiddenNum;
    }
}
