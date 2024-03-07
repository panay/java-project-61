package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class Progression {
    private static int[] progression;
    private static int hiddenNum;

    public static void play() {
        String title = "What number is missing in the progression?";
        try {
            Engine.play(title, Progression::checkAnswer);
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

    private static void generateQuestion() {
        Random random = new Random();
        final int initialProgressionLength = 6;
        final int additionalProgressionLength = 5;
        final int sizeOfDifferenceBetweenNumbers = 10;

        int length = random.nextInt(initialProgressionLength) + additionalProgressionLength;
        int start = random.nextInt(sizeOfDifferenceBetweenNumbers);
        int difference = random.nextInt(sizeOfDifferenceBetweenNumbers);
        int hiddenIndex = random.nextInt(length);

        generateArithmeticProgression(start, difference, length);
        hiddenNum = progression[hiddenIndex];
        out.printf("Question: %s%n", hideNumber(hiddenIndex));
    }

    private static boolean checkAnswer() {
        generateQuestion();
        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        int correctAnswer = hiddenNum;
        return Engine.checkAnswer(answer, correctAnswer);
    }
}
