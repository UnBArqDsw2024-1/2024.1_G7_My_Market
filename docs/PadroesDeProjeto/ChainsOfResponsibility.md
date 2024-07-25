# Chain of Responsibility - GoF Comportamental

## 1. Introdução

O Chain of Responsibility é um padrão de projeto comportamental que permite que pedidos sejam enviados por uma cadeia de handlers (manipuladores). Cada handler na cadeia tem a oportunidade de processar o pedido ou passá-lo para o próximo handler. Este padrão promove o desacoplamento entre o remetente do pedido e seus receptores, facilitando a adição ou modificação de handlers sem impactar os demais componentes do sistema.

## 2. Objetivo
No aplicativo My Market, um pedido precisa passar por várias etapas de validação e processamento antes de ser aprovado. Cada uma dessas etapas pode ser gerenciada por um módulo diferente do sistema. Por exemplo:

- Verificação de Estoque: Primeira etapa onde o sistema verifica se o item solicitado está disponível em estoque.
- Validação de Pagamento: Após a verificação de estoque, o sistema valida as informações de pagamento do cliente.
- Aprovação do Gerente: Finalmente, o pedido pode necessitar de uma aprovação adicional por parte de um gerente, especialmente para transações de alto valor ou itens restritos.

Cada uma dessas etapas é responsabilidade de um handler específico. O padrão Chain of Responsibility permite que o pedido seja passado sequencialmente por cada handler, onde cada um decide se processa o pedido ou o encaminha para o próximo handler. Isso promove uma estrutura flexível e modular, facilitando a manutenção e a expansão do sistema.

## 3. Implementação
...
### 3.1. Diagrama UML


Modelagem a seguir foi criada utilizando a ferramenta online [Lucidchart](https://www.lucidchart.com/pages/) pelos alunos [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan).

![image](https://github.com/user-attachments/assets/767e17d8-0009-4954-a945-230d875ed61e)


<h6 align = "center">Figura 01: Diagrama de Classes utilizando o padrão comportamental Chains of Responsibility. Fonte: Mateus Orlando, Pedro Lucas e Thiago Vivan.</h6>

### 3.2. Código

O código em java a seguir foi desenvolvido pelos alunos [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan).

```java
public interface Handler {
    Handler setNext(Handler handler);
    String handle(Request request);
}

public abstract class BaseHandler implements Handler {
    private Handler nextHandler;

    @Override
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    @Override
    public String handle(Request request) {
        if (this.nextHandler != null) {
            return this.nextHandler.handle(request);
        }
        return null;
    }
}

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

public class Request {
    private boolean estoqueDisponivel;
    private boolean pagamentoValidado;
    private boolean aprovadoPeloGerente;

    public boolean isEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public void setEstoqueDisponivel(boolean estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public boolean isPagamentoValidado() {
        return pagamentoValidado;
    }

    public void setPagamentoValidado(boolean pagamentoValidado) {
        this.pagamentoValidado = pagamentoValidado;
    }

    public boolean isAprovadoPeloGerente() {
        return aprovadoPeloGerente;
    }

    public void setAprovadoPeloGerente(boolean aprovadoPeloGerente) {
        this.aprovadoPeloGerente = aprovadoPeloGerente;
    }
}
```



## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.

## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0    | Inicio da estrutura do documento. | [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan) | - | 22/07/2024 | x |
| 2.0    | Adição o código da implementação do GoF.  | [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan) | - | 22/07/2024 | x |
| 3.0    | Adição do Diagrama.   | [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan) | - | 22/07/2024 | x |
| 3.1    | Pequenos Ajustes nos textos do diagrama e no do código.   | [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan) | - | 22/07/2024 | x |
