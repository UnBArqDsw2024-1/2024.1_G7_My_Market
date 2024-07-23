# Adapter - GoF Estrutural

## 1. Introdução

O padrão Adapter permite que interfaces incompatíveis trabalhem juntas. Ele funciona como um intermediário que converte a interface de uma classe em outra interface que um cliente espera.

## 2. Objetivo

O objetivo do padrão Adapter é permitir que classes com interfaces incompatíveis colaborem entre si. Isso é particularmente útil quando você deseja usar uma classe existente, mas sua interface não corresponde àquela esperada pelo cliente.

## 3. Implementação


### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Miro](https://miro.com/app/board/).

<!--- 
Colocar imagem
-->

<h6 align = "center">Figura 01</h6>

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

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.
## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0 | Criação do documento | [Guilherme Soares](https://github.com/GuilhermeSoaress) / [Miguel de Frias](https://github.com/migueldefrias) | [Guilherme Basílio](https://github.com/GuilhermeBES) | 22/07/2024 | 22/07/2024 |