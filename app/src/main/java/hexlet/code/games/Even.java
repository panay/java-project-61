package hexlet.code.games;

import  hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Even {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String TITLE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play() {
        Engine.play(TITLE, Even::checkAnswer);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean checkAnswer() {
        final int from = 0;
        final int to = 100;
        final int number = Utils.generateRandomInt(from, to);
        out.printf("Question: %s%n", number);

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        String correctAnswer = isEven(number) ? YES : NO;

        Engine.setUserAnswer(answer);
        Engine.setCorrectAnswer(correctAnswer);

        return correctAnswer.equals(answer);
    }
}
