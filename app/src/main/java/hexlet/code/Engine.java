package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.Callable;

import static java.lang.System.in;
import static java.lang.System.out;

public class Engine {
    private static final int ROUNDS = 3;
    private static String userAnswer;
    private static String correctAnswer;

    public static void setUserAnswer(String userAnswer) {
        Engine.userAnswer = userAnswer;
    }

    public static void setCorrectAnswer(String correctAnswer) {
        Engine.correctAnswer = correctAnswer;
    }

    public static void play(String title, Callable<Boolean> checkAnswerFn) {
        Scanner scanner = new Scanner(in);
        out.println("Welcome to the Brain Games!");
        out.println("May I have your name?");
        String name = scanner.next();
        out.printf("Hello, %s!%n", name);
        out.println(title);

        for (int i = 0; i < ROUNDS; i++) {
            try {
                boolean isTrue = checkAnswerFn.call();
                if (!isTrue) {
                    out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", userAnswer, correctAnswer);
                    out.printf("Let's try again, %s!%n", name);
                    return;
                }
                out.println("Correct!");
            } catch (Exception e) {
                out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", userAnswer, correctAnswer);
                out.printf("Let's try again, %s!%n", name);
                return;
            }
        }

        out.printf("Congratulations, %s!%n", name);
    }
}
