package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;
import java.util.List;
import java.util.logging.Level;

public class CategoriesPage extends CommonPage{

    public CategoriesPage(WebDriver driver) { super(driver);}

    Waiters waiters = new Waiters(Hooks.getDriver(), 13);

    private static String productID;
    private static String productName;
    private static String productPrice;

    @FindBy(id = "pagination_bottom")
    private WebElement pagination;

    @FindAll({@FindBy(xpath = "//*[@id='center_column']//*[@class='product-name']")})
    List <WebElement> products;

    @FindAll({@FindBy(xpath = "//*[@class='right-block']//*[@class='price product-price']")})
    List <WebElement> prices;

    @FindAll(@FindBy(xpath = "//a[@title='Add to cart']"))
    List<WebElement> addToCartButtons;

    @FindBy(id = "layer_cart")
    private WebElement cartPopUp;

    @FindBy(xpath = "//h2[i]")
    WebElement popUpMessage;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    public static String getProductID() {
        return productID;
    }

    public static String getProductName() {
        return productName;
    }

    public static String getProductPrice() {
        return productPrice;
    }

    public void addToCart(int number)  {
        Actions action = new Actions(Hooks.getDriver());
        waiters.waitingForElementVisibility(pagination); //easy check to see if page with products is loaded
        productID = addToCartButtons.get(number-1).getAttribute("data-id-product");
        productName = products.get(number-1).getText();
        productPrice = prices.get(number-1).getText();
        action.moveToElement(products.get(number-1)).moveToElement(addToCartButtons.get(number-1)).click().build().perform();
        LOG.log(Level.INFO,  "Adding : " + productName + " to the Cart, price: " + productPrice);
    }

    public boolean isProductAddedToCart(String message) {
        waiters.waitingForElementVisibility(cartPopUp);
        LOG.log(Level.INFO,  "Pop up message appears: " + popUpMessage.getText());
        return popUpMessage.getText().contains(message);
    }

    public void clickProceedToCheckout() {
        waiters.waitingForElementVisibility(cartPopUp);
        proceedToCheckoutButton.click();
        LOG.log(Level.INFO,  "Proceeding to checkout: ");
    }
}
