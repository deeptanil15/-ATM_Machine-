# ATM Machine Using JAVA OOPS Concepts

## 1. Project Overview :

I developed a simple ATM machine simulation using Java that allows users to perform basic banking operations like checking balance, withdrawing money, depositing money, and exiting the system. The project implements key OOP principles, including encapsulation, inheritance, abstraction, and polymorphism, making the design more modular and maintainable.

## 2. Key Classes and Structure :

I used multiple classes to represent the different components of the ATM system. Here’s a summary of the key classes and their roles:

a. ATM Class
This class represents the core functionality of the ATM machine. It handles the interaction with the user, such as selecting options for transactions.
The main methods include:
withdraw()
deposit()
checkBalance()
exit()
b. BankAccount Class
This class stores the account details and manages the balance of a user.
Attributes:
accountNumber (Encapsulated to protect account details)
balance
accountHolderName
Methods:
getBalance(): Returns the current balance.
deposit(double amount): Adds money to the account balance.
withdraw(double amount): Deducts money from the account if sufficient balance is available.
c. User Class
This class represents the ATM user or account holder.
Attributes:
userID
PIN
Methods:
authenticate(): Validates user credentials like userID and PIN before allowing access to ATM services.
It also allows changing the PIN securely using setter and getter methods (encapsulation).

## 3. Object-Oriented Principles Used :

### a. Encapsulation :

I encapsulated the user’s account details and the balance in the BankAccount class. The sensitive information (like accountNumber, balance, and PIN) is made private and can only be accessed or modified via getter and setter methods. This protects the data and ensures that any updates to these attributes go through validation logic (e.g., ensuring enough balance for withdrawals).
java
Copy code
public class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter and setter methods to encapsulate data
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

### b. Abstraction :

I created an interface called ATMServices that abstracts basic operations like withdrawal, deposit, and balance inquiry, allowing different ATM implementations to use these services without worrying about the underlying details.
java
Copy code
public interface ATMServices {
    void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
}
### c. Inheritance :

If I had multiple types of accounts (e.g., SavingsAccount, CheckingAccount), I could use inheritance to extend the BankAccount class, allowing for shared functionality across all account types while still permitting specific behaviors for different account types.
java
Copy code
public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }
}

### d. Polymorphism :

I utilized polymorphism by implementing the ATMServices interface in different classes or extending the BankAccount class. This allowed me to create methods like withdraw() and deposit() that behave differently based on the specific account type, making the system flexible for different banking needs.
java
Copy code
ATMServices atm = new ATMImplementation();
atm.deposit(500);
atm.withdraw(200);
4. ATM Workflow
Here’s a brief explanation of how the system works:

User Authentication: The system first asks the user to enter their userID and PIN. The User class handles this and authenticates the input by comparing it with stored credentials.
java
Copy code
public boolean authenticate(String userID, String enteredPIN) {
    return this.userID.equals(userID) && this.PIN.equals(enteredPIN);
}
Transaction Options: Once authenticated, the ATM system provides options to the user:
Check Balance: The system calls getBalance() from the BankAccount class to display the user’s current balance.
Deposit: The system calls the deposit() method to add money to the user’s balance.
Withdraw: The system calls the withdraw() method, which ensures the balance is sufficient before completing the transaction.
Exit: Exits the system after a transaction.
java
Copy code
public void showMenu() {
    System.out.println("Welcome to the ATM!");
    System.out.println("1: Check Balance");
    System.out.println("2: Deposit");
    System.out.println("3: Withdraw");
    System.out.println("4: Exit");
}

## 5. Code Example :

Here’s a simplified version of how I structured the core interaction:

java
Copy code
public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
    }
}

## 6. Conclusion : 

In summary, I created an ATM machine simulation in Java by applying key OOP principles like encapsulation to secure sensitive information, inheritance to manage different account types, abstraction to simplify interactions, and polymorphism to enhance flexibility. The ATM allows users to perform basic banking transactions while ensuring the system is scalable and maintainable for future enhancements.









