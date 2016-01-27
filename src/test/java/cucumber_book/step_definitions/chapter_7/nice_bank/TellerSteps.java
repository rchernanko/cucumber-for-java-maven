package cucumber_book.step_definitions.chapter_7.nice_bank;

import cucumber.api.java.en.When;
import cucumber_book.support.chapter_7.nice_bank.KnowsTheDomain;

public class TellerSteps {

    KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @When("^I withdraw £(\\d+)$")
    public void i_withdraw_£(int pounds)
            throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), pounds);
    }
}
