package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.Categories;
import utils.SubCategories;
import java.util.logging.Level;

public class HomePage extends CommonPage {

    public static String HOME_PAGE_URL = "http://automationpractice.com/index.php"; // made this public since there is only one Home page across the project

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // HomePage's own openPage method
    public void openPage() {
        super.openPage(HOME_PAGE_URL);
    }

    //Sign in link
    @FindBy(className = "login")
    private WebElement signInLink;

    //Contact us link
    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    //Search field
    @FindBy(id = "search_query_top")
    private WebElement searchField;

    // Dresses menu
    @FindBy(xpath = "//li/a[@title='Dresses' and not(following::a[@title='Dresses'])]")
    WebElement dressesMenu;

    @FindBy(xpath = "//a[@title='Casual Dresses' and preceding::li/a[@title='Women']]")
    WebElement casualDressesSubMenu;

    @FindBy(xpath = "//a[@title='Evening Dresses' and preceding::li/a[@title='Women']]")
    WebElement eveningDressesSubMenu;

    @FindBy(xpath = "//a[@title='Summer Dresses' and preceding::li/a[@title='Women']]")
    WebElement summerDressesSubMenu;

    // T-shirts menu
    @FindBy(xpath = "//li/a[@title='T-shirts' and not(following::a[@title='T-shirts'])]")
    private WebElement tShirtsMenu;

    // Women menu
    @FindBy(xpath = "//li/a[@title='Women']")
    private WebElement womenMenu;


    public void clickSignInLink() {
        waiters.waitingForElementVisibility(signInLink);
        signInLink.click();
        LOG.log(Level.INFO,  "Navigating to Sign in page.");
    }

    public void clickContactUsLink() {
        waiters.waitingForElementVisibility(contactUsLink);
        contactUsLink.click();
        LOG.log(Level.INFO,  "Navigating to Contact Us page.");
    }

    public void searchFor(String product) {
        waiters.waitingForElementVisibility(searchField);
        searchField.sendKeys(product);
        searchField.submit();
        LOG.log(Level.INFO,  "Searching for: " + product);

    }

    public void selectProduct(Categories category, SubCategories subcategory) {
        waiters.waitingForElementVisibility(tShirtsMenu);
        Actions actions = new Actions(Hooks.getDriver());
        switch (category) {
            case DRESSES:
                switch (subcategory){
                    case CASUAL_DRESSES:
                        actions.moveToElement(dressesMenu).moveToElement(casualDressesSubMenu).click().build().perform();
                        break;
                    case EVENING_DRESSES:
                        actions.moveToElement(dressesMenu).moveToElement(eveningDressesSubMenu).click().build().perform();
                        break;
                    case SUMMER_DRESSES:
                        actions.moveToElement(dressesMenu).moveToElement(summerDressesSubMenu).click().build().perform();
                        break;
                    default:
                        actions.moveToElement(dressesMenu).click().build().perform();
                }
                break;

            case T_SHIRTS:
                actions.moveToElement(tShirtsMenu).click().build().perform();
                break;

            case WOMEN:
                actions.moveToElement(womenMenu).click().build().perform();
                break;
        }
        LOG.log(Level.INFO,  "Selecting " + category + "category, " + subcategory + " subcategory.");
    }
}
