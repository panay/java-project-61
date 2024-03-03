package hexlet.code.games;

import  hexlet.code.Engine;
import java.util.Scanner;

public class Even {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static int number;

    public static void play() {
        String title = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.play(title, Even::checkAnswer);
    }

    private static boolean checkAnswer(Scanner scanner) {
        final int bound = 100;
        number = Engine.generateNumberQuestion(bound);

        String answer = scanner.next();
        String correctAnswer = number % 2 == 0 ? YES : NO;
        boolean isTrue = correctAnswer.equals(answer);

        if (!isTrue) {
            Engine.printWrong(answer, correctAnswer);
        } else {
            Engine.printCorrect();
        }

        return isTrue;
    }
}
