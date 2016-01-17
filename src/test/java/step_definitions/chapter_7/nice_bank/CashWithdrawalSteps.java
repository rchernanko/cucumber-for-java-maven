/*

The code below + the cash_withdrawal.feature is an exercise done from the cucumber book starting on page 117.

*/

package step_definitions.chapter_7.nice_bank;

import cucumber.api.PendingException;
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

    KnowsMyAccount helper;

    public CashWithdrawalSteps() {
        helper = new KnowsMyAccount();
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
    public void i_withdraw_£(int amount)
            throws Throwable {
        Teller teller = new Teller();
        teller.withdrawFrom(helper.getMyAccount(), amount);
    }

    @Then("^£(\\d+) should be dispensed$")
    public void £_should_be_dispensed(int arg1)
            throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
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

    public void withdrawFrom(Account account, int pounds) {

    }
}

class KnowsMyAccount {

    private Account myAccount;

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
        }
        return myAccount;
    }
}
