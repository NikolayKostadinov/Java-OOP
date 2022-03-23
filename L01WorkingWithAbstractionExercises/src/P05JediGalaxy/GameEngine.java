package P05JediGalaxy;

import input.Reader;
import output.ConsolePrinter;

import java.util.Arrays;

public class GameEngine {
    private final PlayGround playGround;

    public GameEngine(int dimensionX, int dimensionY) {
        this.playGround = new PlayGround(dimensionX, dimensionY);
    }

    public void start() {
        String command = Reader.readLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoPosition = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilPosition = Reader.readIntArray(" ");
            Player evil = new Player(PlayerType.EVIL, new Point(evilPosition[0], evilPosition[1]));
            Player ivo = new Player(PlayerType.JEDI, new Point(ivoPosition[0], ivoPosition[1]));

            while (playGround.isOverTopLeft(evil.getPosition())) {
                if (playGround.isUnderBottomRight(evil.getPosition())) {
                    this.playGround.setValue(evil.getPosition(), 0);
                }
                evil.move();
            }

            while (this.playGround.isOverTopRight(ivo.getPosition())) {
                if (this.playGround.isUnderBottomLeft(ivo.getPosition())) {
                    sum += this.playGround.getValue(ivo.getPosition());
                }
                ivo.move();
            }

            command = Reader.readLine();
        }

        ConsolePrinter.printLine(String.valueOf(sum));
    }
}
