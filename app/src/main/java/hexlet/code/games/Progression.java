package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Progression {
    private static int[] progression;
    private static int hiddenNum;

    public static void play() {
        String title = "Find the greatest common divisor of given numbers.";
        Engine.play(title, Progression::checkAnswer);
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
        int initialProgressionLength = 6;
        int additionalProgressionLength = 5;
        int sizeOfDifferenceBetweenNumbers = 10;

        int length = random.nextInt(initialProgressionLength) + additionalProgressionLength;
        int start = random.nextInt(sizeOfDifferenceBetweenNumbers);
        int difference = random.nextInt(sizeOfDifferenceBetweenNumbers);
        int hiddenIndex = random.nextInt(length);

        generateArithmeticProgression(start, difference, length);
        hiddenNum = progression[hiddenIndex];
        out.printf("Question: %s%n", hideNumber(hiddenIndex));
    }

    private static boolean checkAnswer(Scanner scanner) {
        generateQuestion();

        String answer = scanner.next();
        int correctAnswer = hiddenNum;
        boolean isTrue = false;
        try {
            isTrue = Integer.parseInt(answer, 10) == correctAnswer;

            if (!isTrue) {
                Engine.printWrong(answer, String.valueOf(correctAnswer));
            } else {
                Engine.printCorrect();
            }

            return isTrue;
        } catch (Exception e) {
            Engine.printWrong(answer, String.valueOf(correctAnswer));
        }

        return isTrue;
    }
}
