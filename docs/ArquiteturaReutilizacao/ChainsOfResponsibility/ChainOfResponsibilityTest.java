package ChainsOfResponsibility;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        // Criar os handlers
        Handler estoqueHandler = new EstoqueHandler();
        Handler pagamentoHandler = new PagamentoHandler();
        Handler gerenteHandler = new GerenteHandler();

        // Configurar a cadeia de responsabilidade
        estoqueHandler.setNext(pagamentoHandler).setNext(gerenteHandler);

        // Criar um objeto de request que passará pela cadeia
        Request request1 = new Request();
        request1.setEstoqueDisponivel(true);
        request1.setPagamentoValidado(true);
        request1.setAprovadoPeloGerente(true);

        // Teste 1: Todos os passos são bem-sucedidos
        System.out.println("Teste 1: " + estoqueHandler.handle(request1)); // Esperado: cadeia completa sem rejeições

        // Teste 2: Estoque insuficiente
        Request request2 = new Request();
        request2.setEstoqueDisponivel(false);
        request2.setPagamentoValidado(true);
        request2.setAprovadoPeloGerente(true);

        System.out.println("Teste 2: " + estoqueHandler.handle(request2)); // Esperado: Pedido rejeitado: estoque insuficiente.

        // Teste 3: Pagamento não validado
        Request request3 = new Request();
        request3.setEstoqueDisponivel(true);
        request3.setPagamentoValidado(false);
        request3.setAprovadoPeloGerente(true);

        System.out.println("Teste 3: " + estoqueHandler.handle(request3)); // Esperado: Pedido rejeitado: pagamento não validado.

        // Teste 4: Não aprovado pelo gerente
        Request request4 = new Request();
        request4.setEstoqueDisponivel(true);
        request4.setPagamentoValidado(true);
        request4.setAprovadoPeloGerente(false);

        System.out.println("Teste 4: " + estoqueHandler.handle(request4)); // Esperado: Pedido rejeitado: não aprovado pelo gerente.
    }
}

