package hexlet.code;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Engine {
    private static final int ROUNDS = 3;

    public static int getRounds() {
        return ROUNDS;
    }

    public static void play(String title, String[][] gameData) {
        Scanner scanner = new Scanner(in);
        out.println("Welcome to the Brain Games!");
        out.println("May I have your name?");
        String name = scanner.next();
        out.printf("Hello, %s!%n", name);
        out.println(title);

        for (int i = 0; i < ROUNDS; i++) {
            out.println(gameData[i][0]);
            String userAnswer = scanner.next();
            String correctAnswer = gameData[i][1];
            try {
                boolean isTrue = correctAnswer.equals(userAnswer);
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
