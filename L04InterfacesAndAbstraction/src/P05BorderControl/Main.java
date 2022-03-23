package P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while(!"End".equals(command)){
            String[] identifiableParams = command.split("\\s+");
            if (identifiableParams.length == 3){
                String name = identifiableParams[0];
                int age = Integer.parseInt(identifiableParams[1]);
                String id = identifiableParams[2];
                identifiables.add(new Citizen(name, age, id));
            } else if (identifiableParams.length == 2){
                String model = identifiableParams[0];
                String id = identifiableParams[1];
                identifiables.add(new Robot(model, id));
            }
            command = scan.nextLine();
        }

        String endOfFakeIds = scan.nextLine();
        printFakeIds(identifiables, endOfFakeIds);
    }

    private static void printFakeIds(List<Identifiable> identifiables, String endOfFakeIds) {
        identifiables
                .stream()
                .filter(i->i.getId().endsWith(endOfFakeIds))
                .forEach(i-> System.out.println(i.getId()));
    }
}
