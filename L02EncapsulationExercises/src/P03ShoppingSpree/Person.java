package P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    private void setMoney(double money) {
        if (money < 0) throw new IllegalArgumentException("Money cannot be negative");
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            String message = String.format("%s can't afford %s", this.name, product.getName());
            throw new IllegalArgumentException(message);
        }

        this.products.add(product);
        this.money -= product.getCost();
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name,
                this.products.isEmpty() ? "Nothing bought"
                        : this.products.stream().map(p -> p.getName())
                        .collect(Collectors.joining(", "))
        );
    }
}
