package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    WebDriverWait webDriverWait;

    public Waiters(WebDriver driver, int timeOut) {
        this.webDriverWait = new WebDriverWait(driver, timeOut);
    }

    public WebElement waitingForElementVisibility(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean waitingForTextPresence(WebElement element, String text) {
        return webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

}
