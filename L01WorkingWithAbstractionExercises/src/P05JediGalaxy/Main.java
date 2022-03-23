package P05JediGalaxy;

import input.Reader;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Reader.readIntArray(" ");
        GameEngine ge = new GameEngine(dimensions[0], dimensions[1]);
        ge.start();
    }
}
