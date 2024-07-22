# Strategy - GoF Comportamental

## 1. Introdução



## 2. Objetivo



## 3. Implementação



### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Lucidchart](https://www.lucidchart.com/pages/).

<!--- 
Colocar imagem
-->

<h6 align = "center">Figura 01 Fonte: Artur Rodrigues Sousa Alves e João Víctor Costa Andrade</h6>

### 3.2. Código

```java
// Interface da Estratégia
interface EstrategiaPagamento {
    void processarPagamento(double valor);
}

// Estratégia Concreta: Pagamento com Cartão de Crédito
class PagamentoCartaoCredito implements EstrategiaPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Cartão de Crédito.");
    }
}

// Estratégia Concreta: Pagamento com PayPal
class PagamentoPayPal implements EstrategiaPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PayPal.");
    }
}

// Estratégia Concreta: Pagamento com Transferência Bancária
class PagamentoTransferenciaBancaria implements EstrategiaPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Transferência Bancária.");
    }
}

// Contexto
class Pagamento {
    private EstrategiaPagamento estrategia;

    public void setEstrategia(EstrategiaPagamento estrategia) {
        this.estrategia = estrategia;
    }

    public void processarPagamento(double valor) {
        this.estrategia.processarPagamento(valor);
    }
}

// Cliente
public class Main {
    public static void main(String[] args) {
        Pagamento pagamento = new Pagamento();

        // Pagamento via Cartão de Crédito
        pagamento.setEstrategia(new PagamentoCartaoCredito());
        pagamento.processarPagamento(100.0);

        // Pagamento via PayPal
        pagamento.setEstrategia(new PagamentoPayPal());
        pagamento.processarPagamento(200.0);

        // Pagamento via Transferência Bancária
        pagamento.setEstrategia(new PagamentoTransferenciaBancaria());
        pagamento.processarPagamento(300.0);
    }
}
```


## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.
## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0 | Criação do documento | [Artur Rodrigues](https://github.com/ArturRSA19)| [João Costa](https://github.com/jvcostta) | 22/07/2024 | 22/07/2024 |
| 1.1 | Adicionando código | [Artur Rodrigues](https://github.com/ArturRSA19)| [João Costa](https://github.com/jvcostta) | 22/07/2024 | 22/07/2024 |