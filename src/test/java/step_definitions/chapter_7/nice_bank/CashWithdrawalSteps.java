/*

The code below + the cash_withdrawal.feature is an exercise done from the cucumber book starting on page 117.

*/

package step_definitions.chapter_7.nice_bank;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import implementation.chapter_7.Money;
import org.junit.Assert;
import transforms.chapter_7.MoneyConverter;

public class CashWithdrawalSteps {

    //Great piece of information - before Cucumber is run, it will create an instance of this class.
    //At the end of a scenario, this instance is then disposed of.

    //So if you need to share state between steps (in the same scenario), you could do something like the below (using
    //a CashWithDrawalSteps constuctor that will ALWAYS be called when an instance of the class is created) - e.g. when
    //cucumber creates an instance of this class at the beginning

    KnowsMyDomain helper;

    public CashWithdrawalSteps() {
        helper = new KnowsMyDomain();
    }

    //Prior to adding a Money class, this is what the given step def looked like. It took only 1 integer and not 2

    //    @Given("^I have deposited £(\\d+) in my account$")
    //    public void i_have_deposited_£_in_my_account(int amount) throws Throwable {
    //        Account myAccount = new Account();
    //        myAccount.deposit(amount);
    //        Assert.assertEquals("Incorrect account balance - ", amount, myAccount.getBalance());
    //    }

    @Given("^I have deposited (\\£\\d+\\.\\d+) in my account$")
    public void i_have_deposited_£_in_my_account(@Transform(MoneyConverter.class) Money amount)
            throws Throwable {
        helper.getMyAccount().deposit(amount);
        Assert.assertEquals("Incorrect account balance - ", amount, helper.getMyAccount().getBalance());
    }

    @When("^I withdraw £(\\d+)$")
    public void i_withdraw_£(int pounds)
            throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), pounds);
    }

    @Then("^£(\\d+) should be dispensed$")
    public void £_should_be_dispensed(int pounds)
            throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed", pounds, helper.getCashSlot().getContents());
    }

}

class KnowsMyDomain {

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
            teller = new Teller(getCashSlot());
        }
        return teller;
    }
}

class Account {
    private Money balance = new Money();

    public void deposit(Money amount) {
        balance = balance.add(amount);
    }

    public Money getBalance() {
        return balance;
    }
}

class Teller {
    private CashSlot cashSlot;

    public Teller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, int pounds) {
        cashSlot.dispense(pounds);
    }
}


class CashSlot {
    private int contents;

    public int getContents() {
        return contents;
    }

    public void dispense(int pounds) {
        contents = pounds;
    }
}
