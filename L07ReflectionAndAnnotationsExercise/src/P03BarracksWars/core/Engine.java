package P03BarracksWars.core;

import P03BarracksWars.interfaces.Repository;
import P03BarracksWars.interfaces.Runnable;
import P03BarracksWars.interfaces.Unit;
import P03BarracksWars.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String result;
        switch (commandName) {
            case "add":
                result = this.addUnitCommand(data);
                break;
            case "report":
                result = this.reportCommand(data);
                break;
            case "fight":
                result = this.fightCommand(data);
                break;
            default:
                throw new RuntimeException("Invalid command!");
        }
        return result;
    }

    private String reportCommand(String[] data) {
        String output = this.repository.getStatistics();
        return output;
    }

    private String addUnitCommand(String[] data){
        String unitType = data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }

    private String fightCommand(String[] data) {
        return "fight";
    }
}
