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