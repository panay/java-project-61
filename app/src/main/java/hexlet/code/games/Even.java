package hexlet.code.games;

import  hexlet.code.Engine;
import java.util.Scanner;

public class Even {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void play() {
        String title = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.play(title, Even::checkAnswer);
    }

    private static boolean checkAnswer(Scanner scanner) {
        final int bound = 100;
        final int number = Engine.generateNumberQuestion(bound);

        String answer = scanner.next();
        String correctAnswer = number % 2 == 0 ? YES : NO;
        return Engine.checkAnswer(answer, correctAnswer);
    }
}
