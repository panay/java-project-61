package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.Callable;

import static java.lang.System.in;
import static java.lang.System.out;

public class Engine {
    private static String username;
    private static final int ROUNDS = 3;
    private static final String WRONG = "is wrong answer ;(. Correct answer was";
    private static String userAnswer;
    private static String gameAnswer;

    private static void printMessage(String typeMessage) {
        switch (typeMessage) {
            case "correct":
                out.println("Correct!");
                break;
            case "congrats":
                out.printf("Congratulations, %s!%n", username);
                break;
            case "greetings":
                Scanner scanner = new Scanner(in);
                out.println("Welcome to the Brain Games!");
                out.println("May I have your name?");
                String name = scanner.next();
                username = name;
                out.printf("Hello, %s!%n", name);
                break;
            case "wrong":
                out.printf("'%s' %s '%s'%n", userAnswer, WRONG, gameAnswer);
                out.printf("Let's try again, %s!%n", username);
                break;
            default:
                out.println("Bye!");
        }
    }

    public static void play(String title, Callable<Boolean> checkAnswerFn) throws Exception {
        printMessage("greetings");
        out.println(title);

        for (int i = 0; i < ROUNDS; i++) {
            boolean isTrue = checkAnswerFn.call();
            if (!isTrue) {
                return;
            }
        }

        printMessage("congrats");
    }

    public static boolean checkAnswer(String answer, int correctAnswer) {
        userAnswer = answer;
        gameAnswer = String.valueOf(correctAnswer);
        boolean isTrue = false;

        try {
            final int radix = 10;
            isTrue = Integer.parseInt(answer, radix) == correctAnswer;
            if (!isTrue) {
                printMessage("wrong");
            } else {
                printMessage("correct");
            }

            return isTrue;
        } catch (Exception e) {
            printMessage("wrong");
        }

        return isTrue;
    }

    public static boolean checkAnswer(String answer, String correctAnswer) {
        userAnswer = answer;
        gameAnswer = correctAnswer;

        if (correctAnswer.equals(answer)) {
            printMessage("correct");
            return true;
        }

        printMessage("wrong");
        return false;
    }
}
