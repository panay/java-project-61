package hexlet.code.games;

import  hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Even {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static int digit;

    public static void play() {
        String title = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.play(title, Even::checkAnswer);
    }

    private static void generateQuestion() {
        Random random = new Random();
        int sizeOfGeneratedNumber = 100;
        digit = random.nextInt(sizeOfGeneratedNumber);
        out.printf("Question: %s%n", digit);
    }

    private static boolean checkAnswer(Scanner scanner) {
        generateQuestion();

        String answer = scanner.next();
        String correctAnswer = digit % 2 == 0 ? YES : NO;
        boolean isTrue = correctAnswer.equals(answer);

        if (!isTrue) {
            Engine.printWrong(answer, correctAnswer);
        } else {
            Engine.printCorrect();
        }

        return isTrue;
    }
}
