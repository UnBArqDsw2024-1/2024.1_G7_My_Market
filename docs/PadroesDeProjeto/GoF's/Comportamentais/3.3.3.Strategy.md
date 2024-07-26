# Strategy - GoF Comportamental

## 1. Introdução

O padrão de projeto Strategy é um dos 23 padrões de design documentados pelos "Gang of Four" (GoF) no livro "Design Patterns: Elements of Reusable Object-Oriented Software". Este padrão é categorizado como um padrão comportamental, que lida com a responsabilidade e a comunicação entre objetos.

O padrão Strategy permite definir uma família de algoritmos, encapsular cada um deles em uma classe separada e torná-los intercambiáveis. O Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam. Isso facilita a manutenção e a extensão do código, pois novas estratégias podem ser introduzidas sem modificar as existentes.

## 2. Objetivo

O principal objetivo do padrão Strategy é permitir que diferentes algoritmos sejam selecionados e aplicados em tempo de execução sem que o cliente precise conhecer os detalhes de implementação dos algoritmos. Ele visa resolver problemas relacionados à variação do comportamento de uma aplicação, onde um algoritmo específico precisa ser escolhido dentre vários disponíveis.

Os principais benefícios do padrão Strategy incluem:

Encapsulamento de Algoritmos: Cada algoritmo é encapsulado em sua própria classe, promovendo a separação de responsabilidades e facilitando a manutenção e a compreensão do código.

Intercambiabilidade: Algoritmos podem ser alterados ou substituídos sem modificar o código do cliente que os utiliza. Isso proporciona grande flexibilidade e extensibilidade ao sistema.

Isolamento de Código Complexo: Complexidade do algoritmo fica isolada em classes específicas, reduzindo a complexidade do código do cliente.

## 3. Implementação



### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Lucidchart](https://www.lucidchart.com/pages/).

![image](https://github.com/user-attachments/assets/0acdd8d7-5962-4e8e-badb-8d1c38e0b535)


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
| 1.2 | Finalizando documento | [Artur Rodrigues](https://github.com/ArturRSA19)| [João Costa](https://github.com/jvcostta) | 22/07/2024 | 22/07/2024 |
