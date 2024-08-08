import java.util.Scanner;

class CreditCard {
    // Attributes of Credit Card
    private String cardNumber ;
    private String userName;
    private String expirationDate;
    private String securityCode;
    private Double creditLimit;
    private Double currentBalance;

    // Constructor with parameter
    public CreditCard(String cardNumber, String userName, String expirationDate, String securityCode, Double creditLimit) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.creditLimit = creditLimit;
        this.currentBalance = 0.0;
    }
//  used to protect your data, particularly when creating classes
    // Getters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    // Behaviors
    public boolean makingPurchase(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid purchase amount.");
            return false;  // Credit limit exceeded (lers)
        }
        if (currentBalance + amount > creditLimit) {
            System.out.println("Purchase declined. Credit limit exceeded.");
            return false;
        }
        currentBalance += amount;
        System.out.println("Purchase approved. New balance : " + currentBalance);
        return true;  // Purchase successful
    }

    public boolean makingPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount.");
            return false;
        }
        currentBalance -= amount;
        System.out.println("Payment received. New balance: " + currentBalance);
        return true;
    }

    public void CardDetails() {
        System.out.println("Card Number of credit card : " + cardNumber);
        System.out.println("Card Holder of credit card : " + userName);
        System.out.println("Expiration Date of credit card : " + expirationDate);
        System.out.println("Credit Limit of credit card : " + creditLimit);
        System.out.println("Current Balance in credit card : " + currentBalance);
    }
}

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a new CreditCard instance
        CreditCard myCard = new CreditCard("1234 5678 9101 1121", "Bunrong", "07/26", "6383", 10000.00);

        // Print initial card details
        myCard.CardDetails();

        // The users can purchase 3times

        for (int i = 0; i < 3; i++) {  // Allow user to make three purchases
            System.out.println("\nEnter the amount you want to purchase :");
            double purchaseAmount = scanner.nextDouble();
            myCard.makingPurchase(purchaseAmount);
        }

        System.out.println("\nEnter the amount you want to pay :");
        double paymentAmount = scanner.nextDouble();
        myCard.makingPayment(paymentAmount);

        // display the final detail of credit card
        System.out.println("\nFinal Detail of Credit Card :");
        myCard.CardDetails();

    }
}
/* public class Exercise6 {
    public static void main(String[] args) {
        // Creating a new CreditCard instance
        CreditCard myCard = new CreditCard("1234 5678 9101 1121", "John Doe", "12/25", "123", 5000.00);

        // Print initial card details
        myCard.printCardDetails();

        // Test making a purchase
        System.out.println("\nMaking a purchase of $1500...");
        myCard.makePurchase(1500.00);

        // Test making another purchase
        System.out.println("\nMaking a purchase of $4000...");
        myCard.makePurchase(4000.00);

        // Test making a payment
        System.out.println("\nMaking a payment of $1000...");
        myCard.makePayment(1000.00);

        // Test making another purchase within limit
        System.out.println("\nMaking a purchase of $2500...");
        myCard.makePurchase(2500.00);

        // Print final card details
        System.out.println("\nFinal card details:");
        myCard.printCardDetails();
    }
}*/

