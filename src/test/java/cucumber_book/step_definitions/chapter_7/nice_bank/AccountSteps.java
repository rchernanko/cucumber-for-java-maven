package cucumber_book.step_definitions.chapter_7.nice_bank;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import implementation.chapter_7.nice_bank.Money;
import org.junit.Assert;
import cucumber_book.support.chapter_7.nice_bank.KnowsTheDomain;
import cucumber_book.transforms.chapter_7.nice_bank.MoneyConverter;

public class AccountSteps {

    //Great piece of information - before Cucumber is run, it will create an instance of this step definition class (if
    //called by the feature file it is running). At the end of a scenario, this instance is then disposed of.

    //So if you need to share state between steps (in the same scenario), you could do something like the below (using
    //an AccountSteps constructor that will ALWAYS be called when an instance of the class is created) - e.g. when
    //cucumber creates an instance of this class at the beginning

    KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    //Of course, when you split your step definitions out into different classes (which i have done now - e.g. instead
    //of one CashWithdrawalSteps class, we now have AccountSteps, TellerSteps and CashSlotSteps), you then need to use
    //dependency injections to manage this (see pages 136 to 138 in the book for more details). I have implemented DI
    //in my other step defs within this chapter 7 > nice bank package

    @Given("^my account has been credited with (\\£\\d+\\.\\d+)$")
    public void my_account_has_been_credited_with(@Transform(MoneyConverter.class) Money amount)
            throws Throwable {
        helper.getMyAccount().credit(amount);
    }

    @Then("^the balance of my account should be (\\£\\d+\\.\\d+)$")
    public void the_balance_of_my_account_should_be_£(@Transform(MoneyConverter.class) Money amount)
            throws Throwable {
        Assert.assertEquals("Incorrect account balance - ", amount, helper.getMyAccount().getBalance());
    }
}
