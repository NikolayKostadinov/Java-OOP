import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P01RhombusOfStars {
    public static void main(String[] args) {
        int n = readInput();
        String rhombus = createRhombus(n);
        print(rhombus);
    }

    private static void print(String rhombus) {
        System.out.println(rhombus);
    }

    private static String createRhombus(int rhombusSize) {
        StringBuilder sb = new StringBuilder();

        Predicate<Integer> predicate = i -> i <= rhombusSize;

        sb.append(createTriangle(1, rhombusSize, 1, rhombusSize));
        sb.append(createTriangle(rhombusSize - 1, 1, -1, rhombusSize));

        return sb.toString();
    }

    private static String createTriangle(int start, int end, int step, int size) {
        Predicate<Integer> condition = i -> (step > 0) ? i <= end : i >= end;
        StringBuilder sb = new StringBuilder();
        for (int i = start; condition.test(i); i += step) {
            String row = createRow(size - i, i, '*');
            sb.append(row).append(System.lineSeparator());
        }

        return sb.toString();
    }

    private static String createRow(int spaces, int symbols, char symbol) {
        StringBuilder sb = new StringBuilder(spaces + symbols);
        IntStream.range(0, spaces)
                .forEach(x -> sb.append(" "));

        IntStream.range(0, symbols)
                .forEach(x -> sb.append(symbol).append(" "));

        return sb.toString();
    }

    private static int readInput() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
