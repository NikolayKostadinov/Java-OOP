package P05Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public class InputInterpreter {
    private CalculationEngine engine;
    private Map<String, Supplier<Operation>> operations = new HashMap<>();
    private List<Integer> memory;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memory = new ArrayList<>();
        initOperations();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        } catch (Exception ex) {
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    private void initOperations() {
        this.operations.put("*", () -> new MultiplicationOperation());
        this.operations.put("/", () -> new DivisionOperation());
        this.operations.put("ms", () -> new MemorySaveOperation(memory));
        this.operations.put("mr", () -> new MemoryRecallOperation(memory));
    }

    public Operation getOperation(String operation) {
        if (operations.containsKey(operation)) {
            return this.operations.get(operation).get();
        }

        return null;
    }
}
