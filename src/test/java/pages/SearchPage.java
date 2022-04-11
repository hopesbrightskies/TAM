package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.logging.Level;


public class SearchPage extends CommonPage{

    public SearchPage(WebDriver driver) {super(driver);}

    private static String name;
    private static String price;

    @FindBy(xpath = "//*[@class='lighter']")
    private WebElement searchResult;

    @FindAll({@FindBy(xpath = "//*[@id='center_column']//*[@class='product-name']")})
    List<WebElement> productNames;

    @FindAll({@FindBy(xpath = "//*[@class='right-block']//*[@class='price product-price']")})
    List <WebElement> productPrices;

    @FindAll({@FindBy(xpath = "//*[@title='View']//span")})
    List <WebElement> moreButtons;

    public static String getProductName() {
        return name;
    }

    public static String getProductPrice() {
        return price;
    }

    public String getSearchResult() {
        String result;
        waiters.waitingForElementVisibility(searchResult);
        result = searchResult.getText().substring(1, searchResult.getText().length()-1).toLowerCase();
        LOG.log(Level.INFO,  "Search result: " + result);
        return result;
    }

    public void saveInfo(int number) {
        name = productNames.get(number-1).getText();
        price = productPrices.get(number-1).getText();
        LOG.log(Level.INFO,  "Product: " + name + ", price: " + price);
    }

    public void clickMoreButton(int number) {
        waiters.waitingForElementVisibility(searchResult);
        Actions action = new Actions(Hooks.getDriver());
        action.moveToElement(productNames.get(number-1)).moveToElement(moreButtons.get(number-1)).click().build().perform();
    }
}
