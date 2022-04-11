package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Level;

public class CartPage extends CommonPage{

    public CartPage(WebDriver driver) {super(driver);}

    @FindBy(id = "total_price")
    private WebElement total;

    @FindAll(@FindBy(xpath = "//small[@class='cart_ref']"))
    List<WebElement> cartRefs;

    @FindAll(@FindBy(xpath = "//table[@id='cart_summary']//p[@class='product-name']"))
    List <WebElement> productsInCart;

    @FindAll(@FindBy(xpath = "//span[@class='price']//span[@class='price']"))
    List <WebElement> prices;

    public boolean isProductInCart(String productID, String productName) {
        waiters.waitingForElementVisibility(total);
        LOG.log(Level.INFO,  "Verifying product in the cart");
        for (WebElement cartReference: cartRefs) {
            if (cartReference.getText().contains(productID)) {
                String productNameInCart = productsInCart.get(cartRefs.indexOf(cartReference)).getText();
                return productNameInCart.equals(productName);
            }
        }
        return false;
    }


}
