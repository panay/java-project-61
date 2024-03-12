package hexlet.code;

import java.util.Random;

public class Utils {
    public static int generateRandomInt(int from, int to) {
        Random random = new Random();
        return random.nextInt(from, to);
    }
}
