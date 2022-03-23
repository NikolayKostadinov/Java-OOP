package P04PizzaCalories;

import input.Reader;

public class Main {
    public static void main(String[] args) {
        String[] pizzaArguments = Reader.readStringArray("\\s+");
        String[] doughArguments = Reader.readStringArray("\\s+");
        String[] toppingArguments = Reader.readStringArray("\\s+");

        try {
            Pizza pizza = new Pizza(pizzaArguments[1], Integer.parseInt(pizzaArguments[2]));
            Dough dough = new Dough(doughArguments[1], doughArguments[2], Double.parseDouble(doughArguments[3]));
            pizza.setDough(dough);
            while (!"END".equals(toppingArguments[0])) {
                Topping topping = new Topping(toppingArguments[1], Double.parseDouble(toppingArguments[2]));
                pizza.addTopping(topping);
                toppingArguments = Reader.readStringArray("\\s+");
            }

            System.out.println(pizza);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
