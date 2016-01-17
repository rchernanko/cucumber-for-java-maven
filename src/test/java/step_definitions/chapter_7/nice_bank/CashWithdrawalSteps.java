/*

The code below + the cash_withdrawal.feature is an exercise done from the cucumber book starting on page 117.

*/

package step_definitions.chapter_7.nice_bank;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import implementation.chapter_7.Money;
import org.junit.Assert;

public class CashWithdrawalSteps {

    //Prior to adding a Money class, this is what the given step def looked like. It took only 1 integer and not 2

//    @Given("^I have deposited £(\\d+) in my account$")
//    public void i_have_deposited_£_in_my_account(int amount) throws Throwable {
//        Account myAccount = new Account();
//        myAccount.deposit(amount);
//        Assert.assertEquals("Incorrect account balance - ", amount, myAccount.getBalance());
//    }

    @Given("^I have deposited £(\\d+\\.\\d+) in my account$")
    public void i_have_deposited_£_in_my_account(Money amount) throws Throwable {
        Account myAccount = new Account();
        myAccount.deposit(amount);

        Assert.assertEquals("Incorrect account balance - ", amount, myAccount.getBalance());
    }


    @When("^I request £(\\d+)$")
    public void i_request_£(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^£(\\d+) should be dispensed$")
    public void £_should_be_dispensed(int arg1) throws Throwable {
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
