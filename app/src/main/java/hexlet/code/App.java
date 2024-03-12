package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class App {
    public static void main(String[] args) {
        chooseGame();
    }

    private static void chooseGame() {
        out.println("Please enter the game number and press Enter.");
        out.println("1 – Greet");
        out.println("2 – Even");
        out.println("3 – Calc");
        out.println("4 – GCD");
        out.println("5 – Progression");
        out.println("6 – Prime");
        out.println("0 – Exit");
        Scanner scanner = new Scanner(in);

        String chosenGame = scanner.next();
        out.println("Your choice: " + chosenGame);

        switch (chosenGame) {
            case "1":
                Cli.greetings();
                break;
            case "2":
                Even.play();
                break;
            case "3":
                Calc.play();
                break;
            case "4":
                GCD.play();
                break;
            case "5":
                Progression.play();
                break;
            case "6":
                Prime.play();
                break;
            default:
                out.println("Выбрана несуществующая игра."
                        + "Пожалуйста, выберите числа от 2 до 6."
                        + "Если хотите увидеть приветствие - выберите 1");
                scanner.close();
        }
    }
}
