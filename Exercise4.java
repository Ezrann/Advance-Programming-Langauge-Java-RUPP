import java.util.ArrayList;
import java.util.Scanner;

class Account {
    public int accountNo;
    public String name;
    public double balance;
    public String password;

    // Constructor to initialize account
    public Account(int accountNo, String name, double balance, String password) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    // Check the password matches the account password or not
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // Withdraw amount function
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Deposit amount function
    public void deposit(double amount) {
        balance += amount;
    }

    // Transfer amount function
    public boolean transfer(Account targetAccount, double amount) {
        if (withdraw(amount)) {
            targetAccount.deposit(amount);
            return true;
        } else {
            return false;
        }
    }
}

class LoginManager {

    ArrayList<Account> accounts;
    Scanner scanner = new Scanner(System.in);

    // Constructor  to initialize LoginManager with accounts
    public LoginManager(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    // Method for user login
    public Account login() {
        while (true) {
            System.out.print("Enter account number: ");
            int accountNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // Find account with the given account number
            Account account = findAccount(accountNo);
            // If account exists and password is correct, return the account
            if (account != null && account.checkPassword(password)) {
                return account;
            } else {
                System.out.println("Invalid account number or password. Please try again.");
            }
        }
    }

    // Method to find an account by account number
    public Account findAccount(int accountNo) {
        for (Account account : accounts) {
            if (account.accountNo == accountNo) {
                return account;
            }
        }
        return null;// Return null if account not found
    }
}

public class Exercise4 {

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        accounts.add(new Account(1, "Ah Peal", 1000, "AhPeal"));
        accounts.add(new Account(2, "Ah Kbob", 2000, "AhKbob"));
        accounts.add(new Account(3, "Ah Kbank", 3000, "AhKbank"));
        accounts.add(new Account(4, "Ah Kmoew", 4000, "AhKmoew"));
        accounts.add(new Account(5, "Ah Lok", 5000, "Ahlok"));

        LoginManager loginManager = new LoginManager(accounts);
        Account loggedInAccount = loginManager.login();

        if (loggedInAccount != null) {
            System.out.println("Welcome, " + loggedInAccount.name + "!");
            Operation(loggedInAccount, scanner, loginManager);
        } else {
            System.out.println("Failed to login. Exiting program.");
        }
    }

    static void Operation(Account account, Scanner scanner, LoginManager loginManager) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("a. Balance");
            System.out.println("b. Withdraw");
            System.out.println("c. Deposit");
            System.out.println("d. Transfer");
            System.out.println("e. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "a":
                    // Display balance
                    System.out.println("Your balance is: $" + account.balance);
                    break;
                case "b":
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    // Check if withdrawal is successful
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdraw $" + withdrawAmount + ". New balance is: $" + account.balance);
                    } else {
                        System.out.println("Error...! Please try again");
                    }
                    break;
                case "c":
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    account.deposit(depositAmount);
                    System.out.println("Deposited $" + depositAmount + ". New balance is: $" + account.balance);
                    break;
                case "d":
                    System.out.print("Enter the target account number: ");
                    int targetAccountNo = scanner.nextInt();
                    scanner.nextLine(); 
                    Account targetAccount = loginManager.findAccount(targetAccountNo);
                    if (targetAccount != null) {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        scanner.nextLine(); 
                        if (account.transfer(targetAccount, transferAmount)) {
                            System.out.println("Transferred $" + transferAmount + " to account " + targetAccountNo + ". New balance is: $" + account.balance);
                        } else {
                            System.out.println("Insufficient funds.");
                        }
                    } else {
                        System.out.println("Target account not found.");
                    }
                    break;
                case "e":
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //next() reads a tokenized text based on a given delimiter (whitespace by default)
//// nextLine() places the scanner position on the next line after reading the input.
//// The nextDouble() is a method of Java Scanner class which is used to scan the next token of the input as a double.
//// In Java, delimiters are characters that separate the strings into tokens
}
