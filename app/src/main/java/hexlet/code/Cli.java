package hexlet.code;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Cli {
    public static void greetings() {
        Scanner scanner = new Scanner(in);
        out.println("Welcome to the Brain Games!");
        out.println("May I have your name?");
        String name = scanner.next();
        out.printf("Hello, %s!%n", name);
    }
}
