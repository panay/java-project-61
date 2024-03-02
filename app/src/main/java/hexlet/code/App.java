package hexlet.code;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        if (chooseGame() == 1) {
            Cli.sayHello();
        }
    }

    private static int chooseGame() {
        Scanner sc = new Scanner(in);
        out.println("Please enter the game number and press Enter.");
        out.println("1 – Greet");
        out.println("0 – Exit");
        int gameNum = sc.nextInt();
        out.println("Your choice: " + gameNum);

        if (gameNum == 0) {
            sc.close();
        }

        return gameNum;
    }
}
