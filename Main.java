// Parent class that defines the general payment processing behavior.
class PaymentProcessor {

    // Generic method that can be overridden by child classes.
    void processPayment(double amount) {
        // This message shows that a general payment is being processed.
        System.out.println("Processing payment of $" + amount);
    }

    // Overloaded method that accepts both amount and coupon code.
    void processPayment(double amount, String couponCode) {
        // This message shows that a payment with a coupon is being processed.
        System.out.println("Processing payment of $" + amount + " with coupon: " + couponCode);
    }
}

// Child class for processing credit card payments.
class CreditCardProcessor extends PaymentProcessor {

    // Overrides the parent's payment method with credit card logic.
    @Override
    void processPayment(double amount) {
        // This message represents credit card payment processing.
        System.out.println("Credit Card payment processed: $" + amount);
    }

    // Overrides the parent's overloaded method with credit card coupon logic.
    @Override
    void processPayment(double amount, String couponCode) {
        // This message represents a credit card payment using a coupon.
        System.out.println("Credit Card payment processed: $" + amount + " using coupon " + couponCode);
    }
}

// Child class for processing PayPal payments.
class PayPalProcessor extends PaymentProcessor {

    // Overrides the parent's payment method with PayPal logic.
    @Override
    void processPayment(double amount) {
        // This message represents PayPal payment processing.
        System.out.println("PayPal payment processed: $" + amount);
    }

    // Overrides the parent's overloaded method with PayPal coupon logic.
    @Override
    void processPayment(double amount, String couponCode) {
        // This message represents a PayPal payment using a coupon.
        System.out.println("PayPal payment processed: $" + amount + " using coupon " + couponCode);
    }
}

// Main class where the program starts running.
public class Main {

    // Main method is the starting point of the Java program.
    public static void main(String[] args) {

        // Parent reference points to a CreditCardProcessor object.
        PaymentProcessor payment1 = new CreditCardProcessor();

        // Parent reference points to a PayPalProcessor object.
        PaymentProcessor payment2 = new PayPalProcessor();

        // Calls the CreditCardProcessor version at runtime.
        payment1.processPayment(100);

        // Calls the PayPalProcessor version at runtime.
        payment2.processPayment(200);

        // Calls the CreditCardProcessor overloaded method with a coupon.
        payment1.processPayment(100, "SAVE10");

        // Calls the PayPalProcessor overloaded method with a coupon.
        payment2.processPayment(200, "SAVE20");
    }
}