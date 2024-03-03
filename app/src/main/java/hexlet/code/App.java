package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        int chosenGame = chooseGame();

        if (chosenGame == 0) {
            return;
        }

        switch (chosenGame) {
            case 2:
                Even.play();
                break;
            case 3:
                Calc.play();
                break;
            case 4:
                GCD.play();
                break;
            default:
                Engine.sayHello();
        }
    }

    private static int chooseGame() {
        Scanner scanner = Engine.getScanner();
        out.println("Please enter the game number and press Enter.");
        out.println("1 – Greet");
        out.println("2 – Even");
        out.println("3 – Calc");
        out.println("4 – GCD");
        out.println("0 – Exit");
        int gameNum = scanner.nextInt();
        out.println("Your choice: " + gameNum);

        if (gameNum == 0) {
            scanner.close();
        }

        return gameNum;
    }
}
