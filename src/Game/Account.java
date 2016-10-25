package Game;

public class Account {

    private int balance = 1000;

    public boolean addBalance(int amount) {
        balance = balance + amount;
        return true;
    }

    public int getBalance() {
        return balance;
    }

    public boolean setBalance(int x) {
        balance = x;
        return true;
    }

}