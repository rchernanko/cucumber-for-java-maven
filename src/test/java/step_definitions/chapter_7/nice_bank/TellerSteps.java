package step_definitions.chapter_7.nice_bank;

import cucumber.api.java.en.When;
import support.KnowsMyDomain;

public class TellerSteps {

    KnowsMyDomain helper;

    public TellerSteps(KnowsMyDomain helper) {
        this.helper = helper;
    }

    @When("^I withdraw £(\\d+)$")
    public void i_withdraw_£(int pounds)
            throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), pounds);
    }
}
