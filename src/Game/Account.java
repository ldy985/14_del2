package Game;

// Keeps track of the balance, and adds/subtracts by the points on the board.
public class Account {

    private int balance;

    // Sets the initial balance of the two players.
    public Account(int initialBalance) {
        balance = initialBalance;
    }

    // Adds/subtracts point to/from the balance by the given amount.
    public boolean addBalance(int amount) {
        balance = balance + amount;

        // Makes sure the balance won't be a negative number.
        if (balance < 0) {

            balance = 0;
        }
        return true;
    }

    // Return the balance.
    public int getBalance() {
        return balance;
    }

}