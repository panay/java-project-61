package hexlet.code;

import hexlet.code.games.Even;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        int chosenGame = chooseGame();

        if (chosenGame == 0) {
            return;
        }

        Cli.sayHello();
        if (chosenGame == 2) {
            Even.play();
        }
    }

    private static int chooseGame() {
        Scanner scanner = Cli.getScanner();
        out.println("Please enter the game number and press Enter.");
        out.println("1 – Greet");
        out.println("2 – Even");
        out.println("0 – Exit");
        int gameNum = scanner.nextInt();
        out.println("Your choice: " + gameNum);

        if (gameNum == 0) {
            scanner.close();
        }

        return gameNum;
    }
}
