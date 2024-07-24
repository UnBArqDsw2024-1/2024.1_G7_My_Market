public class DiscountA implements Visitor {
    @Override
    public void visit(Food food) {
        System.out.println("Aplicando 10% de desconto na comida: " + food.getName());
        double discountedPrice = food.getPrice() * 0.9;
        System.out.println("Preço com desconto: " + discountedPrice);
    }

    @Override
    public void visit(Electronics electronics) {
        System.out.println("Aplicando 5% de desconto nos eletronicos: " + electronics.getName());
        double discountedPrice = electronics.getPrice() * 0.95;
        System.out.println("Preço com desconto: " + discountedPrice);
    }
}
