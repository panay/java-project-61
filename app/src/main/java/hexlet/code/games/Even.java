package hexlet.code.games;

import  hexlet.code.Engine;
import java.util.Scanner;

import static java.lang.System.in;

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
        final int bound = 100;
        final int number = Engine.generateNumberQuestion(bound);

        Scanner scanner = new Scanner(in);
        String answer = scanner.next();
        String correctAnswer = number % 2 == 0 ? YES : NO;
        return Engine.checkAnswer(answer, correctAnswer);
    }
}
