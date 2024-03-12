package hexlet.code.games;

import  hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Even {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void play() {
        String title = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        try {
            Engine.play(title, Even::checkAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkAnswer() {
        final int from = 0;
        final int to = 100;
        final int number = Utils.generateRandomInt(from, to);
        out.printf("Question: %s%n", number);

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        String correctAnswer = number % 2 == 0 ? YES : NO;
        return Engine.checkAnswer(answer, correctAnswer);
    }
}
