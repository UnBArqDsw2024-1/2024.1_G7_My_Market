// Prototype Interface
interface Prototype<T> {
    T clone();
}

// Product class implementing Prototype
class Product implements Prototype<Product> {
    private String name;
    private double price;

public Product(String name, double price) {
    this.name = name;
    this.price = price;
}

public String getName() {
    return name;
}

public double getPrice() {
    return price;
}

@Override
public Product clone() {
    return new Product(this.name, this.price);
}

@Override
public String toString() {
    return "Product{name='" + name + "', price=" + price + "}";
    }
}

// ProductRegistry to manage prototypes
class ProductRegistry {
    private Map<String, Product> prototypes = new HashMap<>();

    public void addPrototype(String key, Product prototype) {
        prototypes.put(key, prototype);
    }

    public Product createProduct(String key) {
        Product prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        } else {
            throw new IllegalArgumentException("Prototype not found for key: " + key);
        }
    }
}

// Uso do padrão Prototype
public class Main {
    public static void main(String[] args) {
        ProductRegistry registry = new ProductRegistry();

        // Adicionando protótipos ao registro
        Product bread = new Product("Bread", 2.50);
        Product milk = new Product("Milk", 3.00);
        registry.addPrototype("Bread", bread);
        registry.addPrototype("Milk", milk);

        // Criando novos produtos a partir dos protótipos
        Product breadClone1 = registry.createProduct("Bread");
        Product breadClone2 = registry.createProduct("Bread");
        Product milkClone1 = registry.createProduct("Milk");

        System.out.println(breadClone1);
        System.out.println(breadClone2);
        System.out.println(milkClone1);
    }
}