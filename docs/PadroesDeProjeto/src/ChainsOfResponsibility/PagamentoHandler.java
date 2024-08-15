package ChainsOfResponsibility;

public class PagamentoHandler extends BaseHandler {
    @Override
    public String handle(Request request) {
        if (request.isPagamentoValidado()) {
            System.out.println("Pagamento validado.");
            return super.handle(request);
        } else {
            return "Pedido rejeitado: pagamento não validado.";
        }
    }
}
