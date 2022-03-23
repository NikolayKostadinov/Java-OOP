package P01MathOperation;

public class MathOperation {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return add(add(a,b), c);
    }

    public static int add(int a, int b, int c, int d) {
        return add(add(a,b), add(c,d));
    }
}
