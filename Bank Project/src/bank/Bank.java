
package bank;


public class Bank {
    private String accountNumber;
    private double balance; 
    
public Bank(String accountNumber) {
    this.accountNumber = accountNumber;
    this.balance = 0;    
    }

public String getAccountNumber() {
    return accountNumber;
}

public double getBalance() {
    return balance;
}

 public boolean withdraw(double amount) {
        if (amount > balance || amount < 0) return false;
        balance = balance - amount;
        return true;
    }

public boolean deposit(double amount) {
         if (amount < 0) return false;
         balance = balance + amount;
         return true;
    }

}