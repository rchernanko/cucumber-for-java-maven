package step_definitions.chapter_7.nice_bank;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import implementation.chapter_7.nice_bank.Money;
import org.junit.Assert;
import support.KnowsMyDomain;
import transforms.chapter_7.nice_bank.MoneyConverter;

public class AccountSteps {

    //Great piece of information - before Cucumber is run, it will create an instance of this step definition class (if
    //called by the feature file it is running). At the end of a scenario, this instance is then disposed of.

    //So if you need to share state between steps (in the same scenario), you could do something like the below (using
    //an AccountSteps constructor that will ALWAYS be called when an instance of the class is created) - e.g. when
    //cucumber creates an instance of this class at the beginning

    KnowsMyDomain helper;

    public AccountSteps(KnowsMyDomain helper) {
        this.helper = helper;
    }

    //Of course, when you split your step definitions out into different classes (which i have done now - e.g. instead
    //of one CashWithdrawalSteps class, we now have AccountSteps, TellerSteps and CashSlotSteps), you then need to use
    //dependency injections to manage this (see pages 136 to 138 in the book for more details). I have implemented DI
    //in my other step defs within this chapter 7 > nice bank package

    @Given("^I have deposited (\\£\\d+\\.\\d+) in my account$")
    public void i_have_deposited_£_in_my_account(@Transform(MoneyConverter.class) Money amount)
            throws Throwable {
        helper.getMyAccount().deposit(amount);
        Assert.assertEquals("Incorrect account balance - ", amount, helper.getMyAccount().getBalance());
    }
}
