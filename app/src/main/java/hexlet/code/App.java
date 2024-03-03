package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        Scanner scanner = Engine.getScanner();
        int chosenGame = chooseGame(scanner);

        switch (chosenGame) {
            case 1:
                Engine.sayHello();
                break;
            case 2:
                Even.play();
                break;
            case 3:
                Calc.play();
                break;
            case 4:
                GCD.play();
                break;
            case 5:
                Progression.play();
                break;
            case 6:
                Prime.play();
                break;
            default:
                scanner.close();
        }
    }

    private static int chooseGame(Scanner scanner) {
        out.println("Please enter the game number and press Enter.");
        out.println("1 – Greet");
        out.println("2 – Even");
        out.println("3 – Calc");
        out.println("4 – GCD");
        out.println("5 – Progression");
        out.println("6 – Prime");
        out.println("0 – Exit");
        int gameNum = 0;
        try {
            gameNum = scanner.nextInt();
            out.println("Your choice: " + gameNum);
        } catch (Exception e) {
            scanner.close();
        }

        return gameNum;
    }
}
