import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Food(8, "Banana"));
        products.add(new Electronics(200, "Smartwatch"));

        Visitor discountA = new DiscountA();
        Visitor discountB = new DiscountB();

        System.out.println("Aplicando disconto A:");
        for (Product product : products) {
            product.accept(discountA);
        }

        System.out.println("\nAplicando disconto B:");
        for (Product product : products) {
            product.accept(discountB);
        }
    }
}
