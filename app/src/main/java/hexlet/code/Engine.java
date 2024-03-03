package hexlet.code;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.in;
import static java.lang.System.out;

public class Engine {
    private static String username;
    private static final Scanner SYSTEM_SCANNER = new Scanner(in);
    private static final int ROUNDS = 3;
    private static final String CORRECT = "Correct!";
    private static final String WRONG = "is wrong answer ;(. Correct answer was";

    public static Scanner getScanner() {
        return SYSTEM_SCANNER;
    }
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
        out.println("Welcome to the Brain Games!");
        out.println("May I have your name?");
        String name = SYSTEM_SCANNER.next();
        username = name;
        out.printf("Hello, %s!%n", name);
    }

    public static void play(String title, Function<Scanner, Boolean> checkAnswerFn) {
        sayHello();
        out.println(title);

        for (int i = 0; i < ROUNDS; i++) {
            boolean isTrue = checkAnswerFn.apply(SYSTEM_SCANNER);
            if (!isTrue) {
                return;
            }
        }

        Engine.printCongrats();

        SYSTEM_SCANNER.close();
    }

    public static int generateNumberQuestion() {
        Random random = new Random();
        int number = random.nextInt(100);
        out.printf("Question: %s%n", number);
        return number;
    }
}
