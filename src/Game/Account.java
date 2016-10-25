public class Account {

    int balance = 1000;

    boolean addBalance(int amount) {
        balance=balance + amount;
        return true;
    }

    int getBalance() {
        return balance;
    }
    boolean setBalance(int x) {
        balance=x;
        return true;
    }

}