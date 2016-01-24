package support.chapter_7.nice_bank;

import implementation.chapter_7.nice_bank.Account;
import implementation.chapter_7.nice_bank.CashSlot;
import implementation.chapter_7.nice_bank.Teller;

public class KnowsTheDomain {

    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
        }
        return myAccount;
    }

    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }

    public Teller getTeller() {
        if (teller == null) {
            teller = new AtmUserInterface();
        }
        return teller;
    }
}
