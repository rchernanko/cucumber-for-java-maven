package implementation.chapter_7.nice_bank;

public class AutomatedTeller implements Teller {

    private CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, int pounds) {
        account.debit(pounds);
        cashSlot.dispense(pounds);
    }
}
