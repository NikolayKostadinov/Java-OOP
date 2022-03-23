package input;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    private static final Scanner scan = new Scanner(System.in);

    public static int[] readIntArray(String delimiter) {
        return parseIntArray(scan.nextLine(), delimiter);
    }

    public static String[] readStringArray(String delimiter) {
        return scan.nextLine().split(delimiter);
    }

    public static String readLine() {
        return scan.nextLine();
    }


    public static int[] parseIntArray(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
