package src;

public class CarrinhoDeComprasManager {
    private static CarrinhoDeComprasManager instance = null;
    private CarrinhoDeCompras carrinho;

    private CarrinhoDeComprasManager() {
        carrinho = new CarrinhoDeCompras();
    }

    public static CarrinhoDeComprasManager getInstance() {
        if (instance == null) {
            instance = new CarrinhoDeComprasManager();
        }
        return instance;
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }
}