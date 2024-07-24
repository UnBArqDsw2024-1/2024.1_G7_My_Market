// Classe base Product
abstract class Product {
    protected double price;
    protected String name;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Subclasse Food
class Food extends Product {
    public Food(double price, String name) {
        this.price = price;
        this.name = name;
    }
}

// Subclasse Eletronics
class Eletronics extends Product {
    public Eletronics(double price, String name) {
        this.price = price;
        this.name = name;
    }
}

// Classe abstrata ProductFactory
abstract class ProductFactory {
    public abstract Product createProduct();
}

// Subclasse FoodFactory
class FoodFactory extends ProductFactory {
    private double price;
    private String name;

    public FoodFactory(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public Product createProduct() {
        return new Food(price, name);
    }
}

// Subclasse EletronicsFactory
class EletronicsFactory extends ProductFactory {
    private double price;
    private String name;

    public EletronicsFactory(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public Product createProduct() {
        return new Eletronics(price, name);
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        ProductFactory foodFactory = new FoodFactory(10.0, "Banana");
        Product food = foodFactory.createProduct();
        System.out.println("Product: " + food.getName() + ", Preço: " + food.getPrice());

        ProductFactory electronicsFactory = new EletronicsFactory(299.99, "Smartwatch");
        Product electronics = electronicsFactory.createProduct();
        System.out.println("Product: " + electronics.getName() + ", Preço: " + electronics.getPrice());
    }
}
