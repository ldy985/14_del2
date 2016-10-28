package Game;

public class Account {

    private int balance = 1000;

    public boolean addBalance(int amount) {
        balance = balance + amount;

        if (balance < 0) {

            balance = 0;
        }
        return true;
    }

    public int getBalance() {
        return balance;
    }

}