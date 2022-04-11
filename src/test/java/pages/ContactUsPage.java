package pages;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Waiters;
import java.util.logging.Level;

public class ContactUsPage extends CommonPage{

    Waiters waiters = new Waiters(Hooks.getDriver(),13);

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    //Subject Heading dropdown
    @FindBy(css = "#id_contact")
    private WebElement subjectDropDown;

    //Email Address field
    @FindBy(id = "email")
    private WebElement emailAddressField;

    //Order reference field
    @FindBy(id = "id_order")
    private WebElement OrderRefField;

    //User message
    @FindBy(id = "message")
    private WebElement messageMemo;

    //Send button
    @FindBy(id = "submitMessage")
    private WebElement sendBtn;

    //Alert message
    @FindBy(css = "#center_column > p")
    private WebElement alertMessage;


    public void selectSubject(String subject) {
        waiters.waitingForElementVisibility(sendBtn);
        Select select = new Select(subjectDropDown);
        select.selectByVisibleText(subject);
        LOG.log(Level.INFO, "Selecting subject: " + subject);
    }

    public void enterEmail(String email) {
        emailAddressField.sendKeys(email);
        LOG.log(Level.INFO, "Filling email address: " + email);
    }

    public void enterOrderRef(String order) {
        OrderRefField.sendKeys(order);
        LOG.log(Level.INFO, "Entering order reference " + order);
    }

    public void clickSend() {
        sendBtn.click();
    }

    public void enterMessage(String message) {
        messageMemo.sendKeys(message);
        LOG.log(Level.INFO, "Entering message " + message);
    }

    public String getAlert() {
        Waiters waiters = new Waiters(Hooks.getDriver(),13);
        waiters.waitingForElementVisibility(alertMessage);
        LOG.log(Level.INFO, "Alert is shown " + alertMessage);
        return alertMessage.getText();
    }

}
