# Command - GoF Comportamental

## 1. Introdução

Para o processamento de pedidos, usaremos o padrão Command, onde diferentes comandos representam diferentes operações (adicionar item, remover item, etc.).

## 2. Objetivo



## 3. Implementação

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


### 3.1. Diagrama UML
Modelagem utilizando a ferramenta online [Miro](https://miro.com/app/board/).

<!--- 
Colocar imagem
-->

<h6 align = "center">Figura 01</h6>

### 3.2. Código



## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.
## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0 | Criação do documento | [Guilherme Soares](https://github.com/GuilhermeSoaress) / [Miguel de Frias](https://github.com/migueldefrias) | [Guilherme Basílio](https://github.com/GuilhermeBES) | 22/07/2024 | 22/07/2024 |