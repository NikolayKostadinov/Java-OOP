package P06GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Bag {
    private long capacity;
    private long totalQuantity;
    private final Map<ItemType, Map<String, Long>> bag;
    private long gold;
    private long gem;
    private long cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.bag = new LinkedHashMap<>();
    }

    private boolean canTake(Item item) {
        if (this.capacity < this.totalQuantity + item.getQuantity()) return false;
        switch (item.getType()) {
            case CASH:
                return cash + item.getQuantity() <= this.gem;
            case GEM:
                return this.gem + item.getQuantity() <= this.gold;
            case GOLD:
                return true;
            default:
                return false;
        }
    }

    public void addItem(Item item) {
        if (this.canTake(item)) {
            bag.putIfAbsent(item.getType(), new LinkedHashMap<>());
            bag.get(item.getType()).putIfAbsent(item.getName(), 0L);
            bag.get(item.getType()).put(item.getName(), bag.get(item.getType()).get(item.getName()) + item.getQuantity());
            totalQuantity += item.getQuantity();
            switch (item.getType()){
                case GOLD :
                    this.gold += item.getQuantity();
                    break;
                case GEM :
                    this.gem += item.getQuantity();
                    break;
                case CASH :
                    this.cash += item.getQuantity();
                    break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        bag.entrySet().stream()
                .forEach(x -> {
                    Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();
                    sb.append(String.format("<%s> $%s", x.getKey().getDisplayText(), sumValues));
                    if (!x.getValue().entrySet().isEmpty()) {
                        sb.append(System.lineSeparator());
                        x.getValue().entrySet()
                                .stream()
                                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                                .forEach(i ->
                                        sb.append("##" + i.getKey() + " - " + i.getValue())
                                                .append(System.lineSeparator()));
                    }
                });
        return sb.toString().trim();
    }
}
