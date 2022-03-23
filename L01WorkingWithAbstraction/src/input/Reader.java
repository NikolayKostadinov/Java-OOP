package input;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    private static final Scanner scan = new Scanner(System.in);

    public static int[] readIntArray(String delimiter) {
        return Arrays.stream(scan.nextLine()
                        .split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static String[] readStringArray(String delimiter) {
        return scan.nextLine().split(delimiter);
    }
}
