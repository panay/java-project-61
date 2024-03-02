package hexlet.code;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Cli {
    private static final Scanner SCANNER = new Scanner(in);
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static Scanner getScanner() {
        return SCANNER;
    }
    public static void sayHello() {
        out.println("Welcome to the Brain Games!");
        out.println("May I have your name?");
        String name = SCANNER.next();
        username = name;
        out.printf("Hello, %s!", name);
    }
}
