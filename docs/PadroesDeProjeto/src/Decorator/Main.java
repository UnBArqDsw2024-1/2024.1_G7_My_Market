// Classe base Product
abstract class Product {
    protected double price;
    protected String name;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Classe Food que herda de Product
class Food extends Product {
    public Food(double price, String name) {
        super(price, name);
    }
}

// Classe Electronics que herda de Product
class Electronics extends Product {
    public Electronics(double price, String name) {
        super(price, name);
    }
}

// Classe abstrata DiscountDecorator que herda de Product
abstract class DiscountDecorator extends Product {
    protected Product product;

    public DiscountDecorator(Product product) {
        super(product.getPrice(), product.getName());
        this.product = product;
    }

    @Override
    public abstract double getPrice();
}

// Classe PercentageDiscountDecorator que herda de DiscountDecorator
class PercentageDiscountDecorator extends DiscountDecorator {
    private double percentage;

    public PercentageDiscountDecorator(Product product, double percentage) {
        super(product);
        this.percentage = percentage;
    }

    @Override
    public double getPrice() {
        return product.getPrice() * (1 - percentage / 100);
    }
}

// Classe FixedDiscountDecorator que herda de DiscountDecorator
class FixedDiscountDecorator extends DiscountDecorator {
    private double amount;

    public FixedDiscountDecorator(Product product, double amount) {
        super(product);
        this.amount = amount;
    }

    @Override
    public double getPrice() {
        return product.getPrice() - amount;
    }
}

// Classe principal para testar o código
public class Main {
    public static void main(String[] args) {
        // Criando produtos
        Product banana = new Food(1.0, "Banana");
        Product smartwatch = new Electronics(250.0, "Smartwatch");

        // Aplicando descontos
        Product discountedBanana = new PercentageDiscountDecorator(banana, 10); // 10% de desconto
        Product discountedSmartwatch = new FixedDiscountDecorator(smartwatch, 50); // Desconto fixo de $50

        // Exibindo preços originais e descontados
        System.out.println("Produto: " + banana.getName() + ", Preço Original: $" + banana.getPrice());
        System.out.println("Produto: " + discountedBanana.getName() + ", Preço com Desconto: $" + discountedBanana.getPrice());

        System.out.println("Produto: " + smartwatch.getName() + ", Preço Original: $" + smartwatch.getPrice());
        System.out.println("Produto: " + discountedSmartwatch.getName() + ", Preço com Desconto: $" + discountedSmartwatch.getPrice());
    }
}
