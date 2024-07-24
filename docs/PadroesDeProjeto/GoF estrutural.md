# Adapter - GoF Estrutural

## 1. Introdução

O padrão Adapter permite que interfaces incompatíveis trabalhem juntas. Ele funciona como um intermediário que converte a interface de uma classe em outra interface que um cliente espera.

## 2. Objetivo

O objetivo do padrão Adapter é permitir que classes com interfaces incompatíveis colaborem entre si. Isso é particularmente útil quando você deseja usar uma classe existente, mas sua interface não corresponde àquela esperada pelo cliente.

## 3. Implementação



### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Miro](https://miro.com/app/board/).

<div align = "center"><img src="" alt="Diagrama UML">
<p>Figura 1 - Diagrama UML<br> Autor: Guilherme Basilio e Miguel de Frias</p></div>


#### Descrição das classes e interfaces:

ThirdPartyPayment:

- Método: pay(int amount): Este método representa a funcionalidade de pagamento usando um serviço de pagamento de terceiros.

Payment:

- Método: makePayment(int amount): Esta interface define o método de pagamento que precisa ser implementado.

PaymentAdapter:

- Atributo: thirdPartyPayment: ThirdPartyPayment: Este atributo armazena uma referência à instância de ThirdPartyPayment.
- Construtor: PaymentAdapter(thirdPartyPayment: ThirdPartyPayment): Este construtor inicializa o adaptador com uma instância de ThirdPartyPayment.
- Método: makePayment(int amount): Este método adapta a chamada para o método pay(int amount) da classe ThirdPartyPayment.

#### Funcionamento do Padrão Adapter

- ThirdPartyPayment é uma classe existente que tem um método pay(int amount) que não é compatível com a interface Payment esperada pelo cliente.
- A interface Payment define o método makePayment(int amount) que o cliente usa.
- PaymentAdapter implementa a interface Payment e adapta a chamada ao método pay(int amount) de ThirdPartyPayment para que seja compatível com a interface Payment.
- O cliente pode usar a interface Payment para fazer pagamentos sem se preocupar com os detalhes de implementação de ThirdPartyPayment.

Este diagrama ilustra como o padrão Adapter permite que uma classe existente (ThirdPartyPayment) seja usada onde uma interface diferente (Payment) é esperada, adaptando as chamadas de método de maneira transparente para o cliente.
### 3.2. Código

    // Adapter
    class ThirdPartyPayment {
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using third-party payment service");
        }
    }

    // Target
    interface Payment {
        void makePayment(int amount);
    }

    // Adapter
    class PaymentAdapter implements Payment {
        private ThirdPartyPayment thirdPartyPayment;

        public PaymentAdapter(ThirdPartyPayment thirdPartyPayment) {
            this.thirdPartyPayment = thirdPartyPayment;
        }

        @Override
        public void makePayment(int amount) {
            thirdPartyPayment.pay(amount);
        }
    }

    // Uso do padrão
    public class Main {
        public static void main(String[] args) {
            ThirdPartyPayment thirdPartyPayment = new ThirdPartyPayment();
            Payment payment = new PaymentAdapter(thirdPartyPayment);

            payment.makePayment(100);
        }
    }

## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Estruturais**. Material de apoio em slides. Milene Serrano. 

> **Padrões de Projetos - Estruturais - Adapter . Disponível em: <https://refactoring.guru/pt-br/design-patterns/adapter>. Acesso em: 23 de julho de 2024.**

## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0 | Criação do documento | [Guilherme Soares](https://github.com/GuilhermeSoaress) / [Miguel de Frias](https://github.com/migueldefrias) | [Guilherme Basílio](https://github.com/GuilhermeBES) | 22/07/2024 | 22/07/2024 |
| 1.1 | Adição do Diagrama UML | [Guilherme Basílio](https://github.com/GuilhermeBES) e [Miguel de Frias](https://github.com/migueldefrias) | [Guilherme Soares](https://github.com/GuilhermeSoaress)| 23/07/2024 | - |