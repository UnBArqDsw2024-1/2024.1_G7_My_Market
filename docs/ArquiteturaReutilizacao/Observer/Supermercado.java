public class Supermercado {
    public static void main(String[] args) {
        Produto leite = new Produto("Leite", 4.0);

        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");

        leite.adicionarObservador(cliente1);
        leite.adicionarObservador(cliente2);

        // Produto entra em promoção
        leite.setEmPromocao(true);

        // Remover um cliente da lista de observadores
        leite.removerObservador(cliente1);

        // Produto sai de promoção
        leite.setEmPromocao(false);

        // Produto volta para a promoção
        leite.setEmPromocao(true); 
    
    }
}
