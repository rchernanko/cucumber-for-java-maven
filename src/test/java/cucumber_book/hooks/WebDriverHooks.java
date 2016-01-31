package cucumber_book.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber_book.support.chapter_7.nice_bank.KnowsTheDomain;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

public class WebDriverHooks {

    private KnowsTheDomain helper;

    public WebDriverHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @After
    public void finish(Scenario scenario) {
        try {
            byte[] screenshot = helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            helper.getWebDriver().close();
        }
    }
}
