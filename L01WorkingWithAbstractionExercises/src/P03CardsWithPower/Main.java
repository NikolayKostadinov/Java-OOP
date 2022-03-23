package P03CardsWithPower;

import input.Reader;
import output.ConsolePrinter;

public class Main {
    public static void main(String[] args) {
        Ranks rank = Ranks.valueOf(Reader.readLine());
        Suits suit = Suits.valueOf(Reader.readLine());
        Card card = new Card(rank, suit);
        ConsolePrinter.printLine(card.toString());
    }
}
