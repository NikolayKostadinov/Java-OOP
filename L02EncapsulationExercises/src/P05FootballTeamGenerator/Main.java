package P05FootballTeamGenerator;

import input.Reader;
import output.ConsolePrinter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static Map<String, Team> teams = new LinkedHashMap<>();

    public static void main(String[] args) {
        String[] command = Reader.readStringArray(";");

        while (!"END".equals(command[0])) {
            try {
                executeCommand(command);
            } catch (IllegalArgumentException ex) {
                ConsolePrinter.printLine(ex.getMessage());
            }
            command = Reader.readStringArray(";");
        }

    }

    private static void executeCommand(String[] command) {
        switch (command[0]) {
            case "Team":
                teams.put(command[1], new Team(command[1]));
                break;
            case "Add":
                if (!teams.containsKey(command[1])) {
                    String message = String.format("Team %s does not exist.", command[1]);
                    throw new IllegalArgumentException(message);
                }
                teams.get(command[1])
                        .addPlayer(
                                new Player(command[2],
                                        Integer.parseInt(command[3]),
                                        Integer.parseInt(command[4]),
                                        Integer.parseInt(command[5]),
                                        Integer.parseInt(command[6]),
                                        Integer.parseInt(command[7])));
                break;
            case "Remove":
                if (teams.containsKey(command[1])) {
                    teams.get(command[1]).removePlayer(command[2]);
                }
                break;
            case "Rating":
                if (!teams.containsKey(command[1])) {
                    String message = String.format("Team %s does not exist.", command[1]);
                    throw new IllegalArgumentException(message);
                }

                String message = String.format("%s - %.0f", command[1], teams.get(command[1]).getRating());
                ConsolePrinter.printLine(message);
                break;
        }
    }
}
