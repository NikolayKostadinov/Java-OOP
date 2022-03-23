package P05Calculator;

import java.util.List;

public class MemoryRecallOperation implements Operation {

    private final List<Integer> memory;
    private int result;

    public MemoryRecallOperation(List<Integer> memory) {
        this.memory = memory;
        this.result = this.memory.isEmpty() ? 0 : this.memory.remove(this.memory.size() - 1);
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
