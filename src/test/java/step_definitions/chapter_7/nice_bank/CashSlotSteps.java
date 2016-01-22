package step_definitions.chapter_7.nice_bank;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import support.chapter_7.nice_bank.KnowsMyDomain;

public class CashSlotSteps {

    KnowsMyDomain helper;

    public CashSlotSteps(KnowsMyDomain helper) {
        this.helper = helper;
    }

    @Then("^£(\\d+) should be dispensed$")
    public void £_should_be_dispensed(int pounds)
            throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed", pounds, helper.getCashSlot().getContents());
    }
}
