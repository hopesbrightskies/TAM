package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.logging.Level;

public class ProductPage extends CommonPage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@itemprop='name']")
    WebElement productName;

    @FindBy(css = "#our_price_display")
    WebElement productPrice;

    public boolean verifyNameAndPrice(String name, String price) {
        waiters.waitingForElementVisibility(productName);
        boolean result = name.equals(productName.getText()) && price.equals(productPrice.getText());
        LOG.log(Level.INFO,  "Do name and price comply with expected?: " + result);
        return result;
    }
}
