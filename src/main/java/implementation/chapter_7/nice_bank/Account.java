package implementation.chapter_7.nice_bank;

public class Account {

    private Money balance = new Money();

    public void credit(Money amount) {
        balance = balance.add(amount);
    }

    public void debit(int pounds) {
        balance = balance.minus(new Money(pounds, 0));
    }

    public Money getBalance() {
        return balance;
    }
}
