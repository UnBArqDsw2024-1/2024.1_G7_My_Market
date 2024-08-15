package ChainsOfResponsibility;

public class GerenteHandler extends BaseHandler {
    @Override
    public String handle(Request request) {
        if (request.isAprovadoPeloGerente()) {
            System.out.println("Aprovado pelo gerente.");
            return super.handle(request);
        } else {
            return "Pedido rejeitado: não aprovado pelo gerente.";
        }
    }
}
