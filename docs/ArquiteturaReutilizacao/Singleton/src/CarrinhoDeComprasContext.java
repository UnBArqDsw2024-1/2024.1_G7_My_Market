package src;

import java.util.List;

public class CarrinhoDeComprasContext {
    private CarrinhoDeComprasManager carrinhoManager;

    public CarrinhoDeComprasContext() {
        carrinhoManager = CarrinhoDeComprasManager.getInstance();
    }

    public void adicionarItemAoCarrinho(Item item) {
        carrinhoManager.getCarrinho().adicionarItem(item);
    }

    public void removerItemDoCarrinho(Item item) {
        carrinhoManager.getCarrinho().removerItem(item);
    }

    public List<Item> listarItensDoCarrinho() {
        return carrinhoManager.getCarrinho().getItens();
    }
}
