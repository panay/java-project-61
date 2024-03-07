package hexlet.code;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;

import static java.lang.System.in;
import static java.lang.System.out;

public class Engine {
    private static String username;
    private static final int ROUNDS = 3;
    private static final String CORRECT = "Correct!";
    private static final String WRONG = "is wrong answer ;(. Correct answer was";

    public static void printCorrect() {
        out.println(CORRECT);
    }
    public static void printWrong(String answer, String correctAnswer) {
        out.printf("'%s' %s '%s'%n", answer, Engine.WRONG, correctAnswer);
        out.printf("Let's try again, %s!%n", username);
    }
    public static void printCongrats() {
        out.printf("Congratulations, %s!%n", username);
    }

    public static void sayHello() {
        Scanner scanner = new Scanner(in);
        out.println("Welcome to the Brain Games!");
        out.println("May I have your name?");
        String name = scanner.next();
        username = name;
        out.printf("Hello, %s!%n", name);
    }

    public static void play(String title, Callable<Boolean> checkAnswerFn) throws Exception {
        sayHello();
        out.println(title);

        for (int i = 0; i < ROUNDS; i++) {
            boolean isTrue = checkAnswerFn.call();
            if (!isTrue) {
                return;
            }
        }

        Engine.printCongrats();
    }

    public static int generateNumberQuestion(int randomSize) {
        Random random = new Random();
        int number = random.nextInt(randomSize);
        out.printf("Question: %s%n", number);
        return number;
    }

    public static boolean checkAnswer(String answer, int correctAnswer) {
        boolean isTrue = false;
        try {
            final int radix = 10;
            isTrue = Integer.parseInt(answer, radix) == correctAnswer;
            if (!isTrue) {
                printWrong(answer, String.valueOf(correctAnswer));
            } else {
                printCorrect();
            }

            return isTrue;
        } catch (Exception e) {
            printWrong(answer, String.valueOf(correctAnswer));
        }

        return isTrue;
    }

    public static boolean checkAnswer(String answer, String correctAnswer) {
        if (correctAnswer.equals(answer)) {
            printCorrect();
            return true;
        }
        printWrong(answer, correctAnswer);
        return false;
    }
}
