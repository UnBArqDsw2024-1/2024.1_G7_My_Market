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