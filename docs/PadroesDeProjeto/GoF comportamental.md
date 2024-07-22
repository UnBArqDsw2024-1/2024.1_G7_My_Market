# Command - GoF Comportamental

## 1. Introdução

O padrão Command encapsula uma solicitação como um objeto, permitindo que você parametrize clientes com diferentes solicitações, filas ou logs de solicitações, e suporte operações que podem ser desfeitas.

## 2. Objetivo

O objetivo do padrão Command é desacoplar o objeto que invoca a operação daquele que conhece como executá-la. Isso permite maior flexibilidade no design, facilitando a implementação de operações como desfazer (undo), refazer (redo) e registro de comandos.

## 3. Implementação


### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Miro](https://miro.com/app/board/).

<!--- 
Colocar imagem
-->

<h6 align = "center">Figura 01</h6>

### 3.2. Código

// Command Interface
    interface Command {
        void execute();
    }

    // Receiver
    class Cart {
        public void addItem(String item) {
            System.out.println("Added " + item + " to cart");
        }

    public void removeItem(String item) {
        System.out.println("Removed " + item + " from cart");
    }
    }

    // Concrete Commands
    class AddItemCommand implements Command {
        private Cart cart;
        private String item;

        public AddItemCommand(Cart cart, String item) {
            this.cart = cart;
            this.item = item;
        }

        @Override
        public void execute() {
            cart.addItem(item);
        }
    }

    class RemoveItemCommand implements Command {
        private Cart cart;
        private String item;

        public RemoveItemCommand(Cart cart, String item) {
            this.cart = cart;
            this.item = item;
        }

        @Override
        public void execute() {
            cart.removeItem(item);
        }
    }

    // Invoker
    class OrderProcessor {
        public void execute(Command command) {
            command.execute();
        }
    }

    // Uso do padrão
    public class Main {
        public static void main(String[] args) {
            Cart cart = new Cart();
            OrderProcessor orderProcessor = new OrderProcessor();

            Command addItemCommand = new AddItemCommand(cart, "Product 1");
            Command removeItemCommand = new RemoveItemCommand(cart, "Product 1");

            orderProcessor.execute(addItemCommand);
            orderProcessor.execute(removeItemCommand);
        }
    }

## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.
## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0 | Criação do documento | [Guilherme Soares](https://github.com/GuilhermeSoaress) / [Miguel de Frias](https://github.com/migueldefrias) | [Guilherme Basílio](https://github.com/GuilhermeBES) | 22/07/2024 | 22/07/2024 |