package cucumber_book.support.chapter_7.nice_bank;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import implementation.chapter_7.nice_bank.Account;
import implementation.chapter_7.nice_bank.Teller;

import cucumber_book.hooks.ServerHooks;

class AtmUserInterface implements Teller {

    private final EventFiringWebDriver webDriver;

    public AtmUserInterface(EventFiringWebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void withdrawFrom(Account account, int pounds) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("amount"))
                .sendKeys(String.valueOf(pounds));
        webDriver.findElement(By.id("withdraw")).click();
    }
}
