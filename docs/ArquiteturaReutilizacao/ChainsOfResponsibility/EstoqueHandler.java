package ChainsOfResponsibility;

public class EstoqueHandler extends BaseHandler {
    @Override
    public String handle(Request request) {
        if (request.isEstoqueDisponivel()) {
            System.out.println("Estoque verificado.");
            return super.handle(request);
        } else {
            return "Pedido rejeitado: estoque insuficiente.";
        }
    }
}
