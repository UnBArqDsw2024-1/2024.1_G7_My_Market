package src;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeComprasContext context = new CarrinhoDeComprasContext();
        Item item1 = new Item("Produto 1", 10.0);
        Item item2 = new Item("Produto 2", 20.0);

        context.adicionarItemAoCarrinho(item1);
        context.adicionarItemAoCarrinho(item2);

        System.out.println("Itens no carrinho:");
        for (Item item : context.listarItensDoCarrinho()) {
            System.out.println(item.getNome() + " - " + item.getPreco());
        }

        context.removerItemDoCarrinho(item1);

        System.out.println("Itens no carrinho após remoção:");
        for (Item item : context.listarItensDoCarrinho()) {
            System.out.println(item.getNome() + " - " + item.getPreco());
        }
    }
}