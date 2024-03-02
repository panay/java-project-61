package hexlet.code.games;

import  hexlet.code.Cli;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Even {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void play() {
        String title = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String correctResult = "Correct!";
        String congratsResult = String.format("Congratulations, %s!", Cli.getUsername());
        String wrongResult = " is wrong answer ;(. Correct answer was ";
        Scanner scanner = Cli.getScanner();

        out.println(title);

        int correctAnswerCount = 0;
        final int randomNumbers = 3;
        int[] digits = generateRandomNumbers(randomNumbers);
        for (int digit : digits) {
            correctAnswerCount++;
            boolean isEven = digit % 2 == 0;
            out.println("Question: " + digit);
            String answer = scanner.next();
            if (isEven && !answer.equals(YES)) {
                out.printf("'%s' %s '%s'%n", answer, wrongResult, YES);
                return;
            } else if (!isEven && !answer.equals(NO)) {
                out.printf("'%s' %s '%s'%n", answer, wrongResult, NO);
                return;
            }

            out.println(correctResult);
        }

        if (correctAnswerCount == digits.length) {
            out.println(congratsResult);
        }

        scanner.close();
    }

    private static int[] generateRandomNumbers(int size) {
        Random random = new Random();
        int[] digits = new int[size];

        for (int i = 0; i < size; i++) {
            digits[i] = random.nextInt(100);
        }

        return digits;
    }
}
