package implementation.chapter_7.nice_bank;

public class Account {

    private Money balance = new Money();

    public void deposit(Money amount) {
        balance = balance.add(amount);
    }

    public Money getBalance() {
        return balance;
    }
}
