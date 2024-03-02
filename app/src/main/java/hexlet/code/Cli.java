package hexlet.code;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Cli {
    public static void sayHello() {
        Scanner sc = new Scanner(in);

        out.println("Welcome to the Brain Games!");
        out.println("May I have your name?");
        String username = sc.next();
        out.println("Hello, " + username + "!");
        sc.close();
    }
}
