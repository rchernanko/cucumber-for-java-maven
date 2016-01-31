package cucumber_book.support.chapter_7.nice_bank;

import cucumber_book.hooks.ServerHooks;
import implementation.chapter_7.nice_bank.Account;
import implementation.chapter_7.nice_bank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AtmUserInterface implements Teller {

    private final EventFiringWebDriver webDriver;

    public AtmUserInterface(EventFiringWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void withdrawFrom(Account account, int pounds) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("Amount"))
                .sendKeys(String.valueOf(pounds));
        webDriver.findElement(By.id("Withdraw")).click();
    }
}
