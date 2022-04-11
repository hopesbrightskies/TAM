package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Waiters;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonPage {
    WebDriver driver;

    Waiters waiters = new Waiters(Hooks.getDriver(),15);

    static final Logger LOG = Logger.getLogger(CommonPage.class.getName());

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openPage(String url) {
        driver.get(url);
        LOG.log(Level.INFO, "Navigating to page: " + url);
    }
}
