package P05Calculator;

import java.util.List;

public class MemorySaveOperation implements Operation {
    private final List<Integer> memory;
    private Integer result;
    public MemorySaveOperation(List<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.result = operand;

        if (this.isCompleted()){
            this.memory.add(this.result);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return result != null;
    }
}
