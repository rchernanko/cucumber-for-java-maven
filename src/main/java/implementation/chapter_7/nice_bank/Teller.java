package implementation.chapter_7.nice_bank;

public class Teller {

    private CashSlot cashSlot;

    public Teller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, int pounds) {
        cashSlot.dispense(pounds);
    }

}
