package P04TrafficLights;

import input.Reader;
import output.ConsolePrinter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<TrafficLight> trafficLights =
                Arrays.stream(Reader.readStringArray(" "))
                        .map(c -> new TrafficLight(Colors.valueOf(c)))
                        .collect(Collectors.toList());
        int counter = Reader.readIntArray(" ")[0];

        while (counter-- > 0){
            ConsolePrinter.printLine(trafficLights.stream()
                    .map(tl -> tl.getColor().toString())
                    .collect(Collectors.joining(" ")));
        }
    }
}
