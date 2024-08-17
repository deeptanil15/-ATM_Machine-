import java.util.Scanner;
class atm{
    float balance;
    int pin=5678;
    public void checkpin() {
        System.out.println("Enter your pin");
        Scanner sc = new Scanner(System.in);
        int enterpin = sc.nextInt();
        if (enterpin == pin) {
            menu();
        } else {
            System.out.println("Invalid Pin");
        }
    }
    public void menu(){
        System.out.println("Enter your choice");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();
        if(choice==1)
        {
            checkbalance();
        }
        else if (choice==2)
        {
            withdrawmoney();
        }
        else if (choice==3)
        {
            depositmoney();
        } else if (choice==4)
        {
            System.out.println("Thank you for visiting :) ");
        }
        else {
            System.out.println("Enter a valid choice : ");
            menu();
        }
    }
    public void checkbalance(){
        System.out.println("Balance"+balance);
        menu();
    }
    public void withdrawmoney() {
        System.out.println("Enter amount to Withdraw");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - amount;
            System.out.println("Money withdrawn succsessfully");
        }
        menu();
    }
    public void depositmoney() {
        System.out.println("Enter your Amount");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance = balance + amount;
        System.out.println("Money deposited succsessfully");
        menu();
    }
}
public class deep {
    public static void main(String[] args) {
        atm a = new atm();
        a.checkpin();
    }
}
