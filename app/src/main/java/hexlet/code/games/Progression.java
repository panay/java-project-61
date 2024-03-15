package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class Progression {
    private static final String TITLE = "What number is missing in the progression?";
    private static int[] progression;
    private static int hiddenNum;

    public static void play() {
        try {
            Engine.play(TITLE, Progression::checkAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateArithmeticProgression(int start, int difference, int length) {
        progression = new int[length];
        progression[0] = start;

        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + difference;
        }
    }

    private static String hideNumber(int hiddenIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                hiddenNum = progression[i];
                sb.append(".. ");
            } else {
                sb.append(progression[i]).append(" ");
            }
        }
        return sb.toString();
    }

    private static boolean checkAnswer() {
        final int initialProgressionLength = 6;
        final int additionalProgressionLength = 5;
        final int sizeOfDifferenceBetweenNumbers = 10;
        final int from = 0;

        int length = Utils.generateRandomInt(initialProgressionLength,
                (initialProgressionLength) + additionalProgressionLength);
        int start = Utils.generateRandomInt(from, sizeOfDifferenceBetweenNumbers);
        int difference = Utils.generateRandomInt(from, sizeOfDifferenceBetweenNumbers);
        int hiddenIndex = Utils.generateRandomInt(from, length);

        generateArithmeticProgression(start, difference, length);
        out.printf("Question: %s%n", hideNumber(hiddenIndex));

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        int correctAnswer = hiddenNum;
        return Engine.checkAnswer(answer, correctAnswer);
    }
}
